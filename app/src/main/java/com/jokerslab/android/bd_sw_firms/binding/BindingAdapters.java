package com.jokerslab.android.bd_sw_firms.binding;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by sayem on 10/5/2017.
 */

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
