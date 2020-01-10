package com.sebastianmatysiak.revolut_androidtestapp;

import com.sebastianmatysiak.revolut_androidtestapp.adapters.RatesAdapterHelper;
import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesItemViewModel;

import org.junit.Test;

import java.util.List;

public class RatesAdapterHelperTests {
    @Test
    public void getIndexesToUpdate_shouldReturnAllIndexesExceptFirstOne() {
        List<RatesItemViewModel> currentItems = TestHelper.getCurrentItems();

        List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(
                currentItems,
                TestHelper.getNewItemsWithAllRatesDifferent());

        assert (indexesToUpdate.size() == currentItems.size() - 1);
        assert (indexesToUpdate.get(0) == 1);
        assert (indexesToUpdate.get(1) == 2);
        assert (indexesToUpdate.get(2) == 3);
        assert (indexesToUpdate.get(3) == 4);
        assert (indexesToUpdate.get(4) == 5);
        assert (indexesToUpdate.get(5) == 6);
        assert (indexesToUpdate.get(6) == 7);
        assert (indexesToUpdate.get(7) == 8);
        assert (indexesToUpdate.get(8) == 9);
    }

    @Test
    public void getIndexesToUpdate_shouldReturnNoIndexToUpdate() {
        List<RatesItemViewModel> currentItems = TestHelper.getCurrentItems();

        List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(
                currentItems,
                TestHelper.getNewItemsWithAllRatesTheSame());

        assert (indexesToUpdate.size() == 0);
    }

    @Test
    public void getIndexesToUpdate_shouldReturnNoIndexToUpdateWhenFirstChanged() {
        List<RatesItemViewModel> currentItems = TestHelper.getCurrentItems();

        List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(
                currentItems,
                TestHelper.getNewItemsWithFirstRateDifferent());

        assert (indexesToUpdate.size() == 0);
    }

    @Test
    public void getIndexesToUpdate_shouldReturnSecondIndexToUpdate() {
        List<RatesItemViewModel> currentItems = TestHelper.getCurrentItems();

        List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(
                currentItems,
                TestHelper.getNewItemsWithSecondRateDifferent());

        assert (indexesToUpdate.size() == 1);
        assert (indexesToUpdate.get(0) == 1);
    }

    @Test
    public void getIndexesToUpdate_shouldReturnLastIndexToUpdate() {
        List<RatesItemViewModel> currentItems = TestHelper.getCurrentItems();

        List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(
                currentItems,
                TestHelper.getNewItemsWithLastRateDifferent());

        assert (indexesToUpdate.size() == 1);
        assert (indexesToUpdate.get(0) == 9);
    }

    @Test
    public void getIndexesToUpdate_shouldReturnACoupleOfIndexesToUpdate() {
        List<RatesItemViewModel> currentItems = TestHelper.getCurrentItems();

        List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(
                currentItems,
                TestHelper.getNewItemsWith3RatesDifferent());

        assert (indexesToUpdate.size() == 3);
        assert (indexesToUpdate.get(0) == 2);
        assert (indexesToUpdate.get(1) == 5);
        assert (indexesToUpdate.get(2) == 8);
    }
}
