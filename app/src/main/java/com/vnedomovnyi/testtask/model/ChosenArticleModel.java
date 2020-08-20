package com.vnedomovnyi.testtask.model;

import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.util.observer.Observable;
import com.vnedomovnyi.testtask.util.observer.Subject;

public class ChosenArticleModel {

    private final Subject<Article> subject = new Subject<>();

    public void chooseArticle(Article article) {
        subject.onUpdate(article);
    }

    public Observable<Article> getChosenArticleObservable() {
        return subject;
    }

}
