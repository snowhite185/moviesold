package com.movies.app.movies.service;

import com.movies.app.movies.model.service.MovieDetails;
import com.movies.app.movies.model.viewmodel.MovieItem;

import java.util.List;

/**
 * Created by Anusha on 10/12/2017.
 *
 * Facade interface for service requests.
 */

public interface DataProviderFacade {

    void getMoviesList(ResponseListener<List<MovieItem>> listener);

    void getMovieDetails(ResponseListener<MovieItem> listener,String movieId);

}
