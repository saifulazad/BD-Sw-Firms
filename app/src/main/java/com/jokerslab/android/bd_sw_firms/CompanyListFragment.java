package com.jokerslab.android.bd_sw_firms;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jokerslab.android.bd_sw_firms.databinding.FragmentCompanyListBinding;
import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.model.Resource;

import java.util.List;

/**
 * Created by sayem on 9/8/2017.
 */

public class CompanyListFragment extends BaseFragment {

    public static final String TAG = CompanyListFragment.class.getSimpleName();


    private FragmentCompanyListBinding binding;

    private CompanyListAdapter adapter;

    public static CompanyListFragment newInstance() {
        return new CompanyListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CompanyListAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_list, container, false);
        binding.companyListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.companyListRecyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void setData(Resource<List<Company>> companies) {
        if (binding != null) {
            adapter.setData(companies.data);
        }
    }
}
