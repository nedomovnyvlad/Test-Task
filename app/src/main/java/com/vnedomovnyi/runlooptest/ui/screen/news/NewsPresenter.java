package com.vnedomovnyi.runlooptest.ui.screen.news;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.util.observer.Observable;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsView> {

    private final Observable<Boolean> loadingStatusObservable;

    private final Observer<Boolean> loadingStatusObserver =
            (isLoading) -> getViewState().setLoadingVisibility(isLoading);

    public NewsPresenter(Observable<Boolean> loadingStatusObservable) {
        this.loadingStatusObservable = loadingStatusObservable;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadingStatusObservable.addObserver(loadingStatusObserver);
    }

    @Override
    public void onDestroy() {
        loadingStatusObservable.removeObserver(loadingStatusObserver);
        super.onDestroy();
    }

}
