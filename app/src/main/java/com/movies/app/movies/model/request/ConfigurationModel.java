package com.movies.app.movies.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Anusha on 10/12/2017.
 */

public class ConfigurationModel implements Serializable{

    @SerializedName("images")
    private ConfigurationDetails details;

    public ConfigurationDetails getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "ConfigurationModel{" +
                "details=" + details +
                '}';
    }
}
