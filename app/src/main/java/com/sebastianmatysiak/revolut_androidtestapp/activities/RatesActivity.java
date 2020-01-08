package com.sebastianmatysiak.revolut_androidtestapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.sebastianmatysiak.revolut_androidtestapp.R;
import com.sebastianmatysiak.revolut_androidtestapp.adapters.RatesAdapter;
import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatesActivity extends AppCompatActivity {

    private static final String TAG = RatesActivity.class.getSimpleName();

    @BindView(R.id.rates_list)
    RecyclerView ratesList;

    private RatesAdapter adapter;
    private RatesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        ButterKnife.bind(this);
        initRatesList();
        initViewModel();
    }

    private void initRatesList() {
        ratesList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RatesAdapter();
        ratesList.setAdapter(adapter);
        if (ratesList.getItemAnimator() != null) {
            ((SimpleItemAnimator) ratesList.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(RatesViewModel.class);
        viewModel.init();

        viewModel
                .getLatestRatesLiveData()
                .observe(this, ratesList -> adapter.updateItems(ratesList));

        viewModel.startRatesUpdates(this);
    }
}
