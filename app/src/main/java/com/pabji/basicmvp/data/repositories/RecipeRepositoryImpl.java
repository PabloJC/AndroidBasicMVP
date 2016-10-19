package com.pabji.basicmvp.data.repositories;

import com.pabji.basicmvp.data.datasources.RecipeSQliteDatasource;
import com.pabji.basicmvp.data.datasources.RecipeServerDatasource;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Pablo Jiménez Casado on 19/10/2016.
 */

public class RecipeRepositoryImpl extends BaseRepository implements RecipeRepository {

    @Inject
    RecipeServerDatasource serverDatasource;

    @Inject
    RecipeSQliteDatasource sQliteDatasource;

    @Inject
    public RecipeRepositoryImpl(){}

    @Override
    public Observable<List<Recipe>> getRecipeList() {
        if(haveInternetConnection()){
            return serverDatasource.getRecipeList();
        }else{
            return sQliteDatasource.getRecipeList();
        }
    }
}
