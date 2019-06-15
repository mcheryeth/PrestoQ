package com.melvillec.prestoq.data.repository;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.melvillec.prestoq.data.Resource;
import com.melvillec.prestoq.data.local.dao.ManagerSpecialDao;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.data.remote.api.ManagerSpecialApiService;
import com.melvillec.prestoq.data.remote.model.ManagerSpecialApiResponse;
import com.melvillec.prestoq.repository.ManagerSpecialRepository;
import com.melvillec.prestoq.utils.MockTestUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ManagerSpecialRepositoryTest {

    @Mock
    ManagerSpecialDao managerSpecialDao;

    @Mock
    ManagerSpecialApiService managerSpecialApiService;

    private ManagerSpecialRepository repository;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void init() {
        repository = new ManagerSpecialRepository(managerSpecialDao, managerSpecialApiService);
    }


    @Test
    public void getManagerSpecials() {

        List<ManagerSpecialEntity> loadFromDB = MockTestUtil.mockManagerSpecialEntityList();
        when(managerSpecialDao.getManagerSpecials()).thenReturn(loadFromDB);

        ManagerSpecialApiResponse mockResponse = MockTestUtil.mockManagerSpecialApiResponse();
        when(managerSpecialApiService.getManagerSpecials())
                .thenReturn(Observable.just(mockResponse));

        Observable<Resource<List<ManagerSpecialEntity>>>
                data = repository.getManagerSpecials();
        verify(managerSpecialDao).getManagerSpecials();
        verify(managerSpecialApiService).getManagerSpecials();

        TestObserver testObserver = new TestObserver();
        data.subscribe(testObserver);
        testObserver.assertNoErrors();
    }

}
