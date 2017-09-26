package com.jokerslab.android.bd_sw_firms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jokerslab.android.bd_sw_firms.databinding.ItemCompanyBinding;
import com.jokerslab.android.bd_sw_firms.model.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sayem on 9/8/2017.
 */

public class CompanyListAdapter extends RecyclerView.Adapter<BaseViewHolder<Company>> {

    private ArrayList<Company> companies;
    private LayoutInflater layoutInflater;

    public CompanyListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder<Company> onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCompanyBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_company, parent, false);
        CompanyViewHolder viewHolder = new CompanyViewHolder(binding, 0);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Company> holder, int position) {
        holder.bindData(getData().get(position));
    }

    @Override
    public int getItemCount() {
        return getData().size();
    }

    public void setData(List<Company> data) {
        getData().clear();
        getData().addAll(data);
        notifyDataSetChanged();
    }

    public ArrayList<Company> getData() {
        if (companies == null) companies = new ArrayList<>();
        return companies;
    }
}
