package com.pabji.basicmvp.domain.features.base;

import com.pabji.basicmvp.domain.executor.PostExecutionThread;
import com.pabji.basicmvp.domain.executor.ThreadExecutor;

import rx.Subscriber;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public interface BaseInteractor<T> {
    void execute(Subscriber<T> subscriber, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread);
}
