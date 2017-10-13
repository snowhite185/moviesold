package com.movies.app.movies.model.viewmodel;

import java.util.List;

/**
 * Created by Anusha on 10/13/2017.
 *
 * View model for movie details
 */

public class MovieItem {

    private int movieId;
    private String posterPath;
    private String backDropPath;
    private String title;
    private String overview;
    private String rating;
    private List<String> trailerKeys;
    private List<String> trailerName;
    private String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getTrailerKeys() {
        return trailerKeys;
    }

    public void setTrailerKeys(List<String> trailerKeys) {
        this.trailerKeys = trailerKeys;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public List<String> getTrailerNames() {
        return trailerName;
    }

    public void setTrailerName(List<String> trailerName) {
        this.trailerName = trailerName;
    }

    @Override
    public String toString() {
        return "MovieItem{" +
                "movieId=" + movieId +
                ", posterPath='" + posterPath + '\'' +
                ", backDropPath='" + backDropPath + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", rating='" + rating + '\'' +
                ", trailerKeys=" + trailerKeys +
                ", trailerName=" + trailerName +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
