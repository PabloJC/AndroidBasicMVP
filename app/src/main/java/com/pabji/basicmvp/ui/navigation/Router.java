package com.pabji.basicmvp.ui.navigation;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

@Singleton
public class Router {

    @Inject @Named("ApplicationContext")
    Context applicationContext;

    @Inject
    public Router(){}
}
