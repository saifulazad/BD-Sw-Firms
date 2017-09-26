package com.jokerslab.android.bd_sw_firms.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sayem on 9/26/2017.
 */

public class Technology {
    @SerializedName("tag_name")
    public String techName;

    public Technology() {
    }


    public Technology(String techName) {
        this.techName = techName;
    }
}
