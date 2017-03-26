package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author: wsyzj
 * @date: 2017-03-26 13:48
 * @comment: 事件传递View
 */
public class TouchEventView extends View {

    public TouchEventView(Context context) {
        super(context);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("View", " -- dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("View", " -- onTouchEvent");
        return super.onTouchEvent(event);
    }
}
