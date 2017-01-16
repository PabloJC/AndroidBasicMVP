package com.pabji.basicmvp.data.datasources;

import com.pabji.basicmvp.data.constants.ErrorConstants;
import com.pabji.basicmvp.data.persistence.DBSqlite;
import com.pabji.basicmvp.data.repositories.RecipeRepository;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class RecipeSQliteDatasource implements RecipeRepository {

    @Inject DBSqlite db;

    @Inject
    public RecipeSQliteDatasource(){
    }

    @Override
    public Observable<List<Recipe>> getRecipeList() {
        return Observable.create(new Observable.OnSubscribe<List<Recipe>>() {
            @Override
            public void call(Subscriber<? super List<Recipe>> subscriber) {
                try {
                    subscriber.onNext(db.getRecipeList());

                } catch(Exception ex) {
                    subscriber.onError(ex);
                }

            }
        });
    }
}
