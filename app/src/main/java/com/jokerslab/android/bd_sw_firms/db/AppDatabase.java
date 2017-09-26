package com.jokerslab.android.bd_sw_firms.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.jokerslab.android.bd_sw_firms.model.Company;


/**
 * Created by sayem on 9/26/2017.
 */

@Database(entities = {Company.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CompanyDao getCompanyDao();
}
