package com.vnedomovnyi.runlooptest;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.vnedomovnyi.runlooptest.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import timber.log.Timber;

public class RunloopTestApp extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> injector;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        AndroidThreeTen.init(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return injector;
    }

}
