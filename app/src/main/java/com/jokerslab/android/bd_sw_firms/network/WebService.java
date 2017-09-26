package com.jokerslab.android.bd_sw_firms.network;


import com.jokerslab.android.bd_sw_firms.model.Company;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sayem on 9/26/2017.
 */

public interface WebService {

    @GET("jobs")
    Call<List<Company>> getCompanies();
}
