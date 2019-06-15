package com.melvillec.prestoq.data.local.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;

import java.lang.reflect.Type;
import java.util.List;

public class ManagerSpecialListTypeConverter {

    @TypeConverter
    public List<ManagerSpecialEntity> fromString(String value) {
        Type listType = new TypeToken<List<ManagerSpecialEntity>>() {}.getType();
        List<ManagerSpecialEntity> managerSpecialEntities = new Gson().fromJson(value, listType);
        return managerSpecialEntities;
    }

    @TypeConverter
    public String fromList(List<ManagerSpecialEntity> managerSpecialEntities) {
        return new Gson().toJson(managerSpecialEntities);
    }
}
