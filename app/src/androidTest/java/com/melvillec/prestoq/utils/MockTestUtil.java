package com.melvillec.prestoq.utils;


import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.data.remote.model.ManagerSpecialApiResponse;

import java.util.ArrayList;
import java.util.List;

public class MockTestUtil {

    public static final int MAX_CANVAS_UNIT = 16;
    public static final String DISPLAY_NAME_1 = "Noodle Dish with Roasted Black Bean Sauce";
    public static final String IMAGE_URL_1 = "https://www.url.com/image1";
    public static final String ORIGINAL_PRICE_1 = "2.00";
    public static final String SALE_PRICE_1 = "1.00";
    public static final int WIDTH_1 = 16;
    public static final int HEIGHT_1 = 8;

    public static final String DISPLAY_NAME_2 = "Onion Flavored Rings";
    public static final String IMAGE_URL_2 = "https://www.url.com/image2";
    public static final String ORIGINAL_PRICE_2 = "2.00";
    public static final String SALE_PRICE_2 = "1.00";
    public static final int WIDTH_2 = 8;
    public static final int HEIGHT_2 = 8;

    public static final String DISPLAY_NAME_3 = "Kikkoman Less Sodium Soy Sauce";
    public static final String IMAGE_URL_3 = "https://www.url.com/image3";
    public static final String ORIGINAL_PRICE_3 = "2.00";
    public static final String SALE_PRICE_3 = "1.00";
    public static final int WIDTH_3 = 8;
    public static final int HEIGHT_3 = 8;

    public static ManagerSpecialEntity mockManagerSpecialEntity(String displayName,
                                                                String imageUrl,
                                                                String originalPrice,
                                                                String price,
                                                                int height,
                                                                int width) {
        ManagerSpecialEntity managerSpecialEntity = new ManagerSpecialEntity(displayName, imageUrl, originalPrice, price, height, width);
        managerSpecialEntity.setCanvasUnit(MAX_CANVAS_UNIT);
        return managerSpecialEntity;
    }

    public static List<ManagerSpecialEntity> mockManagerSpecialEntityList() {
        List<ManagerSpecialEntity> managerSpecialEntities = new ArrayList<>();

        managerSpecialEntities.add(mockManagerSpecialEntity(DISPLAY_NAME_1, IMAGE_URL_1, ORIGINAL_PRICE_1, SALE_PRICE_1, WIDTH_1, HEIGHT_1));
        managerSpecialEntities.add(mockManagerSpecialEntity(DISPLAY_NAME_2, IMAGE_URL_2, ORIGINAL_PRICE_2, SALE_PRICE_2, WIDTH_2, HEIGHT_2));

        return managerSpecialEntities;
    }

    public static ManagerSpecialApiResponse mockManagerSpecialApiResponse() {
        ManagerSpecialApiResponse managerSpecialApiResponse = new ManagerSpecialApiResponse();
        managerSpecialApiResponse.setManagerSpecials(mockManagerSpecialEntityList());
        return managerSpecialApiResponse;
    }

}