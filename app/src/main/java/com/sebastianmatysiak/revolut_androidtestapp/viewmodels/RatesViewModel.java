package com.sebastianmatysiak.revolut_androidtestapp.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sebastianmatysiak.revolut_androidtestapp.Constants;
import com.sebastianmatysiak.revolut_androidtestapp.R;
import com.sebastianmatysiak.revolut_androidtestapp.models.RatesResponseBody;
import com.sebastianmatysiak.revolut_androidtestapp.repositories.RatesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RatesViewModel extends ViewModel {

    private static final String TAG = RatesViewModel.class.getSimpleName();

    private RatesRepository repository;
    private MutableLiveData<List<RatesItemViewModel>> ratesListLiveData;
    private CompositeDisposable disposables;

    public void init() {
        if (ratesListLiveData != null) {
            return;
        }
        repository = RatesRepository.getInstance();
        ratesListLiveData = new MutableLiveData<>();
        disposables = new CompositeDisposable();
    }

    public void startRatesUpdates(Context context) {
        disposables.add(Observable
                .interval(1, TimeUnit.SECONDS, Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(n -> getLatestRates())
                .retry()
                .subscribe(ratesResponseBodySingle -> disposables.add(ratesResponseBodySingle
                        .subscribe(ratesResponseBody -> ratesListLiveData
                                        .setValue(getRatesItemViewModelList(context, ratesResponseBody)),
                                error -> Log.e(TAG, "")))));
    }

    private Single<RatesResponseBody> getLatestRates() {
        return repository.getLatestRates();
    }

    private List<RatesItemViewModel> getRatesItemViewModelList(Context context, RatesResponseBody ratesResponseBody) {
        ArrayList<RatesItemViewModel> list = new ArrayList<>();

        list.add(
                new RatesItemViewModel(
                        R.drawable.european_union,
                        Constants.Currency.Acronym.EUROPEAN_UNION,
                        context.getString(R.string.currency_european_union_full_name),
                        getBaseCurrencyRate()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.australia,
                        Constants.Currency.Acronym.AUSTRALIA,
                        context.getString(R.string.currency_australia_full_name),
                        ratesResponseBody.getRates().getAud()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.bulgaria,
                        Constants.Currency.Acronym.BULGARIA,
                        context.getString(R.string.currency_bulgaria_full_name),
                        ratesResponseBody.getRates().getBgn()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.brazil,
                        Constants.Currency.Acronym.BRAZIL,
                        context.getString(R.string.currency_brazil_full_name),
                        ratesResponseBody.getRates().getBrl()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.canada,
                        Constants.Currency.Acronym.CANADA,
                        context.getString(R.string.currency_canada_full_name),
                        ratesResponseBody.getRates().getCad()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.switzerland,
                        Constants.Currency.Acronym.SWITZERLAND,
                        context.getString(R.string.currency_switzerland_full_name),
                        ratesResponseBody.getRates().getChf()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.china,
                        Constants.Currency.Acronym.CHINA,
                        context.getString(R.string.currency_china_full_name),
                        ratesResponseBody.getRates().getCny()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.czech_republic,
                        Constants.Currency.Acronym.CZECH_REPUBLIC,
                        context.getString(R.string.currency_czech_republic_full_name),
                        ratesResponseBody.getRates().getCzk()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.denmark,
                        Constants.Currency.Acronym.DENMARK,
                        context.getString(R.string.currency_denmark_full_name),
                        ratesResponseBody.getRates().getDkk()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.united_kingdom,
                        Constants.Currency.Acronym.UNITED_KINGDOM,
                        context.getString(R.string.currency_united_kingdom_full_name),
                        ratesResponseBody.getRates().getGbp()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.hong_kong,
                        Constants.Currency.Acronym.HONG_KONG,
                        context.getString(R.string.currency_hong_kong_full_name),
                        ratesResponseBody.getRates().getHkd()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.croatia,
                        Constants.Currency.Acronym.CROATIA,
                        context.getString(R.string.currency_croatia_full_name),
                        ratesResponseBody.getRates().getHrk()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.hungary,
                        Constants.Currency.Acronym.HUNGARY,
                        context.getString(R.string.currency_hungary_full_name),
                        ratesResponseBody.getRates().getHuf()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.indonesia,
                        Constants.Currency.Acronym.INDONESIA,
                        context.getString(R.string.currency_indonesia_full_name),
                        ratesResponseBody.getRates().getIdr()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.israel,
                        Constants.Currency.Acronym.ISRAEL,
                        context.getString(R.string.currency_israel_full_name),
                        ratesResponseBody.getRates().getIls()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.india,
                        Constants.Currency.Acronym.INDIA,
                        context.getString(R.string.currency_india_full_name),
                        ratesResponseBody.getRates().getInr()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.iceland,
                        Constants.Currency.Acronym.ICELAND,
                        context.getString(R.string.currency_iceland_full_name),
                        ratesResponseBody.getRates().getIsk()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.japan,
                        Constants.Currency.Acronym.JAPAN,
                        context.getString(R.string.currency_japan_full_name),
                        ratesResponseBody.getRates().getJpy()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.south_korea,
                        Constants.Currency.Acronym.SOUTH_KOREA,
                        context.getString(R.string.currency_south_korea_full_name),
                        ratesResponseBody.getRates().getKrw()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.mexico,
                        Constants.Currency.Acronym.MEXICO,
                        context.getString(R.string.currency_mexico_full_name),
                        ratesResponseBody.getRates().getMxn()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.malaysia,
                        Constants.Currency.Acronym.MALAYSIA,
                        context.getString(R.string.currency_malaysia_full_name),
                        ratesResponseBody.getRates().getMyr()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.norway,
                        Constants.Currency.Acronym.NORWAY,
                        context.getString(R.string.currency_norway_full_name),
                        ratesResponseBody.getRates().getNok()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.new_zealand,
                        Constants.Currency.Acronym.NEW_ZEALAND,
                        context.getString(R.string.currency_new_zealand_full_name),
                        ratesResponseBody.getRates().getNzd()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.philippines,
                        Constants.Currency.Acronym.PHILIPPINES,
                        context.getString(R.string.currency_philippines_full_name),
                        ratesResponseBody.getRates().getPhp()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.poland,
                        Constants.Currency.Acronym.POLAND,
                        context.getString(R.string.currency_poland_full_name),
                        ratesResponseBody.getRates().getPln()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.romania,
                        Constants.Currency.Acronym.ROMANIA,
                        context.getString(R.string.currency_romania_full_name),
                        ratesResponseBody.getRates().getRon()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.russia,
                        Constants.Currency.Acronym.RUSSIA,
                        context.getString(R.string.currency_russia_full_name),
                        ratesResponseBody.getRates().getRub()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.sweden,
                        Constants.Currency.Acronym.SWEDEN,
                        context.getString(R.string.currency_sweden_full_name),
                        ratesResponseBody.getRates().getSek()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.singapore,
                        Constants.Currency.Acronym.SINGAPORE,
                        context.getString(R.string.currency_singapore_full_name),
                        ratesResponseBody.getRates().getSgd()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.thailand,
                        Constants.Currency.Acronym.THAILAND,
                        context.getString(R.string.currency_thailand_full_name),
                        ratesResponseBody.getRates().getThb()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.turkey,
                        Constants.Currency.Acronym.TURKEY,
                        context.getString(R.string.currency_turkey_full_name),
                        ratesResponseBody.getRates().get_try()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.united_states_of_america,
                        Constants.Currency.Acronym.UNITED_STATES,
                        context.getString(R.string.currency_united_states_full_name),
                        ratesResponseBody.getRates().getUsd()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.south_africa,
                        Constants.Currency.Acronym.SOUTH_AFRICAN_REPUBLIC,
                        context.getString(R.string.currency_south_african_republic_full_name),
                        ratesResponseBody.getRates().getZar()));

        return list;
    }

    private Double getBaseCurrencyRate() {
        return 1.0;
    }

    private void stopRatesUpdate() {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    public LiveData<List<RatesItemViewModel>> getLatestRatesLiveData() {
        return ratesListLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        stopRatesUpdate();
    }
}
