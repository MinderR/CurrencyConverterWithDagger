package com.example.harminder.currencyconverter.api;

import com.example.harminder.currencyconverter.model.RatesResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Harminder on 26/02/2018.
 */

public interface CurrencyConverterApi {
    @GET("/latest?base=GBP")
    Observable<RatesResponse> getCurrencies();
}
