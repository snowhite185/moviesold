package com.movies.app.movies.model.service;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anusha  on 10/12/2017.
 *
 * Service model for movie trailers response
 */

public class MovieTrailers implements Serializable {

    @SerializedName("results")
    private List<Trailer> trailers;


    public List<Trailer> getTrailers() {
        return trailers;
    }

    @Override
    public String toString() {
        return "MovieTrailers{" +
                "trailers=" + trailers +
                '}';
    }
}
