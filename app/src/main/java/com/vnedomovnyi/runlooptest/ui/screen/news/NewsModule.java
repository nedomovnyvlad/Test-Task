package com.vnedomovnyi.runlooptest.ui.screen.news;

import com.vnedomovnyi.runlooptest.model.UpdateDataModel;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    @Provides
    NewsPresenter provideNewsPresenter(UpdateDataModel updateDataModel) {
        return new NewsPresenter(updateDataModel);
    }

}
