package yuri.lechshnko.com.mye.app;

import android.app.Application;

import timber.log.Timber;
import yuri.lechshnko.com.mye.BuildConfig;


public class App extends Application {

    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

    }
}
