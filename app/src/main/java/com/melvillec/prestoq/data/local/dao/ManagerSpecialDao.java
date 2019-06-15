package com.melvillec.prestoq.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;

import java.util.List;

@Dao
public interface ManagerSpecialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertManagerSpecials(List<ManagerSpecialEntity> managerSpecials);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertManagerSpecial(ManagerSpecialEntity managerSpecial);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateManagerSpecial(ManagerSpecialEntity managerSpecial);

    @Query("DELETE FROM `ManagerSpecialEntity`")
    void nukeTable();

    @Query("SELECT * FROM `ManagerSpecialEntity` where id = :id")
    ManagerSpecialEntity getManagerSpecialById(Long id);

    @Query("SELECT * FROM `ManagerSpecialEntity`")
    List<ManagerSpecialEntity> getManagerSpecials();

}
