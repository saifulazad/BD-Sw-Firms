package com.jokerslab.android.bd_sw_firms.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.jokerslab.android.bd_sw_firms.db.AppDatabase;
import com.jokerslab.android.bd_sw_firms.db.CompanyDao;
import com.jokerslab.android.bd_sw_firms.network.WebService;
import com.jokerslab.android.bd_sw_firms.util.LiveDataCallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sayem on 9/26/2017.
 */

@Module(subcomponents = MainActivityComponent.class, includes = ViewModelModule.class)
public class AppModule {

    @Singleton
    @Provides
    public WebService provideWebService() {
        return new Retrofit.Builder()
                .baseUrl("http://34.223.214.183:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(WebService.class);
    }

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "SWComDB").allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    public CompanyDao provideCompanyDao(AppDatabase appDatabase) {
        return appDatabase.getCompanyDao();
    }
}
