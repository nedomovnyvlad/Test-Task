package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.util.observer.Observable;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import org.threeten.bp.LocalDateTime;

@InjectViewState
public class GeneralPresenter extends MvpPresenter<GeneralView> {

    private final Observable<LocalDateTime> timeObservable;

    private final Observable<Article> articleObservable;

    private final Observer<LocalDateTime> currentTimeObserver = (time) ->
            getViewState().setTimeText(time.toString());

    private final Observer<Article> articleObserver = (article) ->
            getViewState().setArticleText(article.getTitle());

    public GeneralPresenter(Observable<LocalDateTime> timeObservable,
                            Observable<Article> articleObservable) {
        this.timeObservable = timeObservable;
        this.articleObservable = articleObservable;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        timeObservable.addObserver(currentTimeObserver);
        articleObservable.addObserver(articleObserver);
    }

    @Override
    public void onDestroy() {
        timeObservable.removeObserver(currentTimeObserver);
        articleObservable.removeObserver(articleObserver);

        super.onDestroy();
    }

}
