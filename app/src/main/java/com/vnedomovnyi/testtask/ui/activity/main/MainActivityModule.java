package com.vnedomovnyi.testtask.ui.activity.main;

import com.vnedomovnyi.testtask.ui.screen.general.GeneralFragment;
import com.vnedomovnyi.testtask.ui.screen.general.GeneralModule;
import com.vnedomovnyi.testtask.ui.screen.news.NewsFragment;
import com.vnedomovnyi.testtask.ui.screen.news.NewsModule;
import com.vnedomovnyi.testtask.ui.screen.description.DescriptionFragment;
import com.vnedomovnyi.testtask.ui.screen.news.lifestyle_news.LifestyleNewsFragment;
import com.vnedomovnyi.testtask.ui.screen.news.lifestyle_news.LifestyleNewsModule;
import com.vnedomovnyi.testtask.ui.screen.news.other_news.OtherNewsFragment;
import com.vnedomovnyi.testtask.ui.screen.news.other_news.OtherNewsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector(modules = GeneralModule.class)
    GeneralFragment generalFragment();

    @ContributesAndroidInjector(modules = NewsModule.class)
    NewsFragment newsFragment();

    @ContributesAndroidInjector(modules = LifestyleNewsModule.class)
    LifestyleNewsFragment lifestyleNewsFragment();

    @ContributesAndroidInjector(modules = OtherNewsModule.class)
    OtherNewsFragment otherNewsFragment();

    @ContributesAndroidInjector
    DescriptionFragment descriptionFragment();

}
