package com.example.harminder.currencyconverter.Dagger2;

import com.example.harminder.currencyconverter.CurrencyConverter;
import com.example.harminder.currencyconverter.OfflineCurrencyConverter;
import com.example.harminder.currencyconverter.OnlineCurrencyConverter;
import com.example.harminder.currencyconverter.api.CurrencyConverterApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harminder on 26/02/2018.
 */
@Module
public class CurrencyConverterModule {


    @Provides
    @Named("offline")
    CurrencyConverter provideCurrencyConverter(OfflineCurrencyConverter converter) {
        return converter;
    }

    @Provides
    @Named("online")
    CurrencyConverter provideOnlineCurrencyConverter(OnlineCurrencyConverter currencyConverter) {
        return currencyConverter;
    }

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.fixer.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    CurrencyConverterApi provideConverterApi(Retrofit retrofit) {
        return retrofit.create(CurrencyConverterApi.class);
    }
}
