package com.melvillec.prestoq.repository;

import androidx.annotation.NonNull;

import com.melvillec.prestoq.data.NetworkBoundResource;
import com.melvillec.prestoq.data.Resource;
import com.melvillec.prestoq.data.local.dao.ManagerSpecialDao;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.data.remote.api.ManagerSpecialApiService;
import com.melvillec.prestoq.data.remote.model.ManagerSpecialApiResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Singleton
public class ManagerSpecialRepository {

    private ManagerSpecialDao managerSpecialDao;
    private ManagerSpecialApiService managerSpecialApiService;

    public ManagerSpecialRepository(ManagerSpecialDao managerSpecialDao,
                                    ManagerSpecialApiService managerSpecialApiService) {
        this.managerSpecialDao = managerSpecialDao;
        this.managerSpecialApiService = managerSpecialApiService;
    }

    public Observable<Resource<List<ManagerSpecialEntity>>> getManagerSpecials() {
        return new NetworkBoundResource<List<ManagerSpecialEntity>, ManagerSpecialApiResponse>() {

            @Override
            protected void saveCallResult(@NonNull ManagerSpecialApiResponse item) {
                List<ManagerSpecialEntity> managerSpecialEntities = new ArrayList<>();
                for (ManagerSpecialEntity managerSpecialEntity : item.getManagerSpecials()) {
                    managerSpecialEntity.setCanvasUnit(item.getCanvasUnit());
                    managerSpecialEntities.add(managerSpecialEntity);
                }
                //clearing the DB since the JSON data doesn't have any IDs to map to the db schema
                managerSpecialDao.nukeTable();
                managerSpecialDao.insertManagerSpecials(managerSpecialEntities);
            }

            @Override
            protected boolean shouldFetch() {
                return true;
            }

            @Override
            protected void onFetchFailed() {
                super.onFetchFailed();
            }

            @NonNull
            @Override
            protected Flowable<List<ManagerSpecialEntity>> loadFromDb() {
                List<ManagerSpecialEntity> managerSpecialEntities = managerSpecialDao.getManagerSpecials();
                if (managerSpecialEntities == null || managerSpecialEntities.isEmpty()) {
                    return Flowable.empty();
                }
                return Flowable.just(managerSpecialEntities);
            }

            @NonNull
            @Override
            protected Observable<Resource<ManagerSpecialApiResponse>> createCall() {
                return managerSpecialApiService.getManagerSpecials()
                        .flatMap(managerSpecialApiResponse -> Observable.just(managerSpecialApiResponse == null
                                ? Resource.error("", new ManagerSpecialApiResponse())
                                : Resource.success(managerSpecialApiResponse)));
            }
        }.getAsObservable();
    }
}
