package com.jokerslab.android.bd_sw_firms.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.model.Resource;
import com.jokerslab.android.bd_sw_firms.repository.CompanyRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sayem on 9/26/2017.
 */

public class CompanyViewModel extends ViewModel {
    private final LiveData<Resource<List<Company>>> companies;
    private final MutableLiveData<Boolean> refresh = new MutableLiveData<>();
    CompanyRepository repository;

    @Inject
    public CompanyViewModel(CompanyRepository repository) {
        this.repository = repository;
        companies = Transformations.switchMap(refresh, load-> loadList());
        refresh();
    }

    private LiveData<Resource<List<Company>>> loadList() {
        return repository.loadCompanyList();
    }

    public LiveData<Resource<List<Company>>> getCompanies() {
        return companies;
    }

    public void refresh() {
        refresh.setValue(true);
    }
}
