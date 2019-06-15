package com.melvillec.prestoq.ui.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.melvillec.prestoq.R;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.databinding.ManagerSpecialActivityBinding;
import com.melvillec.prestoq.factory.ViewModelFactory;
import com.melvillec.prestoq.ui.adapters.ManagerSpecialRecyclerAdapter;
import com.melvillec.prestoq.ui.viewmodels.ManagerSpecialListViewModel;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ManagerSpecialActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ManagerSpecialActivityBinding dataBinding;
    private ManagerSpecialListViewModel viewModel;
    private ManagerSpecialRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        initializeUI();
        initializeViewModel();
    }

    private void initializeUI() {
        Objects.requireNonNull(getSupportActionBar()).hide();

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new ManagerSpecialRecyclerAdapter(this);
        dataBinding.managerSpecialsRv.setAdapter(adapter);
        dataBinding.managerSpecialsRv.setHasFixedSize(true);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        layoutManager.setJustifyContent(JustifyContent.CENTER);
        dataBinding.managerSpecialsRv.setLayoutManager(layoutManager);
    }

    private void initializeViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ManagerSpecialListViewModel.class);
        viewModel.getManagerSpecialsLiveData().observe(this, resource -> {
            if (resource.data != null && !resource.data.isEmpty()) {
                updateManagerSpecials(resource.data);
            } else {
                handleErrorResponse();
            }
        });

        //Fetch manager specials
        fetchManagerSpecials();
    }

    private void fetchManagerSpecials() {
        displayProgressBar();
        viewModel.getManagerSpecials();
    }

    private void updateManagerSpecials(List<ManagerSpecialEntity> managerSpecials) {
        hideProgressBar();
        dataBinding.emptyViewTv.setVisibility(View.GONE);
        dataBinding.managerSpecialsRv.setVisibility(View.VISIBLE);
        adapter.setItems(managerSpecials);
    }

    private void handleErrorResponse() {
        hideProgressBar();
        dataBinding.managerSpecialsRv.setVisibility(View.GONE);
        dataBinding.emptyViewTv.setVisibility(View.VISIBLE);
    }

    private void displayProgressBar() {
        dataBinding.managerSpecialsRv.setVisibility(View.GONE);
        dataBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        dataBinding.managerSpecialsRv.setVisibility(View.VISIBLE);
        dataBinding.progressBar.setVisibility(View.GONE);
    }
}
