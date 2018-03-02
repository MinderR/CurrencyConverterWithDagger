package com.example.harminder.currencyconverter;

/**
 * Created by Harminder on 26/02/2018.
 */

public interface CurrencyConverter {
    //double convertPoundToDollar(double amount);

   // double convertPoundToEuro(double amount);
   void convertPoundToDollar(final double amount, ConversionListener listener);

    void convertPoundToEuro(final double amount, ConversionListener listener);

    interface ConversionListener {

        void onConversionStarted();

        void convertedValue(double convertedValue);

        void onConversionCompleted();
    }
}
