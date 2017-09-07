package com.danielkim.soundrecorder.restclient.service;


import com.danielkim.soundrecorder.model.User;
import com.danielkim.soundrecorder.restclient.wrapper.WrapperUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by anderson.acs on 3/12/2015.
 */
public interface ParseUserService {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<User> getAnswers();


}