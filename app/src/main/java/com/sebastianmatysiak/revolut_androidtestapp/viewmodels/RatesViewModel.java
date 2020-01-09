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
                        R.drawable.canada,
                        Constants.Currency.Acronym.CANADA,
                        context.getString(R.string.currency_canada_full_name),
                        ratesResponseBody.getBase(),
                        ratesResponseBody.getDate(),
                        ratesResponseBody.getRates().getCad()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.european_union,
                        Constants.Currency.Acronym.EUROPEAN_UNION,
                        context.getString(R.string.currency_european_union_full_name),
                        ratesResponseBody.getBase(),
                        ratesResponseBody.getDate(),
                        getBaseCurrencyRate()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.sweden,
                        Constants.Currency.Acronym.SWEDEN,
                        context.getString(R.string.currency_sweden_full_name),
                        ratesResponseBody.getBase(),
                        ratesResponseBody.getDate(),
                        ratesResponseBody.getRates().getSek()));

        list.add(
                new RatesItemViewModel(
                        R.drawable.united_states_of_america,
                        Constants.Currency.Acronym.UNITED_STATES,
                        context.getString(R.string.currency_united_states_full_name),
                        ratesResponseBody.getBase(),
                        ratesResponseBody.getDate(),
                        ratesResponseBody.getRates().getUsd()));

        return list;
    }

    private Double getBaseCurrencyRate() {
        return 1.0;
    }

    public void stopRatesUpdate() {
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
