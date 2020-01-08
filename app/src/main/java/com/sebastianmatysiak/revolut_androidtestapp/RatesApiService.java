package com.sebastianmatysiak.revolut_androidtestapp;

import com.sebastianmatysiak.revolut_androidtestapp.models.RatesResponseBody;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RatesApiService {
    //TODO Add base as a param
    @GET("latest?base=EUR")
    Single<RatesResponseBody> getLatestRates();
}
