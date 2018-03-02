package com.example.harminder.currencyconverter;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.harminder.currencyconverter.Dagger2.CurrencyConverterModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject @Named("online")
    CurrencyConverter onlineCurrencyConverter;
    @Inject @Named("offline")
    CurrencyConverter offlineCurrencyConverter;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dagger2CurrencyConverterComponent.builder()
                .currencyConverterModule(new CurrencyConverterModule())
                .build()
                .inject(this);
    }

    private void calculateCurrency(double amount) {
        if (isNetworkConnected()) {
            onlineCurrencyConverter.convertPoundToDollar(amount, conversionListener);
        } else {
            offlineCurrencyConverter.convertPoundToDollar(amount, conversionListener);
        }
    }

    public void onClickView(View view) {
        EditText et = findViewById(R.id.editText);
        int value = Integer.valueOf(et.getText().toString());
        calculateCurrency(value);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private final CurrencyConverter.ConversionListener conversionListener = new CurrencyConverter.ConversionListener() {
        @Override
        public void onConversionStarted() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Getting rates...");
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        @Override
        public void convertedValue(double convertedValue) {
            TextView text = findViewById(R.id.text);
            text.setText(String.valueOf(convertedValue));
        }

        @Override
        public void onConversionCompleted() {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    };
}
