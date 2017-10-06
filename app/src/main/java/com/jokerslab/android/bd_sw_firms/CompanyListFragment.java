package com.jokerslab.android.bd_sw_firms;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jokerslab.android.bd_sw_firms.binding.FragmentDataBindingComponent;
import com.jokerslab.android.bd_sw_firms.databinding.FragmentCompanyListBinding;
import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.model.Resource;
import com.jokerslab.android.bd_sw_firms.util.AutoClearedValue;
import com.jokerslab.android.bd_sw_firms.viewmodel.CompanyViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sayem on 9/8/2017.
 */

public class CompanyListFragment extends BaseFragment implements ItemClickListener {

    public static final String TAG = CompanyListFragment.class.getSimpleName();


    private AutoClearedValue<FragmentCompanyListBinding> binding;

    private CompanyListAdapter adapter;
    private DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    public static CompanyListFragment newInstance() {
        return new CompanyListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CompanyListAdapter(getActivity(), dataBindingComponent, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentCompanyListBinding companyListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_list, container,
                false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, companyListBinding);
        return companyListBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.get().companyListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.get().companyListRecyclerView.setAdapter(adapter);
        CompanyViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(CompanyViewModel.class);
        viewModel.getCompanies().observe(this, result -> {
            binding.get().setCompanyListResource(result);
            binding.get().setResultCount((result == null || result.data == null) ? 0 : result.data.size());
            setData(result);
            binding.get().executePendingBindings();
        });

        binding.get().setCallback(() -> viewModel.refresh());

    }

    public void setData(Resource<List<Company>> companies) {
        if (binding != null) {
            adapter.setData(companies.data);
        }
    }

    @Override
    public void onItemClicked(View view, int clickPosition) {
        if (clickPosition >= 0) {
            Company company = adapter.getData().get(clickPosition);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, CompanyDetailsFragment.newInstance(company.id), CompanyListFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
