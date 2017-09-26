package com.jokerslab.android.bd_sw_firms.db;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;


import com.jokerslab.android.bd_sw_firms.model.Technology;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sayem on 9/26/2017.
 */

public class Converters {
    @TypeConverter
    public static String fromTechnologies(List<Technology> technologies) {
        if (technologies == null || technologies.size() == 0)  return null;

        String values  = technologies.get(0).techName;

        for (int i = 1; i < technologies.size(); i++) {
            values = values + "," + technologies.get(i).techName;
        }

        return values;
    }

    @TypeConverter
    public static List<Technology> toTechnologies(String values) {
        if (TextUtils.isEmpty(values)) return new ArrayList<>();

        String technologyArray[] = values.split(",");
        ArrayList<Technology> technologies = new ArrayList<>();
        if (technologyArray != null && technologyArray.length > 0) {
            for (int i = 0; i < technologyArray.length; i++) {
                technologies.add(new Technology(technologyArray[i]));
            }
        }

        return technologies;
    }
}
