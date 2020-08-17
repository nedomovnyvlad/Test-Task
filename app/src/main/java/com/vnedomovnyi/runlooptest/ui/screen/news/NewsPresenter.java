package com.vnedomovnyi.runlooptest.ui.screen.news;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.model.DataModel;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsView> {

    private final DataModel<Boolean> loadingStatusModel;

    private final Observer<Boolean> loadingStatusObserver =
            (isLoading) -> getViewState().setLoadingVisibility(isLoading);

    public NewsPresenter(DataModel<Boolean> loadingStatusModel) {
        this.loadingStatusModel = loadingStatusModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadingStatusModel.getDataObservable().addObserver(loadingStatusObserver);
    }

    @Override
    public void onDestroy() {
        loadingStatusModel.getDataObservable().removeObserver(loadingStatusObserver);
        super.onDestroy();
    }

}
