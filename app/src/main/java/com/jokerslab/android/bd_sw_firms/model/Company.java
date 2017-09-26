package com.jokerslab.android.bd_sw_firms.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

/**
 * Created by sayem on 9/26/2017.
 */
@Entity(tableName = "company")
public class Company {

    @PrimaryKey
    public String id;

    @SerializedName("company_name")
    @ColumnInfo(name = "company_name")
    public String companyName;

    @ColumnInfo(name = "web_address")
    @SerializedName("web")
    public String web;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    public String address;

    @ColumnInfo(name = "businessDescription")
    @SerializedName("business")
    public String businessDescription;

    @ColumnInfo(name = "technologies")
    @SerializedName("tech_stacks")
    public List<Technology> technologies;

    public Company() {
        id = UUID.randomUUID().toString();
    }
}
