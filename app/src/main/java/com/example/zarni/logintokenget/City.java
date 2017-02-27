package com.example.zarni.logintokenget;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zarni on 2/15/17.
 */

public class City implements Serializable{
        @SerializedName("id")
        private String id;
        @SerializedName("city")
        private String city;
        @SerializedName("country_id")
        private String country_id;


    public City(String  id, String city,String country_id) {
        this.id = id;
        this.city = city;
        this.country_id=country_id;
    }
    public String getcity(){
        return city;
    }
    public String getid(){
        return id;
    }

}
