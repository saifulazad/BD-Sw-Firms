package com.jokerslab.android.bd_sw_firms;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jokerslab.android.bd_sw_firms.databinding.ItemCompanyBinding;
import com.jokerslab.android.bd_sw_firms.model.Company;

/**
 * Created by sayem on 9/8/2017.
 */

public class CompanyViewHolder extends BaseViewHolder<Company> implements View.OnClickListener {

    private ItemCompanyBinding binding;
    private ItemClickListener clickListener;

    public CompanyViewHolder(ItemCompanyBinding itemView, int viewType) {
        super(itemView.getRoot(), viewType);
        this.binding = itemView;
        itemView.getRoot().setOnClickListener(this);
    }

    @Override
    public void bindData(Company data) {
        binding.setCompany(data);
        binding.executePendingBindings();
    }

    public void setListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        if (clickListener != null) {
            clickListener.onItemClicked(v, getAdapterPosition());
        }
    }
}
