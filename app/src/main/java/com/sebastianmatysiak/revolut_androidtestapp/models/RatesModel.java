package com.sebastianmatysiak.revolut_androidtestapp.models;

import com.google.gson.annotations.SerializedName;

public class RatesModel {
    @SerializedName("CAD")
    private Double cad;
    @SerializedName("SEK")
    private Double sek;
    @SerializedName("USD")
    private Double usd;

    public Double getUsd() {
        return usd;
    }

    public Double getSek() {
        return sek;
    }

    public Double getCad() {
        return cad;
    }
}
