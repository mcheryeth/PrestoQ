package com.melvillec.prestoq.ui.viewholders;

import android.content.Context;
import android.graphics.Paint;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.melvillec.prestoq.R;
import com.melvillec.prestoq.data.local.entity.ManagerSpecialEntity;
import com.melvillec.prestoq.databinding.ManagerSpecialListViewModelBinding;
import com.melvillec.prestoq.utils.ViewUtils;
import com.squareup.picasso.Picasso;

public class ManagerSpecialItemViewHolder extends RecyclerView.ViewHolder {

    private ManagerSpecialListViewModelBinding dataBinding;
    private Context context;

    public ManagerSpecialItemViewHolder(ManagerSpecialListViewModelBinding binding, Context activityContext) {
        super(binding.getRoot());
        this.dataBinding = binding;
        this.context = activityContext;
    }

    public void configureView(ManagerSpecialEntity managerSpecial) {
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.height = ViewUtils.getAdjustedItemHeight(managerSpecial.getCanvasUnit(),
                managerSpecial.getHeight(), ViewUtils.getScreenWidthInDp(context), (ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams.width = ViewUtils.getAdjustedItemWidth(managerSpecial.getCanvasUnit(),
                managerSpecial.getWidth(), ViewUtils.getScreenWidthInDp(context), (ViewGroup.MarginLayoutParams) layoutParams);
        itemView.setLayoutParams(layoutParams);

        dataBinding.originalPriceTv.setText(String.format("$%s", managerSpecial.getOriginalPrice()));
        dataBinding.originalPriceTv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        dataBinding.salePriceTv.setText(String.format("$%s", managerSpecial.getPrice()));

        dataBinding.productNameTv.setText(managerSpecial.getDisplayName());

        Picasso.get().load(managerSpecial.getImageUrl())
                .placeholder(R.drawable.ic_placeholder_gray_24dp)
                .into(dataBinding.productIv);
    }
}
