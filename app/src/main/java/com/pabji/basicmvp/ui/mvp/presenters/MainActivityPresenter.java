package com.pabji.basicmvp.ui.mvp.presenters;

import android.content.Context;

import com.pabji.basicmvp.ui.mvp.presenters.base.BasePresenter;
import com.pabji.basicmvp.ui.mvp.views.base.MainActivityView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityView>{

    @Inject
    @Named("ActivityContext")
    Context context;

    @Inject
    public MainActivityPresenter(){}

    public void init() {
    }
}
