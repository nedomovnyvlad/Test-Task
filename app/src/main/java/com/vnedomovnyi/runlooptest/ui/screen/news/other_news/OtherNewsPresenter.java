package com.vnedomovnyi.runlooptest.ui.screen.news.other_news;

import com.arellomobile.mvp.InjectViewState;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.model.ChosenArticleModel;
import com.vnedomovnyi.runlooptest.model.DataModel;
import com.vnedomovnyi.runlooptest.model.NewsModel.LoadedData;
import com.vnedomovnyi.runlooptest.ui.screen.news.news_tab.NewsTabPresenter;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

import static java.util.Objects.requireNonNull;

@InjectViewState
public class OtherNewsPresenter extends NewsTabPresenter {

    private final DataModel<LoadedData<List<Article>>> wsjdNewsModel;

    private final DataModel<LoadedData<List<Article>>> worldNewsModel;

    private final List<Article> wsjdArticles = new ArrayList<>();

    private final List<Article> worldArticles = new ArrayList<>();

    public OtherNewsPresenter(ChosenArticleModel chosenArticleModel,
                              DataModel<LoadedData<List<Article>>> wsjdNewsModel,
                              DataModel<LoadedData<List<Article>>> worldNewsModel) {
        super(chosenArticleModel);
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

    private void updateList(List<Article> originalList, List<Article> newList) {
        originalList.clear();
        originalList.addAll(newList);
        updateDisplayedList();
    }

    private void updateDisplayedList() {
        List<Article> articles = new ArrayList<>();
        articles.addAll(wsjdArticles);
        articles.addAll(worldArticles);

        setData(articles);
    }

    private final Observer<LoadedData<List<Article>>> wsjdNewsObserver = data -> {
        if (data.hasData()) {
            updateList(wsjdArticles, requireNonNull(data.getData()));
        } else {
            Timber.e(data.getError(), "Failed to get WSJD news.");
        }
    };

    private final Observer<LoadedData<List<Article>>> worldNewsObserver = data -> {
        if (data.hasData()) {
            updateList(worldArticles, requireNonNull(data.getData()));
        } else {
            Timber.e(data.getError(), "Failed to get world news.");
        }
    };

}
