package com.movies.app.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movies.app.movies.presenter.impl.MoviesListPresenter;
import com.movies.app.movies.view.MoviesView;

import java.util.ArrayList;

/**
 * Created by 10599 on 10/11/2017.
 */

public class MovieListFragment extends Fragment implements MoviesView {

    private RecyclerView rvMovies;
    private MoviesListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_list_main_view, container, false);
        initViews(view);
        presenter = new MoviesListPresenter();
        presenter.onTakeView(this);
        presenter.requestTopRatedMovies();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initViews(View view) {
        rvMovies = (RecyclerView) view.findViewById(R.id.rvMovies);
//        MoviesListAdapter adapter = new MoviesListAdapter(new ArrayList<String>(), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
        rvMovies.setLayoutManager(gridLayoutManager);
//        rvMovies.setAdapter(adapter);
    }

    @Override
    public void onResponseSuccess(String videoInfoVm) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.onViewDestroyed();
        }
    }
}
