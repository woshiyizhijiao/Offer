package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wsyzj.android.offer.R;

/**
 * @author: wsyzj
 * @date: 2017-02-26 14:08
 * @comment: 沉浸式模式
 * api :18不支持 api :19支持状态栏全透明化 api :20支持改变状态栏颜色
 */
public class TranslucentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
    }
}
