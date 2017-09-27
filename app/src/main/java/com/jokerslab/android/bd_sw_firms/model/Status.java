package com.jokerslab.android.bd_sw_firms.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.jokerslab.android.bd_sw_firms.model.Status.ERROR;
import static com.jokerslab.android.bd_sw_firms.model.Status.LOADING;
import static com.jokerslab.android.bd_sw_firms.model.Status.SUCCESS;

/**
 * Created by sayem on 9/27/2017.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({SUCCESS,LOADING,ERROR})
public @interface Status {
    int SUCCESS = 1;
    int LOADING = 2;
    int ERROR = 3;

}
