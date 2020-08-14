package com.vnedomovnyi.runlooptest.di;

import android.app.Application;

import com.vnedomovnyi.runlooptest.RunloopTestApp;
import com.vnedomovnyi.runlooptest.di.module.ApplicationModule;
import com.vnedomovnyi.runlooptest.di.module.ExecutorModule;
import com.vnedomovnyi.runlooptest.di.module.ModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ExecutorModule.class,
        ModelModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(RunloopTestApp application);

}
