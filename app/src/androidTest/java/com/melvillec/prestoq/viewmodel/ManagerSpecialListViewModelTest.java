package com.melvillec.prestoq.viewmodel;

import android.app.Application;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;

import com.melvillec.prestoq.data.Resource;
import com.melvillec.prestoq.data.local.dao.ManagerSpecialDao;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.data.remote.api.ManagerSpecialApiService;
import com.melvillec.prestoq.data.remote.model.ManagerSpecialApiResponse;
import com.melvillec.prestoq.ui.viewmodels.ManagerSpecialListViewModel;
import com.melvillec.prestoq.utils.MockTestUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ManagerSpecialListViewModelTest {

    private ManagerSpecialListViewModel managerSpecialListViewModel;

    @Mock
    ManagerSpecialDao managerSpecialDao;

    @Mock
    ManagerSpecialApiService managerSpecialApiService;

    @Mock
    Observer<Resource<List<ManagerSpecialEntity>>> observer;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void init() {
        Application app = (Application) ApplicationProvider.getApplicationContext().getApplicationContext();
        managerSpecialListViewModel = new ManagerSpecialListViewModel(managerSpecialDao, managerSpecialApiService);
    }

    @Test
    public void fetchManagerSpecials() {
        List<ManagerSpecialEntity> loadFromDB = MockTestUtil.mockManagerSpecialEntityList();
        when(managerSpecialDao.getManagerSpecials()).thenReturn(loadFromDB);

        ManagerSpecialApiResponse mockResponse = MockTestUtil.mockManagerSpecialApiResponse();
        when(managerSpecialApiService.getManagerSpecials())
                .thenReturn(Observable.just(mockResponse));

        managerSpecialListViewModel.getManagerSpecialsLiveData().observeForever(observer);
        managerSpecialListViewModel.getManagerSpecials();

        assert(managerSpecialListViewModel.getManagerSpecialsLiveData().getValue().isLoading());
        assert(managerSpecialListViewModel.getManagerSpecialsLiveData().getValue().data == MockTestUtil.mockManagerSpecialEntityList());
    }
}
