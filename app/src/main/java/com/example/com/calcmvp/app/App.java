package com.example.com.calcmvp.app;

import android.app.Application;

import com.example.com.calcmvp.Router;
import timber.log.Timber;
import com.example.com.calcmvp.BuildConfig;


public class App extends Application {

    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
        Router.getInstanse();
    }
}
