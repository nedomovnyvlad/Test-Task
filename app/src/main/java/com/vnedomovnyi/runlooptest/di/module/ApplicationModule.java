package com.vnedomovnyi.runlooptest.di.module;

import com.vnedomovnyi.runlooptest.ui.activity.main.MainActivity;
import com.vnedomovnyi.runlooptest.ui.activity.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public interface ApplicationModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    MainActivity splashActivityInjector();

}