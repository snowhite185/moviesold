package com.movies.app.movies.presenter;

/**
 * Created by 10599 on 10/11/2017.
 * <p>
 * This interface is meant for ensuring the lifecycle of a Presenter.
 * All presenter classes must implement {@link Presenter<T>}
 * </p>
 */

public interface Presenter<T> {
    /**
     * This method should be called when the View is created.
     * Implementation of this method may have the logic to publish the data to View before sending a new request to server,
     * if the presenter already has the data.
     *
     * @param view
     */
    void onTakeView(T view);

    /**
     * This method is called once a View is entirely destroyed.
     */
    void onViewDestroyed();

}
