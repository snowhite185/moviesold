package com.movies.app.movies;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.movies.app.movies.adapters.MoviesListAdapter;
import com.movies.app.movies.adapters.TrailersAdapter;
import com.movies.app.movies.model.viewmodel.MovieItem;
import com.movies.app.movies.presenter.impl.MoviesListPresenter;
import com.movies.app.movies.utils.GridSpacingItemDecoration;
import com.movies.app.movies.utils.RecyclerTouchListener;
import com.movies.app.movies.utils.Utils;
import com.movies.app.movies.view.MoviesView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 10599 on 10/11/2017.
 */

public class MovieListFragment extends Fragment implements MoviesView {

    private RecyclerView rvMovies;
    private MoviesListPresenter presenter;
    private ProgressBar progressBar;
    private ViewSwitcher viewSwitcher; // only for smartphone
    private RecyclerView rvTrailers;
    private TextView txtTitle;
    private TextView txtRating;
    private TextView txtOverview;
    private TextView txtReleaseDate;
    private ProgressBar movieDetailsProgress;
    private ImageView imgDetailsPoster;
    private ImageView imgBackDrop;
    private LinearLayout moviesDetailsLayout;
    private ImageView imgBackArrow;
    private boolean isTablet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_list_main_view, container, false);
        initViews(view);
        isTablet = Utils.isTablet(getContext());
        presenter = new MoviesListPresenter();
        presenter.onTakeView(this);
        if (Utils.isNetworkConnected(getContext())) {
            presenter.requestTopRatedMovies();
        } else {
            showSnackBar("No connection", "Retry", null);
        }
        return view;
    }

    private void initViews(View view) {
        rvMovies = view.findViewById(R.id.rvMovies);
        progressBar = view.findViewById(R.id.moviesListProgress);
        viewSwitcher = view.findViewById(R.id.viewSwitcher);
        rvTrailers = view.findViewById(R.id.rvTrailers);
        txtOverview = view.findViewById(R.id.txtMovieOverview);
        txtRating = view.findViewById(R.id.txtMovieRating);
        txtTitle = view.findViewById(R.id.txtMovieTitle);
        txtReleaseDate = view.findViewById(R.id.txtReleaseDate);
        txtReleaseDate = view.findViewById(R.id.txtReleaseDate);
        imgDetailsPoster = view.findViewById(R.id.imgDetailsPoster);
        imgBackDrop = view.findViewById(R.id.imgBackDrop);
        moviesDetailsLayout = view.findViewById(R.id.moviesDetailsLayout);
        movieDetailsProgress = view.findViewById(R.id.moviesDetailsProgress);
        imgBackDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isTablet){
                    viewSwitcher.setDisplayedChild(0);
                }
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
        rvMovies.setLayoutManager(gridLayoutManager);
        rvMovies.addItemDecoration(new GridSpacingItemDecoration(2, 15, true));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvTrailers.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.onViewDestroyed();
        }
    }

    @Override
    public void onListResponseSuccess(final List<MovieItem> movieItems) {
        if (isAdded()) {
            progressBar.setVisibility(View.GONE);
            rvMovies.setVisibility(View.VISIBLE);
            MoviesListAdapter adapter = new MoviesListAdapter(movieItems, getActivity());
            rvMovies.setAdapter(adapter);
            rvMovies.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rvMovies, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (!isTablet) {
                        viewSwitcher.setDisplayedChild(1);
                    }
                    movieDetailsProgress.setVisibility(View.VISIBLE);
                    moviesDetailsLayout.setVisibility(View.GONE);
                    int itemPosition = rvMovies.getChildLayoutPosition(view);
                    int movieId = movieItems.get(itemPosition).getMovieId();
                    presenter.requestMovieDetails(String.valueOf(movieId));
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
            presenter.requestMovieDetails(String.valueOf(movieItems.get(0).getMovieId()));
        }
    }

    @Override
    public void onMovieDetailResponseSuccess(MovieItem movieItem) {
        movieDetailsProgress.setVisibility(View.GONE);
        moviesDetailsLayout.setVisibility(View.VISIBLE);
        bindData(movieItem);
    }

    private void bindData(MovieItem movieItem) {
        if (movieItem != null) {
            txtReleaseDate.setText("Release date : " + movieItem.getReleaseDate());
            txtTitle.setText(movieItem.getTitle());
            txtRating.setText(movieItem.getRating());
            txtOverview.setText(movieItem.getOverview());
            final List<String> trailerKeys = movieItem
                    .getTrailerKeys();
            TrailersAdapter trailersAdapter = new TrailersAdapter(getActivity(), trailerKeys, movieItem.getTrailerNames());
            rvTrailers.setAdapter(trailersAdapter);
            Picasso.with(getActivity()).load(movieItem.getBackDropPath()).placeholder(R
                    .drawable.poster_placeholder).into(imgBackDrop);
            Picasso.with(getActivity()).load(movieItem.getPosterPath()).placeholder(R
                    .drawable.poster_placeholder).into(imgDetailsPoster);
            rvTrailers.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rvTrailers,
                    new RecyclerTouchListener.ClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            String youTubeId = trailerKeys.get(position);
                            watchYoutubeVideo(youTubeId);
                        }

                        @Override
                        public void onLongClick(View view, int position) {

                        }
                    }));
        }
    }

    @Override
    public void onError(Exception exception) {
        if (isAdded()) {
            progressBar.setVisibility(View.GONE);
            showSnackBar("Unable to fetch", "Retry", retryListener);
        }
    }

    private void showSnackBar(String message, String action, View.OnClickListener listener) {
        Snackbar.make(progressBar, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(action, listener).show();
    }

    View.OnClickListener retryListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (presenter != null) {
                progressBar.setVisibility(View.VISIBLE);
                presenter.requestTopRatedMovies();
            }
        }
    };

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            getContext().startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            getContext().startActivity(webIntent);
        }
    }

}
