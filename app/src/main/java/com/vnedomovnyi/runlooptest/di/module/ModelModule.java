package com.vnedomovnyi.runlooptest.di.module;

import com.vnedomovnyi.runlooptest.model.ChosenArticleModel;
import com.vnedomovnyi.runlooptest.model.CurrentTimeModel;
import com.vnedomovnyi.runlooptest.model.NewsModel;
import com.vnedomovnyi.runlooptest.model.UpdatableModel;
import com.vnedomovnyi.runlooptest.model.UpdateDataModel;
import com.vnedomovnyi.runlooptest.network.NewsService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

import static com.vnedomovnyi.runlooptest.di.module.ExecutorModule.MAIN;
import static com.vnedomovnyi.runlooptest.di.module.ExecutorModule.WORKER;

@Module
public class ModelModule {

    public static final String LIFESTYLE = "LIFESTYLE";
    public static final String WSJD = "WSJD";
    public static final String WORLD = "WORLD";

    @Provides
    @Singleton
    CurrentTimeModel provideCurrentTimeModel(@Named(MAIN) Executor mainExecutor) {
        return new CurrentTimeModel(mainExecutor);
    }

    @Provides
    @Singleton
    ChosenArticleModel provideChosenArticleModel() {
        return new ChosenArticleModel();
    }

    @Provides
    @Singleton
    @Named(LIFESTYLE)
    NewsModel provideLifestyleNewsModel(NewsService newsService, @Named(MAIN) Executor executor) {
        return new NewsModel(newsService.getLifestyleNews(), executor);
    }

    @Provides
    @Singleton
    @Named(WSJD)
    NewsModel provideWsjdNewsModel(NewsService newsService, @Named(MAIN) Executor executor) {
        return new NewsModel(newsService.getWsjdNews(), executor);
    }

    @Provides
    @Singleton
    @Named(WORLD)
    NewsModel provideWorldNewsModel(NewsService newsService, @Named(MAIN) Executor executor) {
        return new NewsModel(newsService.getWorldNews(), executor);
    }

    @Provides
    @ElementsIntoSet
    Set<UpdatableModel> provideNewsModelsAsUpdatableModels(@Named(LIFESTYLE) NewsModel lifestyleNewsModel,
                                                           @Named(WSJD) NewsModel wsjdNewsModel,
                                                           @Named(WORLD) NewsModel worldNewsModel) {
        return new HashSet<>(Arrays.asList(lifestyleNewsModel, wsjdNewsModel, worldNewsModel));
    }

    @Provides
    @Singleton
    UpdateDataModel provideUpdateDataModel(Set<UpdatableModel> updatableModels,
                                           @Named(WORKER) ExecutorService workerExecutorService,
                                           @Named(MAIN) Executor mainExecutor) {
        return new UpdateDataModel(updatableModels, workerExecutorService, mainExecutor);
    }

}
