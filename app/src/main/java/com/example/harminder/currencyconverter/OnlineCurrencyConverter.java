package com.example.harminder.currencyconverter;

import javax.inject.Inject;

/**
 * Created by Harminder on 26/02/2018.
 */

public class OnlineCurrencyConverter implements CurrencyConverter {

    private final CurrencyConverterDataSource dataSource;

    @Inject
    public OnlineCurrencyConverter(CurrencyConverterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void convertPoundToDollar(double amount, ConversionListener listener) {
        this.dataSource.getRates(amount, listener, "USD");
    }

    @Override
    public void convertPoundToEuro(double amount, ConversionListener listener) {
        this.dataSource.getRates(amount, listener, "EUR");
    }
}
