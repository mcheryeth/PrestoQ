package com.melvillec.prestoq.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.VisibleForTesting;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(primaryKeys = ("id"))
public class ManagerSpecialEntity implements Parcelable {

    @SerializedName("id")
    private Long id;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("original_price")
    private String originalPrice;

    @SerializedName("price")
    private String price;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @Expose
    private int canvasUnit;

    @VisibleForTesting
    public ManagerSpecialEntity(String displayName, String imageUrl, String originalPrice, String price, int height, int width) {
        this.displayName = displayName;
        this.imageUrl = imageUrl;
        this.originalPrice = originalPrice;
        this.price = price;
        this.height = height;
        this.width = width;
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getPrice() {
        return price;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCanvasUnit() {
        return canvasUnit;
    }

    public void setCanvasUnit(int canvasUnit) {
        this.canvasUnit = canvasUnit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.displayName);
        dest.writeString(this.imageUrl);
        dest.writeString(this.originalPrice);
        dest.writeString(this.price);
        dest.writeInt(this.height);
        dest.writeInt(this.width);
    }

    public ManagerSpecialEntity() {
    }

    protected ManagerSpecialEntity(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.displayName = in.readString();
        this.imageUrl = in.readString();
        this.originalPrice = in.readString();
        this.price = in.readString();
        this.height = in.readInt();
        this.width = in.readInt();
    }

    public static final Creator<ManagerSpecialEntity> CREATOR = new Creator<ManagerSpecialEntity>() {
        @Override
        public ManagerSpecialEntity createFromParcel(Parcel source) {
            return new ManagerSpecialEntity(source);
        }

        @Override
        public ManagerSpecialEntity[] newArray(int size) {
            return new ManagerSpecialEntity[size];
        }
    };
}
