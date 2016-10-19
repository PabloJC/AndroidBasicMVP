package com.pabji.basicmvp.data.repositories;

import android.content.Context;
import android.util.Log;

import com.pabji.basicmvp.data.network.Connectivity;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Pablo Jiménez Casado on 19/10/2016.
 */

public class BaseRepository {

    @Inject @Named("ApplicationContext")
    Context context;

    protected boolean haveInternetConnection() {
        Log.d("Context","Context");
        return Connectivity.haveInternetConnection(context);
    }
}
