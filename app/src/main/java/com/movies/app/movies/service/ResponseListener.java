package com.movies.app.movies.service;

/**
 * Created by 10599 on 10/11/2017.
 * Generic Callback class can be used as a response listener interface
 */
public interface ResponseListener<T> {

    void onSuccess(T t);

    void onError(Exception e);
}
