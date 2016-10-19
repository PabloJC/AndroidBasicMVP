package com.pabji.basicmvp.domain.features;

import android.util.Log;

import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.domain.features.base.BaseInteractorImpl;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class GetRecipeListInteractor extends BaseInteractorImpl<List<Recipe>> {

    //@Inject
    private RecipeRepository recipeRepository;

    @Inject
    public GetRecipeListInteractor(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    protected Observable<List<Recipe>> buildFeatureObservable() {
        return recipeRepository.getRecipeList();
    }
}
