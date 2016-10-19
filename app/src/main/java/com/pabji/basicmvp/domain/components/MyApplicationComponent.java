package com.pabji.basicmvp.domain.components;

import android.content.Context;

import com.pabji.basicmvp.data.datasources.RecipeSQliteDatasource;
import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.domain.executor.PostExecutionThread;
import com.pabji.basicmvp.domain.executor.ThreadExecutor;
import com.pabji.basicmvp.domain.modules.MyApplicationModule;
import com.pabji.basicmvp.presentation.activities.base.BaseActivity;
import com.pabji.basicmvp.presentation.navigation.Router;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

@Singleton
@Component(modules = MyApplicationModule.class)
public interface MyApplicationComponent {
    void inject(BaseActivity baseActivity);

    @Named("ApplicationContext")
    Context getContext();
    Router getRouter();
    RecipeRepository getRecipeRepository();
    ThreadExecutor getThreadExecutor();
    PostExecutionThread getPostExecutionThread();
}
