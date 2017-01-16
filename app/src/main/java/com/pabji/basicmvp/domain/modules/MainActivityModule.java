package com.pabji.basicmvp.domain.modules;

import android.content.Context;

import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.domain.features.GetRecipeListInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

@Module
public class MainActivityModule extends BaseActivityModule {

    public MainActivityModule(Context context) {
        super(context);
    }

    @Provides
    GetRecipeListInteractor provideRecipeListInteractor(RecipeRepository recipeRepository){
        return new GetRecipeListInteractor(recipeRepository);
    }


}
