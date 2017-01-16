package com.pabji.basicmvp.data.datasources;

import android.util.Log;

import com.pabji.basicmvp.data.network.ApiClient;
import com.pabji.basicmvp.data.network.ApiEndPoints;
import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class RecipeServerDatasource implements RecipeRepository {

    private final ApiEndPoints service;


    @Inject
    public RecipeServerDatasource(){
        service = ApiClient.createService(ApiEndPoints.class);
    }

    @Override
    public Observable<List<Recipe>> getRecipeList() {
        return service.recipes();
    }

}
