package com.pabji.basicmvp.core.datasources;

import com.pabji.basicmvp.core.repositories.RecipeRepository;
import com.pabji.basicmvp.ui.mvp.models.Recipe;

import java.util.List;

import rx.Observable;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class RecipeServerDatasource implements RecipeRepository {

    @Override
    public Observable<List<Recipe>> getRecipeList() {
        return null;
    }

}
