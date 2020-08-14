package com.vnedomovnyi.runlooptest.di.module;

import com.vnedomovnyi.runlooptest.util.executor.MainThreadExecutor;

import java.util.concurrent.Executor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExecutorModule {

    public static final String MAIN = "MAIN";

    @Provides
    @Singleton
    @Named(MAIN)
    Executor provideMainExecutor() {
        return new MainThreadExecutor();
    }

}
