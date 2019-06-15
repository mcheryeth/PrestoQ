package com.melvillec.prestoq;

import com.melvillec.prestoq.data.remote.api.ManagerSpecialApiService;
import com.melvillec.prestoq.data.remote.model.ManagerSpecialApiResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ManagerSpecialApiServiceTest extends ApiAbstract<ManagerSpecialApiService> {

    private ManagerSpecialApiService service;

    @Before
    public void initService() {
        this.service = createService(ManagerSpecialApiService.class);
    }

    @Test
    public void getManagerSpecialsTest() throws IOException {
        enqueueResponse("test_manager_specials.json");
        ManagerSpecialApiResponse managerSpecialApiResponse = service.getManagerSpecials().blockingFirst();
        Assert.assertEquals(16, managerSpecialApiResponse.getCanvasUnit());
        Assert.assertEquals(3, managerSpecialApiResponse.getManagerSpecials().size());
        Assert.assertEquals("Noodle Dish with Roasted Black Bean Sauce",
                managerSpecialApiResponse.getManagerSpecials().get(0).getDisplayName());
        Assert.assertEquals("https://raw.githubusercontent.com/prestoqinc/code-exercise-android/master/images/L.png",
                managerSpecialApiResponse.getManagerSpecials().get(0).getImageUrl());
        Assert.assertEquals("2.00",
                managerSpecialApiResponse.getManagerSpecials().get(0).getOriginalPrice());
        Assert.assertEquals("1.00",
                managerSpecialApiResponse.getManagerSpecials().get(0).getPrice());
        Assert.assertEquals(8,
                managerSpecialApiResponse.getManagerSpecials().get(0).getHeight());
        Assert.assertEquals(16,
                managerSpecialApiResponse.getManagerSpecials().get(0).getWidth());
    }
}
