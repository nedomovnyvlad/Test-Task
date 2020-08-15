package com.vnedomovnyi.runlooptest.di.module;

import com.vnedomovnyi.runlooptest.model.CurrentTimeModel;
import com.vnedomovnyi.runlooptest.model.LifestyleNewsModel;
import com.vnedomovnyi.runlooptest.model.UpdatableModel;
import com.vnedomovnyi.runlooptest.model.UpdateDataModel;
import com.vnedomovnyi.runlooptest.network.NewsService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.vnedomovnyi.runlooptest.di.module.ExecutorModule.MAIN;
import static com.vnedomovnyi.runlooptest.di.module.ExecutorModule.WORKER;

@Module
public class ModelModule {

    @Provides
    CurrentTimeModel provideCurrentTimeModel(@Named(MAIN) Executor mainExecutor) {
        return new CurrentTimeModel(mainExecutor);
    }

    @Provides
    @Singleton
    LifestyleNewsModel provideLifestyleNewsModel(NewsService newsService, @Named(MAIN) Executor executor) {
        return new LifestyleNewsModel(newsService, executor);
    }

    @Provides
    @Singleton
    UpdateDataModel provideUpdateDataModel(LifestyleNewsModel lifestyleNewsModel,
                                           @Named(WORKER) ExecutorService workerExecutorService) {
        Set<UpdatableModel> updatableModels = new HashSet<>();
        updatableModels.add(lifestyleNewsModel);

        return new UpdateDataModel(updatableModels, workerExecutorService);
    }

}
