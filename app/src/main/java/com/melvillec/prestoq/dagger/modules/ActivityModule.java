package com.melvillec.prestoq.dagger.modules;

import com.melvillec.prestoq.ui.activities.ManagerSpecialActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract ManagerSpecialActivity contributeManagerSpecialActivity();
}