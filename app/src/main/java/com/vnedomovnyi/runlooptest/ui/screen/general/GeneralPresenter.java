package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.model.DataModel;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import org.threeten.bp.LocalDateTime;

@InjectViewState
public class GeneralPresenter extends MvpPresenter<GeneralView> {

    private final DataModel<LocalDateTime> timeDataModel;

    private final DataModel<Article> articleDataModel;

    private final Observer<LocalDateTime> currentTimeObserver = (time) ->
            getViewState().setTimeText(time.toString());

    private final Observer<Article> articleObserver = (article) ->
            getViewState().setArticleText(article.getTitle());

    public GeneralPresenter(DataModel<LocalDateTime> timeDataModel,
                            DataModel<Article> articleDataModel) {
        this.timeDataModel = timeDataModel;
        this.articleDataModel = articleDataModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        timeDataModel.getDataObservable().addObserver(currentTimeObserver);
        articleDataModel.getDataObservable().addObserver(articleObserver);
    }

    @Override
    public void onDestroy() {
        timeDataModel.getDataObservable().removeObserver(currentTimeObserver);
        articleDataModel.getDataObservable().removeObserver(articleObserver);

        super.onDestroy();
    }

}
