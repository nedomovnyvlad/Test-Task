package com.vnedomovnyi.runlooptest.ui.activity.main;

import com.vnedomovnyi.runlooptest.ui.screen.general.GeneralFragment;
import com.vnedomovnyi.runlooptest.ui.screen.general.GeneralModule;
import com.vnedomovnyi.runlooptest.ui.screen.news.NewsFragment;
import com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news.LifestyleNewsFragment;
import com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news.LifestyleNewsModule;
import com.vnedomovnyi.runlooptest.ui.screen.news.other_news.OtherNewsFragment;
import com.vnedomovnyi.runlooptest.ui.screen.news.other_news.OtherNewsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector(modules = GeneralModule.class)
    GeneralFragment generalFragment();

    @ContributesAndroidInjector
    NewsFragment newsFragment();

    @ContributesAndroidInjector(modules = LifestyleNewsModule.class)
    LifestyleNewsFragment lifestyleNewsFragment();

    @ContributesAndroidInjector(modules = OtherNewsModule.class)
    OtherNewsFragment otherNewsFragment();

}
