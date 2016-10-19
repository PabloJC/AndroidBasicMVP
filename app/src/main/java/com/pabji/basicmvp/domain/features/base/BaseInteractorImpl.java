package com.pabji.basicmvp.domain.features.base;

import com.pabji.basicmvp.domain.executor.PostExecutionThread;
import com.pabji.basicmvp.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public abstract class BaseInteractorImpl<T> implements BaseInteractor<T>{

    /*@Inject
    ThreadExecutor threadExecutor;

    @Inject
    PostExecutionThread postExecutionThread;*/

    private Subscription subscription = Subscriptions.empty();

    protected abstract Observable<T> buildFeatureObservable();

    @Override
    public void execute(Subscriber<T> subscriber, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.subscription = this.buildFeatureObservable()
            .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
