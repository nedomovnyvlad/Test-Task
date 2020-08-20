package com.vnedomovnyi.testtask.ui.screen.news.news_tab;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.vnedomovnyi.testtask.entity.Article;

import java.util.List;

public interface NewsTabView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setData(List<Article> articles);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void openDescriptionScreen(String description);

}
