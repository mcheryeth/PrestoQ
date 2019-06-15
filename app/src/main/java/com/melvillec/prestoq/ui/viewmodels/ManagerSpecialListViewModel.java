package com.melvillec.prestoq.ui.viewmodels;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;

import com.melvillec.prestoq.data.Resource;
import com.melvillec.prestoq.data.local.dao.ManagerSpecialDao;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.data.remote.api.ManagerSpecialApiService;
import com.melvillec.prestoq.repository.ManagerSpecialRepository;

import java.util.List;

import javax.inject.Inject;

public class ManagerSpecialListViewModel extends BaseViewModel {

    private ManagerSpecialRepository managerSpecialRepository;
    private MutableLiveData<Resource<List<ManagerSpecialEntity>>> managerSpecialsLiveData = new MutableLiveData<>();

    @Inject
    public ManagerSpecialListViewModel(ManagerSpecialDao managerSpecialDao, ManagerSpecialApiService managerSpecialApiService) {
        managerSpecialRepository = new ManagerSpecialRepository(managerSpecialDao, managerSpecialApiService);
    }

    @SuppressLint("CheckResult")
    public void getManagerSpecials() {
        managerSpecialRepository.getManagerSpecials()
                .doOnSubscribe(this::addToDisposable)
                .subscribe(resource -> getManagerSpecialsLiveData().postValue(resource));
    }

    public MutableLiveData<Resource<List<ManagerSpecialEntity>>> getManagerSpecialsLiveData() {
        return managerSpecialsLiveData;
    }
}
