package com.movies.app.movies.service.mapper;

import com.movies.app.movies.model.service.MovieDetails;
import com.movies.app.movies.model.service.MovieTrailers;
import com.movies.app.movies.model.service.Trailer;
import com.movies.app.movies.model.viewmodel.MovieItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anusha on 10/13/2017.
 *
 * Class which maps movie details from service model to view model.
 */

public class MovieDetailsResponseMapper implements Transform<MovieDetails, MovieItem> {
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w154";
    private static final String IMAGE_BAK_URL = "http://image.tmdb.org/t/p/w780";

    @Override
    public MovieItem onTransform(MovieDetails movieDetails) throws Exception {
        MovieItem movieItem = new MovieItem();
        if (movieDetails != null) {
            movieItem.setBackDropPath(IMAGE_BAK_URL + movieDetails.getBackDropPath());
            movieItem.setPosterPath(IMAGE_BASE_URL+movieDetails.getPosterPath());
            movieItem.setMovieId(movieDetails.getMovieId());
            movieItem.setRating(String.valueOf(movieDetails.getVoteAverage()));
            movieItem.setOverview(movieDetails.getOverview());
            movieItem.setTitle(movieDetails.getTitle());
            List<String> trailerKeys = new ArrayList<>();
            List<String> trailerNames = new ArrayList<>();
            movieItem.setReleaseDate(movieDetails.getReleaseDate());
            MovieTrailers trailers = movieDetails.getTrailers();
            if (trailers != null) {
                for (Trailer trailer : trailers.getTrailers()) {
                    if (trailer != null) {
                        trailerKeys.add(trailer.getKey());
                        trailerNames.add(trailer.getName());
                    }
                }
            }
            movieItem.setTrailerKeys(trailerKeys);
            movieItem.setTrailerName(trailerNames);
        }
        return movieItem;
    }
}
