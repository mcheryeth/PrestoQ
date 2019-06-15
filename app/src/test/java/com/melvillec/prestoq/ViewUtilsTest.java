package com.melvillec.prestoq;

import android.view.ViewGroup;

import com.melvillec.prestoq.utils.ViewUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewUtilsTest {

    private static final int VIEW_WIDTH = 600;
    private static final int VIEW_HEIGHT = 600;
    private static final int MAX_CANVAS_UNITS = 16;
    private static final int DISPLAY_WIDTH = 2048;

    @Test
    public void testGetAdjustedWidth() throws Exception {
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(VIEW_WIDTH, VIEW_HEIGHT);

        //Equals width
        assertEquals(2048, ViewUtils.getAdjustedItemWidth(MAX_CANVAS_UNITS, 16, DISPLAY_WIDTH, layoutParams));

        //margins
        layoutParams.rightMargin = 8;
        layoutParams.leftMargin = 8;
        assertEquals(2032, ViewUtils.getAdjustedItemWidth(MAX_CANVAS_UNITS, 16, DISPLAY_WIDTH, layoutParams));

    }

    @Test
    public void testGetAdjustedHeight() {
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(VIEW_WIDTH, VIEW_HEIGHT);

        //Equals height
        assertEquals(2560, ViewUtils.getAdjustedItemHeight(MAX_CANVAS_UNITS, 20, DISPLAY_WIDTH, layoutParams));

        //margins
        layoutParams.bottomMargin = 8;
        layoutParams.topMargin = 8;
        assertEquals(2544, ViewUtils.getAdjustedItemHeight(MAX_CANVAS_UNITS, 20, DISPLAY_WIDTH, layoutParams));

        //Height above max canvas units
        layoutParams = new ViewGroup.MarginLayoutParams(VIEW_WIDTH, VIEW_HEIGHT);
        int expectedHeight = 2048 * 20 / 16;
        assertEquals(expectedHeight, ViewUtils.getAdjustedItemHeight(MAX_CANVAS_UNITS, 20, DISPLAY_WIDTH, layoutParams));
    }

    @Test
    public void widthExceedsMaxCanvasUnits() {
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(VIEW_WIDTH, VIEW_HEIGHT);
        assertEquals(-1, ViewUtils.getAdjustedItemWidth(MAX_CANVAS_UNITS, 17, DISPLAY_WIDTH, layoutParams));
    }
}
