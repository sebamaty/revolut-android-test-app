package com.sebastianmatysiak.revolut_androidtestapp.adapters;

import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class RatesAdapterHelper {

    /**
     * Sets new rates and prepares indexes only for those rates that has changed
     */
    public static List<Integer> getIndexesToUpdate(List<RatesItemViewModel> currentItems, List<RatesItemViewModel> newItems) {
        List<Integer> indexesToUpdate = new ArrayList<>();

        for (int i = 0; i < currentItems.size(); i++) {
            for (int j = 0; j < newItems.size(); j++) {
                if (currentItems.get(i).getCurrencyAcronym().equals(newItems.get(j).getCurrencyAcronym())) {
                    if (!currentItems.get(i).getRate().equals(newItems.get(j).getRate())
                            || currentItems.get(i).isBase()) {
                        //Update rates for all currencies
                        currentItems.get(i).setRate(newItems.get(j).getRate());
                        //But don't notify first responder to not update its value on the screen
                        if (i != 0) {
                            indexesToUpdate.add(i);
                        }
                    }
                }
            }
        }

        return indexesToUpdate;
    }
}
