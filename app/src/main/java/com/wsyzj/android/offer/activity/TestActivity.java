package com.wsyzj.android.offer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.tools.LogUtils;

/**
 * @author: wsyzj
 * @date: 2017-05-09 13:14
 * @comment: //TODO
 */
public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        LogUtils.e("onCreate");
    }

    public void btn(View v){
        startActivity(new Intent(this,TestActivity.class));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e("onDestroy");
    }
}
