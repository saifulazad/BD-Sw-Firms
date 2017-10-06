package com.jokerslab.android.bd_sw_firms.binding;

import android.databinding.DataBindingComponent;
import android.support.v4.app.Fragment;

/**
 * Created by sayem on 10/6/2017.
 */

public class FragmentDataBindingComponent  implements DataBindingComponent {

    private final FragmentBindingAdapters adapter;

    public FragmentDataBindingComponent(Fragment fragment) {
        this.adapter = new FragmentBindingAdapters(fragment);
    }

    @Override
    public FragmentBindingAdapters getFragmentBindingAdapters() {
        return adapter;
    }
}
