package com.pabji.basicmvp.domain.modules;

import android.content.Context;

import com.pabji.basicmvp.domain.scopes.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */
@Module
public class BaseActivityModule {
    private Context context;

    public BaseActivityModule(Context context){
        this.context = context;
    }

    @PerActivity
    @Named("ActivityContext")  @Provides
    Context provideActivityContext(){return context;}
}
