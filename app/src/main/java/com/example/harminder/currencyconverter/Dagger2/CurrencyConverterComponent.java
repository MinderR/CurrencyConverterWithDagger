package com.example.harminder.currencyconverter.Dagger2;

import com.example.harminder.currencyconverter.MainActivity;

import dagger.Component;

/**
 * Created by Harminder on 26/02/2018.
 */
@Component(modules = CurrencyConverterModule.class)

public interface CurrencyConverterComponent {
    void inject(MainActivity activity);
}
