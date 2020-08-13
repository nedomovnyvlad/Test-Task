package com.vnedomovnyi.runlooptest;

import android.app.Application;

import timber.log.Timber;

public class RunloopTestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
