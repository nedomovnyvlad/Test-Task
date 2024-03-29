package com.vnedomovnyi.testtask;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.vnedomovnyi.testtask.di.DaggerAppComponent;
import com.vnedomovnyi.testtask.model.UpdateDataModel;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import timber.log.Timber;

public class TestTaskApp extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> injector;

    @Inject
    UpdateDataModel updateDataModel;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        AndroidThreeTen.init(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        updateDataModel.startUpdating();
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
