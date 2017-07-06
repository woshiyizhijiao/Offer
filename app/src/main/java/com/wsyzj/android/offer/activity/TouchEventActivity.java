package com.wsyzj.android.offer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.wsyzj.android.offer.R;

/**
 * @author: wsyzj
 * @date: 2017-03-26 13:40
 * @comment: android事件传递机制
 */
public class TouchEventActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("Activity", " -- dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Activity", " -- onTouchEvent");
        return super.onTouchEvent(event);
    }
}
