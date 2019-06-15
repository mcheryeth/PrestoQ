package com.melvillec.prestoq.dagger.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.melvillec.prestoq.factory.ViewModelFactory;
import com.melvillec.prestoq.ui.viewmodels.ManagerSpecialListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(ManagerSpecialListViewModel.class)
    protected abstract ViewModel managerSpecialListViewModel(ManagerSpecialListViewModel managerSpecialListViewModel);

}