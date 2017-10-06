package com.jokerslab.android.bd_sw_firms.di;

import com.jokerslab.android.bd_sw_firms.CompanyDetailsFragment;
import com.jokerslab.android.bd_sw_firms.CompanyListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by sayem on 10/5/2017.
 */

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract CompanyListFragment contributeCompanyListFragment();


    @ContributesAndroidInjector
    abstract CompanyDetailsFragment contributeCompanyDetailsFragment();
}
