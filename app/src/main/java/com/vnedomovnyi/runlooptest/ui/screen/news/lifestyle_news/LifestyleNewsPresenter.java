package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.arellomobile.mvp.InjectViewState;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.model.DataModel;
import com.vnedomovnyi.runlooptest.model.NewsModel.LoadedData;
import com.vnedomovnyi.runlooptest.ui.screen.news.NewsTabPresenter;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import java.util.List;

import timber.log.Timber;

@InjectViewState
public class LifestyleNewsPresenter extends NewsTabPresenter {

    private final DataModel<LoadedData<List<Article>>> dataModel;

    public LifestyleNewsPresenter(DataModel<LoadedData<List<Article>>> dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        dataModel.getDataObservable().addObserver(observer);
    }

    @Override
    public void onDestroy() {
        dataModel.getDataObservable().removeObserver(observer);
        super.onDestroy();
    }

    private final Observer<LoadedData<List<Article>>> observer = data -> {
        if (data.hasData()) {
            setData(data.getData());
        } else {
            Timber.e(data.getError(), "Failed to get lifestyle news.");
        }
    };

}
