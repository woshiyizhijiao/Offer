package com.wsyzj.android.offer.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wsyzj.android.offer.R;

/**
 * @author: wsyzj
 * @date: 2017-05-09 13:14
 * @comment:
 */
public class TestActivity extends AppCompatActivity {

    private MediaPlayer mClickRpPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

}
