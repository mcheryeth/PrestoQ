package com.melvillec.prestoq.dagger.components;

import android.app.Application;

import com.melvillec.prestoq.PrestoQApp;
import com.melvillec.prestoq.dagger.modules.ActivityModule;
import com.melvillec.prestoq.dagger.modules.DbModule;
import com.melvillec.prestoq.dagger.modules.NetModule;
import com.melvillec.prestoq.dagger.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {DbModule.class, NetModule.class, ViewModelModule.class, ActivityModule.class, AndroidInjectionModule.class})
public interface AppComponent {

    /* Called from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     * */
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder netModule(NetModule apiModule);

        @BindsInstance
        Builder dbModule(DbModule dbModule);

        AppComponent build();
    }

    // This is our custom Application class
    void inject(PrestoQApp application);

}
