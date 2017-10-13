package com.movies.app.movies.view;

import com.movies.app.movies.model.viewmodel.MovieItem;

import java.util.List;

/**
 * Created by Anusha on 10/11/2017.
 *
 * View callback interface.
 */

public interface MoviesView {

    void onListResponseSuccess(List<MovieItem> movieItems);

    void onMovieDetailResponseSuccess(MovieItem movieItem);

    void onError(Exception exception);

}
