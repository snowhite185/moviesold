package com.movies.app.movies.service;

/**
 * Created by Anusha on 10/12/2017.
 *
 * Factory class for facade object creation.
 */

public class DataProviderFactory {
    public static DataProviderFacade getFacade() {
        return new DataProviderFacadeImpl();
    }
}
