package com.jokerslab.android.bd_sw_firms.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import com.jokerslab.android.bd_sw_firms.viewmodel.CompanyDetailsViewModel;
import com.jokerslab.android.bd_sw_firms.viewmodel.CompanyViewModel;
import com.jokerslab.android.bd_sw_firms.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by sayem on 9/26/2017.
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CompanyViewModel.class)
    abstract ViewModel bindUserViewModel(CompanyViewModel companyViewModel);
    @Binds
    @IntoMap
    @ViewModelKey(CompanyDetailsViewModel.class)
    abstract ViewModel bindCompanyDetailsViewModel(CompanyDetailsViewModel companyViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
