package com.vnedomovnyi.testtask.ui.screen.news;

import com.vnedomovnyi.testtask.model.UpdateDataModel;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    @Provides
    NewsPresenter provideNewsPresenter(UpdateDataModel updateDataModel) {
        return new NewsPresenter(updateDataModel.getLoadingStatusObservable());
    }

}
