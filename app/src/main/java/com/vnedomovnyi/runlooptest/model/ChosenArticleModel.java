package com.vnedomovnyi.runlooptest.model;

import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.util.observer.Observable;
import com.vnedomovnyi.runlooptest.util.observer.Subject;

public class ChosenArticleModel implements DataModel<Article> {

    private final Subject<Article> subject = new Subject<>();

    public void chooseArticle(Article article) {
        subject.onUpdate(article);
    }

    @Override
    public Observable<Article> getDataObservable() {
        return subject;
    }

}
