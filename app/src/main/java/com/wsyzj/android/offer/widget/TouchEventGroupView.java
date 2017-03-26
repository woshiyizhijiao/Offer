package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * @author: wsyzj
 * @date: 2017-03-26 13:44
 * @comment: 事件传递的Group
 */
public class TouchEventGroupView extends FrameLayout {

    public TouchEventGroupView(Context context) {
        super(context);
    }

    public TouchEventGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("GroupView", " -- dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("GroupView", " -- onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("GroupView", " -- onTouchEvent");
        return super.onTouchEvent(event);
    }
}
