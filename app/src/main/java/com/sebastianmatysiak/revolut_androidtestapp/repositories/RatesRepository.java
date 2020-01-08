package com.sebastianmatysiak.revolut_androidtestapp.repositories;

import com.sebastianmatysiak.revolut_androidtestapp.RatesApiService;
import com.sebastianmatysiak.revolut_androidtestapp.models.RatesResponseBody;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RatesRepository {

    private static final String TAG = RatesRepository.class.getSimpleName();

    private static RatesRepository instance;
    private RatesApiService apiService;

    public static RatesRepository getInstance() {
        if (instance == null) {
            instance = new RatesRepository();
        }
        return instance;
    }

    private RatesRepository() {
        initApiService();
    }

    private void initApiService() {
        final String BASE_URL = "https://revolut.duckdns.org/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(RatesApiService.class);
    }

    public Single<RatesResponseBody> getLatestRates() {
        return apiService
                .getLatestRates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
