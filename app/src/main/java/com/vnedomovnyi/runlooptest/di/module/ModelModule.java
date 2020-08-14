package com.vnedomovnyi.runlooptest.di.module;

import com.vnedomovnyi.runlooptest.model.CurrentTimeModel;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.vnedomovnyi.runlooptest.di.module.ExecutorModule.MAIN;

@Module
public class ModelModule {

    @Provides
    CurrentTimeModel provideCurrentTimeModel(@Named(MAIN) Executor mainExecutor) {
        return new CurrentTimeModel(mainExecutor);
    }

}
