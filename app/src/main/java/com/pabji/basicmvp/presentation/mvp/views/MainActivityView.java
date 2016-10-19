package com.pabji.basicmvp.presentation.mvp.views;

import com.pabji.basicmvp.presentation.mvp.models.Recipe;
import com.pabji.basicmvp.presentation.mvp.views.base.BaseView;

import java.util.List;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public interface MainActivityView extends BaseView {
    void showRecipeList(List<Recipe> recipes);
}
