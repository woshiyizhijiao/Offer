package com.wsyzj.android.offer.activity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wsyzj.android.offer.R;

import java.io.IOException;

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

        try {
            mClickRpPlayer = new MediaPlayer();
            AssetFileDescriptor file = getResources().openRawResourceFd(R.raw.red_packet_rain);
            mClickRpPlayer.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
            mClickRpPlayer.prepare();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        if (mClickRpPlayer.isPlaying()) {
            mClickRpPlayer.seekTo(0);
        } else {
            mClickRpPlayer.start();
        }
    }

}
