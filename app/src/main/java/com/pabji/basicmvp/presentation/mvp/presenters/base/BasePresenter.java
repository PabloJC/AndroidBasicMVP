package com.pabji.basicmvp.presentation.mvp.presenters.base;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.pabji.basicmvp.presentation.mvp.views.base.BaseView;

/**
 * Created by pabji on 16/06/2016.
 */
public class BasePresenter<T extends BaseView> extends MvpNullObjectBasePresenter<T>{

}
