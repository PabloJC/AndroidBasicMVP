package com.pabji.basicmvp.domain.features.base;

import com.pabji.basicmvp.domain.callbacks.DataListener;
import com.pabji.basicmvp.ui.mvp.models.Recipe;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public interface BaseInteractor<T> {
    void execute(Subscriber<T> subscriber);
}
