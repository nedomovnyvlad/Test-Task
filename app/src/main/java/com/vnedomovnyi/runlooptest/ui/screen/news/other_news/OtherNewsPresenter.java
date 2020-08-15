package com.vnedomovnyi.runlooptest.ui.screen.news.other_news;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.model.DataModel;
import com.vnedomovnyi.runlooptest.model.NewsModel.LoadedData;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import java.util.List;

import timber.log.Timber;

@InjectViewState
public class OtherNewsPresenter extends MvpPresenter<OtherNewsView> {

    private final DataModel<LoadedData<List<Article>>> wsjdNewsModel;

    private final DataModel<LoadedData<List<Article>>> worldNewsModel;

    public OtherNewsPresenter(DataModel<LoadedData<List<Article>>> wsjdNewsModel,
                              DataModel<LoadedData<List<Article>>> worldNewsModel) {
        this.wsjdNewsModel = wsjdNewsModel;
        this.worldNewsModel = worldNewsModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        wsjdNewsModel.getDataObservable().addObserver(wsjdNewsObserver);
        worldNewsModel.getDataObservable().addObserver(worldNewsObserver);
    }

    @Override
    public void onDestroy() {
        wsjdNewsModel.getDataObservable().removeObserver(wsjdNewsObserver);
        worldNewsModel.getDataObservable().removeObserver(worldNewsObserver);

        super.onDestroy();
    }

    private final Observer<LoadedData<List<Article>>> wsjdNewsObserver = data -> {
        if (data.hasData()) {
            Timber.d("Data loaded. data = %s", data.getData());
        } else {
            Timber.e(data.getError(), "Failed to get WSJD news.");
        }
    };

    private final Observer<LoadedData<List<Article>>> worldNewsObserver = data -> {
        if (data.hasData()) {
            Timber.d("Data loaded. data = %s", data.getData());
        } else {
            Timber.e(data.getError(), "Failed to get world news.");
        }
    };

}
