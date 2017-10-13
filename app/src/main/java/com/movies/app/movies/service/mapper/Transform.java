package com.movies.app.movies.service.mapper;

/**
 * Created by Anusha on 10/13/2017.
 *
 * Interface to transform objects
 */

public interface Transform<U, V> {

    V onTransform(U u) throws Exception;
}
