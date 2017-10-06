package com.jokerslab.android.bd_sw_firms.binding;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

import com.jokerslab.android.bd_sw_firms.model.Company;
import com.jokerslab.android.bd_sw_firms.model.Technology;

import java.util.List;

/**
 * Created by sayem on 10/5/2017.
 */

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("technologies")
    public static void technologies(TextView view, List<Technology> technologies) {
        String techs = "";
        if (technologies != null && technologies.size() > 0) {
            techs = technologies.get(0).techName;
            for (int i = 1; i < technologies.size(); i++) {
                techs = techs + ", " + technologies.get(i).techName;
            }
        }
        view.setText(techs);
    }
}
