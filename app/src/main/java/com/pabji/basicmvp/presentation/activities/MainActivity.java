package com.pabji.basicmvp.presentation.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


import com.pabji.basicmvp.R;
import com.pabji.basicmvp.domain.components.DaggerMainActivityComponent;
import com.pabji.basicmvp.domain.components.MainActivityComponent;
import com.pabji.basicmvp.domain.scopes.HasComponent;
import com.pabji.basicmvp.domain.modules.MainActivityModule;
import com.pabji.basicmvp.presentation.activities.base.BaseMVPActivity;
import com.pabji.basicmvp.presentation.adapters.RecipeListAdapter;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;
import com.pabji.basicmvp.presentation.mvp.presenters.MainActivityPresenter;
import com.pabji.basicmvp.presentation.mvp.views.MainActivityView;
import com.pabji.basicmvp.presentation.utils.SimpleItemTouchHelper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseMVPActivity<MainActivityPresenter,MainActivityView> implements MainActivityView, HasComponent<MainActivityComponent> {

    private MainActivityComponent component;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    MainActivityPresenter presenter;

    @Inject
    RecipeListAdapter recipeListAdapter;

    @Inject
    SimpleItemTouchHelper simpleItemTouchHelper;

    private Unbinder unbind;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbind = ButterKnife.bind(this);

        initRecyclerView();

        presenter.init();
    }

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {
        return presenter;
    }

    @Override
    public MainActivityComponent getComponent() {
        return component;
    }

    private void initializeInjector() {
        this.component = DaggerMainActivityComponent.builder()
                .myApplicationComponent(getInjector())
                .mainActivityModule(new MainActivityModule(this))
                .build();
        component.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind.unbind();
    }

    @Override
    public void showRecipeList(List<Recipe> recipes) {
        recipeListAdapter.setData(recipes);
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showEmptyList() {

    }


    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recipeListAdapter);

        simpleItemTouchHelper.setAdapter(recipeListAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(simpleItemTouchHelper);
        touchHelper.attachToRecyclerView(recyclerView);

        swipeRefreshLayout.requestDisallowInterceptTouchEvent(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getRecipeList();
            }
        });
    }

}
