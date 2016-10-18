package com.pabji.basicmvp;

import android.app.Application;

import com.pabji.basicmvp.domain.di.components.DaggerMyApplicationComponent;
import com.pabji.basicmvp.domain.di.components.MyApplicationComponent;
import com.pabji.basicmvp.domain.modules.MyApplicationModule;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class MyApplication extends Application {
    private MyApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyApplicationComponent.builder()
                .myApplicationModule(new MyApplicationModule(this))
                .build();
    }

    public MyApplicationComponent getInjector() {
        return component;
    }
}
