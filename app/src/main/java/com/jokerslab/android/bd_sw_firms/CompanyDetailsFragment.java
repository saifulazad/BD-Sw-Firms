package com.jokerslab.android.bd_sw_firms;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jokerslab.android.bd_sw_firms.databinding.FragmentCompanyDetailsBinding;
import com.jokerslab.android.bd_sw_firms.util.AutoClearedValue;
import com.jokerslab.android.bd_sw_firms.viewmodel.CompanyDetailsViewModel;

import javax.inject.Inject;


public class CompanyDetailsFragment extends BaseFragment {
    private static final String ARG_COMPANY_ID = "company_id";

    private String companyID;
    private AutoClearedValue<FragmentCompanyDetailsBinding> binding;


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    public CompanyDetailsFragment() {
    }

    public static CompanyDetailsFragment newInstance(String companyID) {
        CompanyDetailsFragment fragment = new CompanyDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COMPANY_ID, companyID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            companyID = getArguments().getString(ARG_COMPANY_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCompanyDetailsBinding companyDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_details, container, false);
        binding = new AutoClearedValue<>(this, companyDetailsBinding);
        return companyDetailsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CompanyDetailsViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(CompanyDetailsViewModel.class);
        viewModel.getCompany().observe(this, company -> {
            binding.get().setCompany(company);
            binding.get().executePendingBindings();
        });
        viewModel.query(companyID);
    }
}
