package com.vnedomovnyi.runlooptest.ui.screen.news;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.vnedomovnyi.runlooptest.entity.Article;

import java.util.List;

public interface NewsTabView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setData(List<Article> articles);

}
