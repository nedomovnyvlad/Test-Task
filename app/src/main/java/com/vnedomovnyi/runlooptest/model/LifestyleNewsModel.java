package com.vnedomovnyi.runlooptest.model;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.network.ArticleResponse;
import com.vnedomovnyi.runlooptest.network.NewsResponse;
import com.vnedomovnyi.runlooptest.network.NewsService;
import com.vnedomovnyi.runlooptest.util.observer.Observable;
import com.vnedomovnyi.runlooptest.util.observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

import lombok.Value;

public class LifestyleNewsModel implements UpdatableModel {

    private final NewsService newsService;

    private final Executor mainExecutor;

    private final Subject<LoadedData<List<Article>>> subject = new Subject<>();

    public LifestyleNewsModel(NewsService newsService, Executor mainExecutor) {
        this.newsService = newsService;
        this.mainExecutor = mainExecutor;
    }

    @WorkerThread
    @Override
    public void update() {
        NewsResponse response;

        try {
            response = newsService.getLifestyleNews().execute().body();
            Objects.requireNonNull(response);
        } catch (Throwable e) {
            mainExecutor.execute(() -> subject.onUpdate(new LoadedData<>(null, e)));
            return;
        }

        List<Article> articles = new ArrayList<>();

        for (ArticleResponse articleResponse : response.getArticleResponses()) {
            articles.add(new Article(articleResponse.getTitle(), articleResponse.getDescription()));
        }

        mainExecutor.execute(() -> subject.onUpdate(new LoadedData<>(articles, null)));
    }

    public Observable<LoadedData<List<Article>>> getDataObservable() {
        return subject;
    }

    @Value
    public static class LoadedData<T> {

        @Nullable
        T data;

        @Nullable
        Throwable error;

        public boolean hasData() {
            return data != null && error == null;
        }

    }

}