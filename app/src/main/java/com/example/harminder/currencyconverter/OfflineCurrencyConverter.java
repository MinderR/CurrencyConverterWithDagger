package com.example.harminder.currencyconverter;

import javax.inject.Inject;

/**
 * Created by Harminder on 26/02/2018.
 */

public class OfflineCurrencyConverter implements CurrencyConverter {

    @Inject
    public OfflineCurrencyConverter() {
    }

    @Override
    public void convertPoundToDollar(double amount, ConversionListener listener) {
        listener.convertedValue(amount * 1.40);
    }

    @Override
    public void convertPoundToEuro(double amount, ConversionListener listener) {
        listener.convertedValue(amount * 1.40);
    }
}
