package com.vnedomovnyi.testtask.di.module;

import com.vnedomovnyi.testtask.ui.activity.main.MainActivity;
import com.vnedomovnyi.testtask.ui.activity.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public interface ApplicationModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    MainActivity mainActivity();

}