package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.vnedomovnyi.runlooptest.model.LifestyleNewsModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LifestyleNewsModule {

    @Provides
    LifestyleNewsPresenter provideLifestyleNewsPresenter(LifestyleNewsModel lifestyleNewsModel) {
        return new LifestyleNewsPresenter(lifestyleNewsModel);
    }

}
