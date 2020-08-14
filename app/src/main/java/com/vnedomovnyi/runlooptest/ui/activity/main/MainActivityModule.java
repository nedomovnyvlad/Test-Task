package com.vnedomovnyi.runlooptest.ui.activity.main;

import com.vnedomovnyi.runlooptest.ui.screen.general.GeneralFragment;
import com.vnedomovnyi.runlooptest.ui.screen.general.GeneralModule;
import com.vnedomovnyi.runlooptest.ui.screen.news.NewsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector(modules = GeneralModule.class)
    GeneralFragment generalFragment();

    @ContributesAndroidInjector
    NewsFragment newsFragment();

}
