package com.melvillec.prestoq.data.remote.api;

import com.melvillec.prestoq.data.remote.model.ManagerSpecialApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ManagerSpecialApiService {

    @GET("android-coding-challenge")
    Observable<ManagerSpecialApiResponse> getManagerSpecials();
}
