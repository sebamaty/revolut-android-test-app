package com.sebastianmatysiak.revolut_androidtestapp.adapters;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sebastianmatysiak.revolut_androidtestapp.R;
import com.sebastianmatysiak.revolut_androidtestapp.viewmodels.RatesItemViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.RatesItemViewHolder> {

    private static final String TAG = RatesAdapter.class.getSimpleName();

    private List<RatesItemViewModel> items = new ArrayList<>();
    private Double firstResponderInputValue = 10.0;
    private boolean isSlidingUp;

    @NonNull
    @Override
    public RatesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rates, parent, false);
        return new RatesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatesItemViewHolder holder, int position) {
        RatesItemViewModel item = items.get(holder.getAdapterPosition());
        holder.countryFlagImage.setImageDrawable(item.getCurrencyFlagImage(holder.itemView.getContext()));
        holder.currencyAcronym.setText(item.getCurrencyAcronym());
        holder.currencyFullName.setText(item.getCurrencyFullName());
        holder.valueInputField.setClickable(item.getClickable(position));
        holder.valueInputField.setText(item.getCurrencyValue(firstResponderInputValue, items.get(0).getRate()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItems(List<RatesItemViewModel> newItems) {
        if (!isSlidingUp) {
            if (this.items.size() == 0) {
                this.items.addAll(newItems);
                notifyDataSetChanged();
            } else {
                List<Integer> indexesToUpdate = RatesAdapterHelper.getIndexesToUpdate(this.items, newItems);
                for (Integer i : indexesToUpdate) {
                    notifyItemChanged(i);
                }
            }
        }
    }

    class RatesItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rates_item_flag_image)
        ImageView countryFlagImage;
        @BindView(R.id.rates_item_currency_acronym)
        TextView currencyAcronym;
        @BindView(R.id.rates_item_currency_full_name)
        TextView currencyFullName;
        @BindView(R.id.rates_item_value)
        EditText valueInputField;

        RatesItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(getOnClickListener());
            valueInputField.addTextChangedListener(new CurrencyValueChangeListener());
        }

        private View.OnClickListener getOnClickListener() {
            return view -> {
                isSlidingUp = true;

                firstResponderInputValue = Double.parseDouble(valueInputField.getText().toString());

                RatesItemViewModel item = items.get(getLayoutPosition());
                items.remove(item);
                items.add(0, item);
                notifyItemMoved(getLayoutPosition(), 0);

                valueInputField.requestFocus();

                //Workaround for resuming rate updates after sliding animation finishes
                final int delay = 1000;
                new Handler().postDelayed(() -> isSlidingUp = false, delay);
            };
        }


        private class CurrencyValueChangeListener implements TextWatcher {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (valueInputField.hasFocus()) {
                    firstResponderInputValue = Double.valueOf(!charSequence.toString().isEmpty()
                            ? charSequence.toString() : "0");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }
    }
}
