package com.movies.app.movies.presenter.impl;

import com.movies.app.movies.model.viewmodel.MovieItem;
import com.movies.app.movies.presenter.Presenter;
import com.movies.app.movies.service.DataProviderFacade;
import com.movies.app.movies.service.DataProviderFactory;
import com.movies.app.movies.service.ResponseListener;
import com.movies.app.movies.view.MoviesView;

import java.util.List;

/**
 * Created by Anusha on 10/11/2017.
 * <p>
 * Class which connects UI with service layer
 */

public class MoviesListPresenter implements Presenter<MoviesView> {

    private MoviesView moviesView;
    private boolean viewDestroyed;
    private ResponseListener<List<MovieItem>> listResponseListener;
    private ResponseListener<MovieItem> movieDetailsResponseListener;


    public MoviesListPresenter() {
        listResponseListener = new ResponseListener<List<MovieItem>>() {
            @Override
            public void onSuccess(List<MovieItem> movieItems) {
                if (moviesView != null) {
                    moviesView.onListResponseSuccess(movieItems);
                }
            }

            @Override
            public void onError(Exception e) {
                if (moviesView != null) {
                    moviesView.onError(e);
                }
            }
        };
        movieDetailsResponseListener = new ResponseListener<MovieItem>() {
            @Override
            public void onSuccess(MovieItem movieItem) {
                if (moviesView != null) {
                    moviesView.onMovieDetailResponseSuccess(movieItem);
                }
            }

            @Override
            public void onError(Exception e) {
                if (moviesView != null) {
                    moviesView.onError(e);
                }
            }
        };
    }

    @Override
    public void onTakeView(MoviesView view) {
        moviesView = view;
    }

    @Override
    public void onViewDestroyed() {
        viewDestroyed = true;
    }

    public void requestTopRatedMovies() {
        DataProviderFacade dataProvider = DataProviderFactory.getFacade();
        dataProvider.getMoviesList(listResponseListener);
    }

    public void requestMovieDetails(String movieId) {
        DataProviderFacade dataProvider = DataProviderFactory.getFacade();
        dataProvider.getMovieDetails(movieDetailsResponseListener, movieId);
    }
}
