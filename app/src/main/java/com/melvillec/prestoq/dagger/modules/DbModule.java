package com.melvillec.prestoq.dagger.modules;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.melvillec.prestoq.data.local.AppDatabase;
import com.melvillec.prestoq.data.local.dao.ManagerSpecialDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "PrestoQ.db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    ManagerSpecialDao provideManagerSpecialDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.managerSpecialDao();
    }
}
