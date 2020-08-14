package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.vnedomovnyi.runlooptest.model.CurrentTimeModel;

import dagger.Module;
import dagger.Provides;

@Module
public class GeneralModule {

    @Provides
    GeneralPresenter provideGeneralPresenter(CurrentTimeModel currentTimeModel) {
        return new GeneralPresenter(currentTimeModel);
    }

}
