package com.movies.app.movies.presenter.impl;

import com.movies.app.movies.presenter.Presenter;
import com.movies.app.movies.service.DataProviderFacade;
import com.movies.app.movies.service.DataProviderFacadeImpl;
import com.movies.app.movies.service.DataProviderFactory;
import com.movies.app.movies.service.ResponseListener;
import com.movies.app.movies.view.MoviesView;

/**
 * Created by 10599 on 10/11/2017.
 */

public class MoviesListPresenter implements Presenter<MoviesView> {

    private MoviesView moviesView;
    private boolean viewDestroyed;
    private ResponseListener<String> responseListener;


    public MoviesListPresenter() {
        responseListener = new ResponseListener<String>() {
            @Override
            public void onSuccess(String s) {
                moviesView.onResponseSuccess(s);
            }

            @Override
            public void onError(Exception e) {

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

    public void requestTopRatedMovies(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DataProviderFacade dataProvider = DataProviderFactory.getFacade();
                dataProvider.getMoviesList(responseListener);
            }
        });
        thread.start();
    }
}
