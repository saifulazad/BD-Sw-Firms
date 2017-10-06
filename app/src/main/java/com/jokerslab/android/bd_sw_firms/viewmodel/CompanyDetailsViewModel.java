package com.jokerslab.android.bd_sw_firms.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.repository.CompanyRepository;

import javax.inject.Inject;

/**
 * Created by sayem on 10/6/2017.
 */

public class CompanyDetailsViewModel extends ViewModel{

    private final MutableLiveData<String> loadCompany = new MutableLiveData<>();
    private final CompanyRepository repository;
    private final LiveData<Company> company;

    @Inject
    public CompanyDetailsViewModel(CompanyRepository repository) {
        this.repository = repository;
        company = Transformations.switchMap(loadCompany, companyID -> {
            return repository.getCompanyByID(companyID);
        });
    }


    public LiveData<Company> getCompany() {
        return company;
    }

    public void query(String companyID) {
        if (companyID.equals(loadCompany.getValue())) return;
        loadCompany.setValue(companyID);
    }

}
