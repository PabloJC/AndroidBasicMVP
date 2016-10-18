package com.pabji.basicmvp.domain.modules;

import android.content.Context;

import com.pabji.basicmvp.ui.navigation.Router;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */
@Module
public class MyApplicationModule {
    private final Context context;

    public MyApplicationModule(Context context) {
        this.context = context;
    }

    @Named("ApplicationContext") @Provides
    @Singleton
    Context provideApplicationContext(){
        return this.context;
    }

    @Provides @Singleton
    Router provideRouter(){
        return new Router();
    }
}
