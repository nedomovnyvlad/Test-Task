package com.vnedomovnyi.testtask.ui.screen.news.other_news;

import com.vnedomovnyi.testtask.model.ChosenArticleModel;
import com.vnedomovnyi.testtask.model.NewsModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.vnedomovnyi.testtask.di.module.ModelModule.WORLD;
import static com.vnedomovnyi.testtask.di.module.ModelModule.WSJD;

@Module
public class OtherNewsModule {

    @Provides
    OtherNewsPresenter provideOtherNewsPresenter(ChosenArticleModel chosenArticleModel,
                                                 @Named(WSJD) NewsModel wsjdNewsModel,
                                                 @Named(WORLD) NewsModel worldNewsModel) {
        return new OtherNewsPresenter(
                chosenArticleModel,
                wsjdNewsModel.getDataObservable(),
                worldNewsModel.getDataObservable()
        );
    }

}
