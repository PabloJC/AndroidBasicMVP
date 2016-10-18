package com.pabji.basicmvp.domain.features;

import com.pabji.basicmvp.core.repositories.RecipeRepository;
import com.pabji.basicmvp.domain.features.base.BaseInteractorImpl;
import com.pabji.basicmvp.ui.mvp.models.Recipe;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class GetRecipeListInteractor extends BaseInteractorImpl<List<Recipe>> {

    @Inject
    RecipeRepository recipeRepository;

    @Override
    protected Observable<List<Recipe>> buildFeatureObservable() {
        return recipeRepository.getRecipeList();
    }
}
