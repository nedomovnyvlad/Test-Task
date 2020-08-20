package com.vnedomovnyi.testtask.ui.screen.general;

import com.vnedomovnyi.testtask.model.ChosenArticleModel;
import com.vnedomovnyi.testtask.model.CurrentTimeModel;

import dagger.Module;
import dagger.Provides;

@Module
public class GeneralModule {

    @Provides
    GeneralPresenter provideGeneralPresenter(CurrentTimeModel currentTimeModel,
                                             ChosenArticleModel chosenArticleModel) {
        return new GeneralPresenter(
                currentTimeModel.getCurrentTimeObservable(),
                chosenArticleModel.getChosenArticleObservable()
        );
    }

}
