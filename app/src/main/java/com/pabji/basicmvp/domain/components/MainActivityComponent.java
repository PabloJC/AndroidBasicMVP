package com.pabji.basicmvp.domain.components;

import com.pabji.basicmvp.domain.scopes.PerActivity;
import com.pabji.basicmvp.domain.modules.MainActivityModule;
import com.pabji.basicmvp.ui.activities.MainActivity;

import dagger.Component;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

@PerActivity
@Component(dependencies = MyApplicationComponent.class,modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
