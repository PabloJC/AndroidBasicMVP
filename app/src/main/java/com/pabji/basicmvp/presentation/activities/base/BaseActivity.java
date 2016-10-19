package com.pabji.basicmvp.presentation.activities.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.pabji.basicmvp.MyApplication;
import com.pabji.basicmvp.domain.components.MyApplicationComponent;
import com.pabji.basicmvp.domain.modules.BaseActivityModule;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getInjector().inject(this);
    }

    protected MyApplicationComponent getInjector(){
        return ((MyApplication) getApplication()).getInjector();
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected BaseActivityModule getActivityModule(){
        return new BaseActivityModule(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}