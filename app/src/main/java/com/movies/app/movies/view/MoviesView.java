package com.movies.app.movies.view;

/**
 * Created by 10599 on 10/11/2017.
 */

public interface MoviesView {



    /**
     * Callback containing the formatted data, after receiving a success response from server.
     *
     * @param videoInfoVm : View model containing formatted data.
     */
    void onResponseSuccess(String videoInfoVm);

    /**
     * Callback containing the error details, after receiving an unexpected exception from server.
     *
     * @param errorResponseBM : Model containing error details.
     */
//    void onError(ErrorResponseBM errorResponseBM);

    /**
     * Callback which informs UI that the server returned a success response but with empty data.
     */
//    void onNoDataAvailable();
}
