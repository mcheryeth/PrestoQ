package com.melvillec.prestoq.db;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.utils.MockTestUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.melvillec.prestoq.utils.MockTestUtil.*;

@RunWith(AndroidJUnit4.class)
public class ManagerSpecialDaoTest extends BaseDaoTest {

    @Test
    public void insertAndReadManagerSpecialTest() {
        List<ManagerSpecialEntity> managerSpecialEntities = new ArrayList<>();
        managerSpecialEntities.add(MockTestUtil.mockManagerSpecialEntity(DISPLAY_NAME_1, IMAGE_URL_1, ORIGINAL_PRICE_1, SALE_PRICE_1, WIDTH_1, HEIGHT_1));
        managerSpecialEntities.add(MockTestUtil.mockManagerSpecialEntity(DISPLAY_NAME_2, IMAGE_URL_2, ORIGINAL_PRICE_2, SALE_PRICE_2, WIDTH_2, HEIGHT_2));
        managerSpecialEntities.add(MockTestUtil.mockManagerSpecialEntity(DISPLAY_NAME_3, IMAGE_URL_3, ORIGINAL_PRICE_3, SALE_PRICE_3, WIDTH_3, HEIGHT_3));

        db.managerSpecialDao().insertManagerSpecials(managerSpecialEntities);
        List<ManagerSpecialEntity> storedManagerEntities = db.managerSpecialDao().getManagerSpecials();
        Assert.assertEquals(DISPLAY_NAME_1, storedManagerEntities.get(0).getDisplayName());
    }
}
