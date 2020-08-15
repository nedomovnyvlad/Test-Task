package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.network.NewsResponse;
import com.vnedomovnyi.runlooptest.network.NewsService;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

@InjectViewState
public class LifestyleNewsPresenter extends MvpPresenter<LifestyleNewsView> {

    private NewsService newsService;

    public LifestyleNewsPresenter(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        newsService.getLifestyleNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(@NonNull Call<NewsResponse> call, @NonNull Response<NewsResponse> response) {
                Timber.d(Objects.requireNonNull(response.body()).toString());
            }

            @Override
            public void onFailure(@NonNull Call<NewsResponse> call, @NonNull Throwable t) {
                Timber.e(t, "Failed to get news.");
            }
        });
    }

}
