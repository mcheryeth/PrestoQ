package com.melvillec.prestoq;

import android.app.Activity;
import android.app.Application;

import com.evernote.android.state.StateSaver;
import com.melvillec.prestoq.dagger.components.DaggerAppComponent;
import com.melvillec.prestoq.dagger.modules.DbModule;
import com.melvillec.prestoq.dagger.modules.NetModule;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class PrestoQApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        StateSaver.setEnabledForAllActivitiesAndSupportFragments(this, true);

        DaggerAppComponent.builder()
                .application(this)
                .netModule(new NetModule())
                .dbModule(new DbModule())
                .build()
             .inject(this);

    }
}
