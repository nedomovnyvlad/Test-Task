package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.vnedomovnyi.runlooptest.model.NewsModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.vnedomovnyi.runlooptest.di.module.ModelModule.LIFESTYLE;

@Module
public class LifestyleNewsModule {

    @Provides
    LifestyleNewsPresenter provideLifestyleNewsPresenter(@Named(LIFESTYLE) NewsModel newsModel) {
        return new LifestyleNewsPresenter(newsModel);
    }

}
