package com.pabji.basicmvp.core.repositories;

import com.pabji.basicmvp.ui.mvp.models.Recipe;

import java.util.List;

import rx.Observable;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public interface RecipeRepository {
    Observable<List<Recipe>> getRecipeList();
}
