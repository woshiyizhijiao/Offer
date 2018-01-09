package com.wsyzj.android.offer.activity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.widget.RedPacketRain;
import com.wsyzj.android.offer.widget.RedPacketRainView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 焦洋
 * @date 2018/1/9 14:02
 * @Description: 红包雨 撒红包效果
 */
public class RedPacketRainActivity extends Activity {

    private TextView tv_red_sum;
    private RedPacketRainView red_packet_rain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packet_rain);
        tv_red_sum = findViewById(R.id.tv_red_sum);
        red_packet_rain = findViewById(R.id.red_packet_rain);

        red_packet_rain.setRedPacketData(getRedPacketData());
    }

    private List<RedPacketRain> getRedPacketData() {
        List<RedPacketRain> redPacketRains = new ArrayList<>();
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        return redPacketRains;
    }

    /**
     * 开始
     *
     * @param view
     */
    public void start(View view) {
        red_packet_rain.start();
    }

    /**
     * 结束
     *
     * @param view
     */
    public void stop(View view) {
        red_packet_rain.stop();
    }
}
