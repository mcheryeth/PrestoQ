package com.melvillec.prestoq.data.remote.model;

import androidx.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;

import java.util.List;

public class ManagerSpecialApiResponse {

    @SerializedName("canvasUnit")
    private int canvasUnit;

    @SerializedName("managerSpecials")
    private List<ManagerSpecialEntity> managerSpecials;

    public int getCanvasUnit() {
        return canvasUnit;
    }

    public List<ManagerSpecialEntity> getManagerSpecials() {
        return managerSpecials;
    }

    @VisibleForTesting
    public void setCanvasUnit(int canvasUnit) {
        this.canvasUnit = canvasUnit;
    }

    @VisibleForTesting
    public void setManagerSpecials(List<ManagerSpecialEntity> managerSpecials) {
        this.managerSpecials = managerSpecials;
    }
}
