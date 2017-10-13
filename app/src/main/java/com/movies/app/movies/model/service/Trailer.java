package com.movies.app.movies.model.service;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Anusha  on 10/12/2017.
 *
 * Service model for trailer item.
 */

public class Trailer implements Serializable {

    @SerializedName("id")
    private String trailerId;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName("site")
    private String site;

    @SerializedName("size")
    private int size;

    @SerializedName("type")
    private String type;

    public String getTrailerId() {
        return trailerId;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "trailerId='" + trailerId + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
