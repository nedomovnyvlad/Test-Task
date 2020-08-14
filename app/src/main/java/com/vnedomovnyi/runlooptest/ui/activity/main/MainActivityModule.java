package com.vnedomovnyi.runlooptest.ui.activity.main;

import com.vnedomovnyi.runlooptest.ui.screen.general.GeneralFragment;
import com.vnedomovnyi.runlooptest.ui.screen.general.GeneralModule;
import com.vnedomovnyi.runlooptest.ui.screen.news.NewsFragment;
import com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news.LifestyleNewsFragment;
import com.vnedomovnyi.runlooptest.ui.screen.news.other_news.OtherNewsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector(modules = GeneralModule.class)
    GeneralFragment generalFragment();

    @ContributesAndroidInjector
    NewsFragment newsFragment();

    @ContributesAndroidInjector
    LifestyleNewsFragment lifestyleNewsFragment();

    @ContributesAndroidInjector
    OtherNewsFragment otherNewsFragment();

}
