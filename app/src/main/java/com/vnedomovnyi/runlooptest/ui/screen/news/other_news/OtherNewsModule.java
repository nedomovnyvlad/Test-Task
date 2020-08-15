package com.vnedomovnyi.runlooptest.ui.screen.news.other_news;

import com.vnedomovnyi.runlooptest.model.NewsModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.vnedomovnyi.runlooptest.di.module.ModelModule.WORLD;
import static com.vnedomovnyi.runlooptest.di.module.ModelModule.WSJD;

@Module
public class OtherNewsModule {

    @Provides
    OtherNewsPresenter provideOtherNewsPresenter(@Named(WSJD) NewsModel wsjdNewsModel,
                                                 @Named(WORLD) NewsModel worldNewsModel) {
        return new OtherNewsPresenter(wsjdNewsModel, worldNewsModel);
    }

}
