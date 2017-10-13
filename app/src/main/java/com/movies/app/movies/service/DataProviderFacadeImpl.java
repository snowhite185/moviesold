package com.movies.app.movies.service;

import android.net.Uri;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.movies.app.movies.model.service.MovieDetails;
import com.movies.app.movies.model.service.PopularMovies;
import com.movies.app.movies.model.viewmodel.MovieItem;
import com.movies.app.movies.service.mapper.MovieDetailsResponseMapper;
import com.movies.app.movies.service.mapper.MoviesListResponseMapper;

import java.net.URI;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by Anusha on 10/12/2017.
 *
 * Facade implementation class which handles service calls.
 */

public class DataProviderFacadeImpl implements DataProviderFacade {

    private static final String API_KEY = "2cd41f838b61175d9c473f95a03c80b1";

    @Override
    public void getMoviesList(final ResponseListener<List<MovieItem>> listener) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("api.themoviedb.org")
                .appendPath("3")
                .appendPath("discover")
                .appendPath("movie")
                .appendQueryParameter("api_key", API_KEY)
                .appendQueryParameter("language", "en-US")
                .appendQueryParameter("sort_by", "popularity.desc")
                .appendQueryParameter("include_adult", "false")
                .appendQueryParameter("include_video", "false")
                .appendQueryParameter("page", "popularity.desc");
        String url = builder.build().toString();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Gson gson = new Gson();
                    PopularMovies popularMovies = gson.fromJson(response, PopularMovies.class);
                    List<MovieItem> movieItems = new MoviesListResponseMapper().onTransform(popularMovies);
                    if (listener != null) {
                        listener.onSuccess(movieItems);
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onError(error);
                }
            }
        });

        AppController.getInstance().addToRequestQueue(request);
    }

    @Override
    public void getMovieDetails(final ResponseListener<MovieItem> listener, String movieId) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("api.themoviedb.org")
                .appendPath("3")
                .appendPath("movie")
                .appendPath(movieId)
                .appendQueryParameter("api_key", API_KEY)
                .appendQueryParameter("language", "en-US")
                .appendQueryParameter("append_to_response", "videos");
        String url = builder.build().toString();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Gson gson = new Gson();
                    MovieDetails movieDetails = gson.fromJson(response, MovieDetails.class);
                    MovieItem movieItem = new MovieDetailsResponseMapper().onTransform(movieDetails);
                    if (listener != null) {
                        listener.onSuccess(movieItem);
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onError(error);
                }
            }
        });

        AppController.getInstance().addToRequestQueue(request);
    }

}
