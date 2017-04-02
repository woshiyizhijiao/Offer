package com.wsyzj.android.offer.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.widget.LoginVideoView;

/**
 * @author: wsyzj
 * @date: 2017-04-02 17:35
 * @comment: 闪屏界面播放视频效果实现
 */
public class LoginVideoAct extends AppCompatActivity {

    private LoginVideoView video_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login_video);

        video_view = (LoginVideoView) findViewById(R.id.video_view);
        video_view.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.login_video));
        video_view.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (video_view != null) {
            video_view.suspend();   // 释放资源
        }
    }
}
