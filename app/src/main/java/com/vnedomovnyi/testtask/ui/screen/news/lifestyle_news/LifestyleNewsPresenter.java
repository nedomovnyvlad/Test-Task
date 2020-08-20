package com.vnedomovnyi.testtask.ui.screen.news.lifestyle_news;

import com.arellomobile.mvp.InjectViewState;
import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.model.ChosenArticleModel;
import com.vnedomovnyi.testtask.model.NewsModel.LoadedData;
import com.vnedomovnyi.testtask.ui.screen.news.news_tab.NewsTabPresenter;
import com.vnedomovnyi.testtask.util.observer.Observable;
import com.vnedomovnyi.testtask.util.observer.Observer;

import java.util.List;

import timber.log.Timber;

@InjectViewState
public class LifestyleNewsPresenter extends NewsTabPresenter {

    private final Observable<LoadedData<List<Article>>> dataObservable;

    public LifestyleNewsPresenter(ChosenArticleModel chosenArticleModel,
                                  Observable<LoadedData<List<Article>>> dataObservable) {
        super(chosenArticleModel);
        this.dataObservable = dataObservable;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        dataObservable.addObserver(observer);
    }

    @Override
    public void onDestroy() {
        dataObservable.removeObserver(observer);
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
