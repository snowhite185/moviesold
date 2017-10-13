package com.movies.app.movies.model.service;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anusha on 10/12/2017.
 *
 * Service model for popular movies list reposne
 */

public class PopularMovies implements Serializable {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<MovieDetails> movieDetails;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    public int getPage() {
        return page;
    }

    public List<MovieDetails> getMovieDetails() {
        return movieDetails;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    @Override
    public String toString() {
        return "PopularMovies{" +
                "page=" + page +
                ", movieDetails=" + movieDetails +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
