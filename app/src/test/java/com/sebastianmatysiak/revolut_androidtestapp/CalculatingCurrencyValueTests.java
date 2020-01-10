package com.sebastianmatysiak.revolut_androidtestapp;

import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesItemViewModel;

import org.junit.Test;


public class CalculatingCurrencyValueTests {
    @Test
    public void getCurrencyValue_shouldReturnCorrectValue1() {
        String expected = "2.58";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 1.53);
        String value = viewModel.getCurrencyValue(1.65, 0.98);

        assert (value.equals(expected));
    }

    @Test
    public void getCurrencyValue_shouldReturnCorrectValue2() {
        String expected = "1";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 1.0);
        String value = viewModel.getCurrencyValue(1.0, 1.0);

        assert (value.equals(expected));
    }

    @Test
    public void getCurrencyValue_shouldReturnCorrectValue3() {
        String expected = "0.12";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 0.123456789);
        String value = viewModel.getCurrencyValue(0.1234556789, 0.123456789);

        assert (value.equals(expected));
    }

    @Test
    public void getCurrencyValue_shouldReturnCorrectValue4() {
        String expected = "123456789.12";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 0.123456789);
        String value = viewModel.getCurrencyValue(123456789.1234556789, 0.123456789);

        assert (value.equals(expected));
    }

    @Test
    public void getCurrencyValue_shouldReturnCorrectValue5() {
        String expected = "0";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 1.16);
        String value = viewModel.getCurrencyValue(0.0, 1.53);

        assert (value.equals(expected));
    }

    @Test
    public void getCurrencyValue_shouldReturnCorrectValue6() {
        String expected = "758169933.88";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 1.16);
        String value = viewModel.getCurrencyValue(999999999.0, 1.53);

        assert (value.equals(expected));
    }

    @Test
    public void getCurrencyValue_shouldReturnCorrectValue7() {
        String expected = "0.07";

        RatesItemViewModel viewModel = new RatesItemViewModel(0, "", "", 10.5);
        String value = viewModel.getCurrencyValue(0.01, 1.53);

        assert (value.equals(expected));
    }
}
