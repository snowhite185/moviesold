package com.movies.app.movies.service.mapper;

import com.movies.app.movies.model.service.MovieDetails;
import com.movies.app.movies.model.service.PopularMovies;
import com.movies.app.movies.model.viewmodel.MovieItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anusha  on 10/13/2017.
 *
 * Class which maps movies list from service model to view model.
 */

public class MoviesListResponseMapper implements Transform<PopularMovies, List<MovieItem>> {
    @Override
    public List<MovieItem> onTransform(PopularMovies popularMovies) throws Exception {

        List<MovieItem> movieItems = new ArrayList<>();
        if (popularMovies != null) {
            List<MovieDetails> movieDetails = popularMovies.getMovieDetails();
            for (MovieDetails details : movieDetails) {
                if (details != null) {
                    MovieItem movieItem = new MovieItem();
                    movieItem.setPosterPath(details.getPosterPath());
                    movieItem.setMovieId(details.getMovieId());
                    movieItems.add(movieItem);
                }
            }
        }
        return movieItems;
    }
}
