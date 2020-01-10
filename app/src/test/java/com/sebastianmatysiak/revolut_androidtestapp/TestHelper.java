package com.sebastianmatysiak.revolut_androidtestapp;

import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesItemViewModel;

import java.util.ArrayList;
import java.util.List;

class TestHelper {
    static List<RatesItemViewModel> getCurrentItems() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6188));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9588));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.799));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5361));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1292));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9571));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.754));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.468));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8996));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1462));

        return currentItems;
    }

    static List<RatesItemViewModel> getNewItemsWithAllRatesDifferent() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6187));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9587));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.798));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5360));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1291));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9570));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.753));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.467));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8995));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1461));

        return currentItems;
    }

    static List<RatesItemViewModel> getNewItemsWithAllRatesTheSame() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6188));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9588));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.799));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5361));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1292));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9571));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.754));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.468));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8996));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1462));

        return currentItems;
    }

    static List<RatesItemViewModel> getNewItemsWithFirstRateDifferent() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6187));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9588));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.799));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5361));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1292));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9571));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.754));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.468));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8996));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1462));

        return currentItems;
    }

    static List<RatesItemViewModel> getNewItemsWithSecondRateDifferent() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6188));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9587));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.799));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5361));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1292));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9571));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.754));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.468));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8996));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1462));

        return currentItems;
    }

    static List<RatesItemViewModel> getNewItemsWithLastRateDifferent() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6188));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9588));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.799));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5361));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1292));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9571));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.754));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.468));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8996));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1461));

        return currentItems;
    }

    static List<RatesItemViewModel> getNewItemsWith3RatesDifferent() {
        List<RatesItemViewModel> currentItems = new ArrayList<>();

        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.AUSTRALIA, "", 1.6188));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BULGARIA, "", 1.9588));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.BRAZIL, "", 4.798));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CANADA, "", 1.5361));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.SWITZERLAND, "", 1.1292));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CHINA, "", 7.9570));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.CZECH_REPUBLIC, "", 25.754));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.DENMARK, "", 7.468));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.UNITED_KINGDOM, "", 0.8995));
        currentItems.add(new RatesItemViewModel(0, Constants.Currency.Acronym.HONG_KONG, "", 9.1462));

        return currentItems;
    }
}
