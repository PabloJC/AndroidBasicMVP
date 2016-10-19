package com.pabji.basicmvp.data.network;

import com.pabji.basicmvp.presentation.mvp.models.Ingredient;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Pablo Jiménez Casado on 19/10/2016.
 */

public interface ApiEndPoints {
    @GET("/recipes")
    Observable<List<Recipe>> recipes();
    @GET("recipes/{id}")
    Observable<Recipe> getRecipe(@Path("id") long id);
    @GET("/ingredients")
    Observable<List<Ingredient>> ingredients();
}
