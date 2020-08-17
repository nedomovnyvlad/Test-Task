package com.vnedomovnyi.runlooptest.model;

import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.util.observer.Observable;
import com.vnedomovnyi.runlooptest.util.observer.Subject;

public class ChosenArticleModel {

    private final Subject<Article> subject = new Subject<>();

    public void chooseArticle(Article article) {
        subject.onUpdate(article);
    }

    public Observable<Article> getChosenArticleObservable() {
        return subject;
    }

}
