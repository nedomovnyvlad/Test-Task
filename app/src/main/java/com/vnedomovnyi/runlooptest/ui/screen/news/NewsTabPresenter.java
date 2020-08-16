package com.vnedomovnyi.runlooptest.ui.screen.news;

import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.entity.Article;

import java.util.List;

public abstract class NewsTabPresenter extends MvpPresenter<NewsTabView> {

    protected void setData(List<Article> articles) {
        getViewState().setData(articles);
    }

}
