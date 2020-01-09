package com.sebastianmatysiak.revolut_androidtestapp.viewmodels;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;

import com.sebastianmatysiak.revolut_androidtestapp.Constants;

import java.text.DecimalFormat;

public class RatesItemViewModel {

    private static final String TAG = RatesItemViewModel.class.getSimpleName();

    @DrawableRes
    private int imageId;
    private String acronym;
    private String fullName;
    private Double rate;

    public RatesItemViewModel(@DrawableRes int imageId, String acronym, String fullName, Double rate) {
        this.imageId = imageId;
        this.acronym = acronym;
        this.fullName = fullName;
        this.rate = rate;
    }

    public Drawable getCurrencyFlagImage(Context context) {
        return context.getDrawable(imageId);
    }

    public String getCurrencyAcronym() {
        return acronym;
    }

    public String getCurrencyFullName() {
        return fullName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCurrencyValue(Double firstResponderInputValue, Double firstResponderRate) {
        return new DecimalFormat("#.##").format(firstResponderInputValue / firstResponderRate * rate);
    }

    public boolean isBase() {
        return acronym.equals(Constants.Currency.Acronym.EUROPEAN_UNION);
    }
}
