package com.melvillec.prestoq.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.databinding.ManagerSpecialListViewModelBinding;
import com.melvillec.prestoq.ui.viewholders.ManagerSpecialItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ManagerSpecialRecyclerAdapter extends RecyclerView.Adapter<ManagerSpecialItemViewHolder> {

    private List<ManagerSpecialEntity> managerSpecials;
    private Context context;
    public ManagerSpecialRecyclerAdapter(Context context) {
        this.managerSpecials = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ManagerSpecialItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ManagerSpecialListViewModelBinding itemBinding = ManagerSpecialListViewModelBinding.inflate(layoutInflater, parent, false);
        return new ManagerSpecialItemViewHolder(itemBinding, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerSpecialItemViewHolder holder, int position) {
        holder.configureView(getItem(position));
    }

    @Override
    public int getItemCount() {
        return managerSpecials.size();
    }

    public ManagerSpecialEntity getItem(int position) {
        return managerSpecials.get(position);
    }

    public void setItems(List<ManagerSpecialEntity> managerSpecials) {
        //int startPosition = this.managerSpecials.size();
        this.managerSpecials = new ArrayList<>(managerSpecials);
        notifyItemRangeChanged(0, managerSpecials.size());
    }

}
