package com.wsyzj.android.offer.activity;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wsyzj.android.offer.R;

import java.io.IOException;

/**
 * @author 焦洋
 * @date 2018/1/12 15:41
 * @Description: $desc$
 */
public class TurntableActivity extends Activity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turntable);

        try {
            mMediaPlayer = new MediaPlayer();
            AssetManager assets = getAssets();
            AssetFileDescriptor file = getResources().openRawResourceFd(R.raw.red_packet_rain);
            mMediaPlayer.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test(View view) {
//        if (mMediaPlayer != null) {
//            mMediaPlayer.start();
//        }
    }
}
