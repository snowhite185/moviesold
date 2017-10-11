package com.movies.app.movies.service;

/**
 * Created by Anusha on 10/12/2017.
 */

public interface DataProviderFacade {

    void getMoviesList(ResponseListener<String> listener);
}
