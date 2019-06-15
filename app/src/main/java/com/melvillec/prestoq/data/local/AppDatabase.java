package com.melvillec.prestoq.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.melvillec.prestoq.data.local.converter.ManagerSpecialListTypeConverter;
import com.melvillec.prestoq.data.local.converter.StringListConverter;
import com.melvillec.prestoq.data.local.dao.ManagerSpecialDao;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;

@Database(entities = {ManagerSpecialEntity.class}, version = 1,  exportSchema = false)
@TypeConverters({ManagerSpecialListTypeConverter.class, StringListConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract ManagerSpecialDao managerSpecialDao();

    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "PrestoQ.db")
                .allowMainThreadQueries().build();
    }
}
