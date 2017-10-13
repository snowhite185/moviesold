package com.movies.app.movies.presenter;

/**
 * Created by Anusha on 10/11/2017.
 * <p>
 * This interface is meant for ensuring the lifecycle of a Presenter.
 * All presenter classes must implement {@link Presenter<T>}
 * </p>
 */

public interface Presenter<T> {
    /**
     * This method should be called when the View is created.
     *
     * @param view
     */
    void onTakeView(T view);

    /**
     * This method is called once a View is entirely destroyed.
     */
    void onViewDestroyed();

}
