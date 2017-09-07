package com.danielkim.soundrecorder.restclient.wrapper;

import com.danielkim.soundrecorder.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by anderson.acs on 3/12/2015.
 */
public class WrapperUser {

    @SerializedName(value="results")
    List<User> results;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}