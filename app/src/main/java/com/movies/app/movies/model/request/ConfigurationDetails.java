package com.movies.app.movies.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anusha on 10/12/2017.
 */

public class ConfigurationDetails implements Serializable {

    @SerializedName("base_url")
    private String baseUrl;

    @SerializedName("secure_base_url")
    private String secureBaseUrl;

    @SerializedName("backdrop_sizes")
    private List<String> backDropSizes;

    @SerializedName("poster_sizes")
    private List<String> posterSizes;

    @SerializedName("profile_sizes")
    private List<String> profileSizes;

    @SerializedName("still_sizes")
    private List<String> stillSizes;

    @SerializedName("change_keys")
    private List<String> changeKeys;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    public List<String> getBackDropSizes() {
        return backDropSizes;
    }

    public List<String> getPosterSizes() {
        return posterSizes;
    }

    public List<String> getProfileSizes() {
        return profileSizes;
    }

    public List<String> getStillSizes() {
        return stillSizes;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }

    @Override
    public String toString() {
        return "ConfigurationDetails{" +
                "baseUrl='" + baseUrl + '\'' +
                ", secureBaseUrl='" + secureBaseUrl + '\'' +
                ", backDropSizes=" + backDropSizes +
                ", posterSizes=" + posterSizes +
                ", profileSizes=" + profileSizes +
                ", stillSizes=" + stillSizes +
                ", changeKeys=" + changeKeys +
                '}';
    }
}
