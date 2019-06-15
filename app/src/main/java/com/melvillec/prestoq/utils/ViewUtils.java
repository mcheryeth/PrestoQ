package com.melvillec.prestoq.utils;

import android.content.Context;
import android.view.ViewGroup;

public class ViewUtils {

    public static int getScreenWidthInDp(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightInDp(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getAdjustedItemHeight(int canvasUnits, int itemHeight, int displayWidth, ViewGroup.MarginLayoutParams layoutParams) {
        return (displayWidth * itemHeight / canvasUnits) - layoutParams.topMargin - layoutParams.bottomMargin;
    }

    public static int getAdjustedItemWidth(int canvasUnits, int itemWidth, int displayWidth, ViewGroup.MarginLayoutParams layoutParams) {
        if (itemWidth > canvasUnits) {
            return -1;
        }
        return (displayWidth * itemWidth / canvasUnits) - layoutParams.leftMargin - layoutParams.rightMargin;
    }

}
