package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.model.NewsModel;
import com.vnedomovnyi.runlooptest.model.NewsModel.LoadedData;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import java.util.List;

import timber.log.Timber;

@InjectViewState
public class LifestyleNewsPresenter extends MvpPresenter<LifestyleNewsView> {

    private NewsModel newsModel;

    public LifestyleNewsPresenter(NewsModel newsModel) {
        this.newsModel = newsModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        newsModel.getDataObservable().addObserver(observer);
    }

    @Override
    public void onDestroy() {
        newsModel.getDataObservable().removeObserver(observer);
        super.onDestroy();
    }

    private final Observer<LoadedData<List<Article>>> observer = data -> {
        if (data.hasData()) {
            Timber.d("Data loaded. data = %s", data.getData());
        } else {
            Timber.e(data.getError(), "Failed to get lifestyle news.");
        }
    };

}