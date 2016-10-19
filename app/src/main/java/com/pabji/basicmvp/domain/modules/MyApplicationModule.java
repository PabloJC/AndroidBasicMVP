package com.pabji.basicmvp.domain.modules;

import android.content.Context;

import com.pabji.basicmvp.data.helpers.DBSqlite;
import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.data.repositories.RecipeRepositoryImpl;
import com.pabji.basicmvp.domain.executor.PostExecutionThread;
import com.pabji.basicmvp.domain.executor.ThreadExecutor;
import com.pabji.basicmvp.domain.executor.ThreadExecutorImpl;
import com.pabji.basicmvp.domain.executor.UIThread;
import com.pabji.basicmvp.presentation.navigation.Router;

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

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(ThreadExecutorImpl threadExecutor){
        return threadExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides @Singleton
    RecipeRepository provideRecipeRepository(RecipeRepositoryImpl recipeRepository){
        return recipeRepository;
    }

    @Provides @Singleton
    DBSqlite provideDBSqlite(){
        return new DBSqlite(context);
    }

}
