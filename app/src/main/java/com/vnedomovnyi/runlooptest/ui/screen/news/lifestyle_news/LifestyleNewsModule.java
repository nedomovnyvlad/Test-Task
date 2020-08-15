package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.vnedomovnyi.runlooptest.network.NewsService;

import dagger.Module;
import dagger.Provides;

@Module
public class LifestyleNewsModule {

    @Provides
    LifestyleNewsPresenter provideLifestyleNewsPresenter(NewsService newsService) {
        return new LifestyleNewsPresenter(newsService);
    }

}
