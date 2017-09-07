package com.danielkim.soundrecorder.restclient;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anderson.acs on 3/12/2015.
 */
public class RestClient {

    private static RestClient mRestClient = null;
    private static Retrofit restAdapter;

    public static RestClient getInstance(){

        if(mRestClient == null ){

            mRestClient = new RestClient();
            setup();
        }

        return mRestClient;
    }

    private static void setup(){


        restAdapter = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRestAdapter(){
        return restAdapter;
    }
}