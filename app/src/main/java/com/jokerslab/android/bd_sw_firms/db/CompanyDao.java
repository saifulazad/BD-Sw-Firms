package com.jokerslab.android.bd_sw_firms.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.jokerslab.android.bd_sw_firms.model.Company;

import java.util.List;

/**
 * Created by sayem on 9/26/2017.
 */

@Dao
public interface CompanyDao {
    @Query("SELECT * FROM company")
    LiveData<List<Company>> getAll();

    @Insert
    void insert(List<Company> companies);
}
