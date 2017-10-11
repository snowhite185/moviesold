package com.movies.app.movies.service;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import static com.movies.app.movies.service.AppController.TAG;

/**
 * Created by Anusha on 10/12/2017.
 */

public class DataProviderFacadeImpl implements DataProviderFacade {

    private static final String API_KEY = "2cd41f838b61175d9c473f95a03c80b1";
    private static final String BASE_URL = "https://api.themoviedb.org/3/configuration?api_key=" + API_KEY;
    private static final String MOVIE_URL = "https://api.themoviedb" +
            ".org/3/discover/movie?api_key=2cd41f838b61175d9c473f95a03c80b1&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";

    @Override
    public void getMoviesList(ResponseListener<String> listener) {
// Tag used to cancel the request
        String tag_json_obj = "json_obj_req";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                MOVIE_URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }
}
