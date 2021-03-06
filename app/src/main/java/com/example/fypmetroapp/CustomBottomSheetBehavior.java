package com.example.fypmetroapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class CustomBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V>
{


    private boolean enableHidden = true;

    public CustomBottomSheetBehavior() {
    }

    public CustomBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEnableCollapse(boolean enableCollapse) {
        this.enableHidden = enableCollapse;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (enableHidden==true) {
            return false;
        }

        return super.onInterceptTouchEvent(parent, child, event);

    }
}