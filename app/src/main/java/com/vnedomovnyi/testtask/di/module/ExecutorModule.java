package com.vnedomovnyi.testtask.di.module;

import com.vnedomovnyi.testtask.util.executor.MainThreadExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExecutorModule {

    public static final String MAIN = "MAIN";
    public static final String WORKER = "WORKER";

    @Provides
    @Singleton
    @Named(MAIN)
    Executor provideMainExecutor() {
        return new MainThreadExecutor();
    }

    @Provides
    @Singleton
    @Named(WORKER)
    ExecutorService provideWorkerExecutor() {
        return Executors.newCachedThreadPool();
    }

}
