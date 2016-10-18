package com.pabji.basicmvp.domain.callbacks;

/**
 * Created by Pablo Jiménez Casado on 05/08/2016.
 */

public interface DataListener<T> {

    void onSuccess(T data);

    void onError(int error);
}
