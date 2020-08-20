package com.vnedomovnyi.testtask.ui.screen.news.lifestyle_news;

import com.vnedomovnyi.testtask.model.ChosenArticleModel;
import com.vnedomovnyi.testtask.model.NewsModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.vnedomovnyi.testtask.di.module.ModelModule.LIFESTYLE;

@Module
public class LifestyleNewsModule {

    @Provides
    LifestyleNewsPresenter provideLifestyleNewsPresenter(ChosenArticleModel chosenArticleModel,
                                                         @Named(LIFESTYLE) NewsModel newsModel) {
        return new LifestyleNewsPresenter(chosenArticleModel, newsModel.getDataObservable());
    }

}
