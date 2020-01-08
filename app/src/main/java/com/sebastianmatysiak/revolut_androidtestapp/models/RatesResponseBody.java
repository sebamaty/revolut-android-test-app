package com.sebastianmatysiak.revolut_androidtestapp.models;

public class RatesResponseBody {
    private String base;
    private String date;
    private RatesModel rates;

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public RatesModel getRates() {
        return rates;
    }
}
