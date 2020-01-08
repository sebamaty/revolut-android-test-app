package com.sebastianmatysiak.revolut_androidtestapp.adapters;

import androidx.recyclerview.widget.DiffUtil;

import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesItemViewModel;

import java.util.List;

public class RatesDiffCallback extends DiffUtil.Callback {

    private final List<RatesItemViewModel> mOldEmployeeList;
    private final List<RatesItemViewModel> mNewEmployeeList;

    public RatesDiffCallback(List<RatesItemViewModel> oldEmployeeList, List<RatesItemViewModel> newEmployeeList) {
        this.mOldEmployeeList = oldEmployeeList;
        this.mNewEmployeeList = newEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return mOldEmployeeList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewEmployeeList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldEmployeeList.get(oldItemPosition).getCurrencyAcronym()
                .equals(mNewEmployeeList.get(newItemPosition).getCurrencyAcronym());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final RatesItemViewModel oldEmployee = mOldEmployeeList.get(oldItemPosition);
        final RatesItemViewModel newEmployee = mNewEmployeeList.get(newItemPosition);

        return oldEmployee.getRate().equals(newEmployee.getRate());
    }
}
