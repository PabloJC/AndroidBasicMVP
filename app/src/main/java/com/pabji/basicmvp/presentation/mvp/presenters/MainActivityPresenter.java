package com.pabji.basicmvp.presentation.mvp.presenters;

import android.content.Context;
import android.util.Log;

import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.domain.executor.PostExecutionThread;
import com.pabji.basicmvp.domain.executor.ThreadExecutor;
import com.pabji.basicmvp.domain.features.GetRecipeListInteractor;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;
import com.pabji.basicmvp.presentation.mvp.presenters.base.BasePresenter;
import com.pabji.basicmvp.presentation.mvp.views.MainActivityView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    @Inject
    @Named("ActivityContext")
    Context context;

    @Inject
    GetRecipeListInteractor recipeListInteractor;

    @Inject
    RecipeRepository recipeRepository;

    @Inject
    ThreadExecutor threadExecutor;

    @Inject
    PostExecutionThread postExecutionThread;

    @Inject
    public MainActivityPresenter(){}

    public void init() {
        getRecipeList();
    }

    public void getRecipeList(){
        recipeListInteractor.execute(new Subscriber<List<Recipe>>() {
            @Override
            public void onCompleted() {
                Log.d("Complete","Complete");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("onError","onError");
            }

            @Override
            public void onNext(List<Recipe> recipes) {
                if(recipes.isEmpty()){
                    Log.d("onNext","Vacio");
                }
                getView().showRecipeList(recipes);
            }
        },threadExecutor,postExecutionThread);
    }
}
