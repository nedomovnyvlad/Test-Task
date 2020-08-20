package com.vnedomovnyi.testtask.di;

import android.app.Application;

import com.vnedomovnyi.testtask.TestTaskApp;
import com.vnedomovnyi.testtask.di.module.ApplicationModule;
import com.vnedomovnyi.testtask.di.module.ExecutorModule;
import com.vnedomovnyi.testtask.di.module.ModelModule;
import com.vnedomovnyi.testtask.di.module.OkHttpModule;
import com.vnedomovnyi.testtask.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ExecutorModule.class,
        ModelModule.class,
        OkHttpModule.class,
        RetrofitModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(TestTaskApp application);

}
