package com.jokerslab.android.bd_sw_firms.repository;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jokerslab.android.bd_sw_firms.db.CompanyDao;
import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.model.Resource;
import com.jokerslab.android.bd_sw_firms.network.ApiResponse;
import com.jokerslab.android.bd_sw_firms.network.WebService;
import com.jokerslab.android.bd_sw_firms.util.AbsentLiveData;
import com.jokerslab.android.bd_sw_firms.util.AppExecutors;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sayem on 9/26/2017.
 */

public class CompanyRepository {

    private static final String TAG = CompanyRepository.class.getSimpleName();

    private final WebService webService;
    private final CompanyDao companyDao;
    private final AppExecutors appExecutors;


    @Inject
    public CompanyRepository(WebService webService, CompanyDao companyDao, AppExecutors appExecutors) {
        this.webService = webService;
        this.companyDao = companyDao;
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<List<Company>>> loadCompanyList() {

        return new NetworkBoundResource<List<Company>, List<Company>>(appExecutors) {


            @Override
            protected void saveCallResult(@NonNull List<Company> item) {
                companyDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Company> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<Company>> loadFromDB() {
                LiveData<List<Company>> list = companyDao.getAll();
                if (list == null || list.getValue() == null || list.getValue().isEmpty()) {
                    return AbsentLiveData.create();
                } else {
                    return list;
                }
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Company>>> createCall() {
                return webService.getCompanies();
            }

        }.asLiveData();
    }
}
