package com.jokerslab.android.bd_sw_firms.repository;


import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.jokerslab.android.bd_sw_firms.db.CompanyDao;
import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.network.WebService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sayem on 9/26/2017.
 */

public class CompanyRepository {

    private static final String TAG = CompanyRepository.class.getSimpleName();

    WebService webService;
    CompanyDao companyDao;

    @Inject
    public CompanyRepository(WebService webService, CompanyDao companyDao) {
        this.webService = webService;
        this.companyDao = companyDao;
    }

    public LiveData<List<Company>> loadCompanyList() {
        LiveData<List<Company>> data = companyDao.getAll();
        if (data.getValue() == null || data.getValue().size() == 0) {
            webService.getCompanies().enqueue(new Callback<List<Company>>() {
                @Override
                public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                    if (response.isSuccessful()) {
                        companyDao.insert(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<Company>> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }
        return data;
    }
}
