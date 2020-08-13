package com.vnedomovnyi.runlooptest.di;

import android.app.Application;

import com.vnedomovnyi.runlooptest.RunloopTestApp;
import com.vnedomovnyi.runlooptest.di.module.ApplicationModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(RunloopTestApp application);

}
