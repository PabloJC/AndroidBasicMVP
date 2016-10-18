package com.pabji.basicmvp.domain.modules;

import android.content.Context;

import dagger.Module;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

@Module
public class MainActivityModule extends BaseActivityModule {

    public MainActivityModule(Context context) {
        super(context);
    }
}
