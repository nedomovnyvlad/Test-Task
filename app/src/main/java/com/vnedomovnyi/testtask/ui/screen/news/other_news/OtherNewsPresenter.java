package com.vnedomovnyi.testtask.ui.screen.news.other_news;

import com.arellomobile.mvp.InjectViewState;
import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.model.ChosenArticleModel;
import com.vnedomovnyi.testtask.model.NewsModel.LoadedData;
import com.vnedomovnyi.testtask.ui.screen.news.news_tab.NewsTabPresenter;
import com.vnedomovnyi.testtask.util.observer.Observable;
import com.vnedomovnyi.testtask.util.observer.Observer;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

import static java.util.Objects.requireNonNull;

@InjectViewState
public class OtherNewsPresenter extends NewsTabPresenter {

    private final Observable<LoadedData<List<Article>>> wsjdNewsObservable;

    private final Observable<LoadedData<List<Article>>> worldNewsObservable;

    private final List<Article> wsjdArticles = new ArrayList<>();

    private final List<Article> worldArticles = new ArrayList<>();

    public OtherNewsPresenter(ChosenArticleModel chosenArticleModel,
                              Observable<LoadedData<List<Article>>> wsjdNewsObservable,
                              Observable<LoadedData<List<Article>>> worldNewsObservable) {
        super(chosenArticleModel);
        this.wsjdNewsObservable = wsjdNewsObservable;
        this.worldNewsObservable = worldNewsObservable;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        wsjdNewsObservable.addObserver(wsjdNewsObserver);
        worldNewsObservable.addObserver(worldNewsObserver);
    }

    @Override
    public void onDestroy() {
        wsjdNewsObservable.removeObserver(wsjdNewsObserver);
        worldNewsObservable.removeObserver(worldNewsObserver);

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
