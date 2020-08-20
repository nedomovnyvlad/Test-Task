package com.vnedomovnyi.testtask.ui.screen.news;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface NewsView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setLoadingVisibility(boolean isVisible);

}
