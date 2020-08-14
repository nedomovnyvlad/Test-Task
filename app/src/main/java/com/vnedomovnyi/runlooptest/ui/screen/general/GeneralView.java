package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface GeneralView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setTimeText(String text);

}
