package com.movies.app.movies.model.service;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anusha on 10/12/2017.
 *
 * Service model for movie details response
 */

public class MovieDetails implements Serializable {

    @SerializedName("id")
    private int movieId;

    @SerializedName("vote_average")
    private float voteAverage;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("backdrop_path")
    private String backDropPath;

    @SerializedName("videos")
    private MovieTrailers trailers;

    public String getBackDropPath() {
        return backDropPath;
    }

    public MovieTrailers getTrailers() {
        return trailers;
    }

    public int getMovieId() {
        return movieId;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    @Override
    public String toString() {
        return "MovieDetails{" +
                "movieId=" + movieId +
                ", voteAverage=" + voteAverage +
                ", title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", backDropPath='" + backDropPath + '\'' +
                ", trailers=" + trailers +
                '}';
    }
}
