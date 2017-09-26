package com.jokerslab.android.bd_sw_firms;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jokerslab.android.bd_sw_firms.databinding.ItemCompanyBinding;
import com.jokerslab.android.bd_sw_firms.model.Company;

/**
 * Created by sayem on 9/8/2017.
 */

public class CompanyViewHolder extends BaseViewHolder<Company> {

    private ItemCompanyBinding binding;

    public CompanyViewHolder(ItemCompanyBinding itemView, int viewType) {
        super(itemView.getRoot(), viewType);
        this.binding = itemView;
    }

    @Override
    public void bindData(Company data) {
        binding.companyName.setText(data.companyName);
    }
}
