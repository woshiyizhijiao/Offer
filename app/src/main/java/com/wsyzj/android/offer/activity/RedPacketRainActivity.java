package com.wsyzj.android.offer.activity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.RedPacketRain;
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
        redPacketRains.add(new RedPacketRain(this, 0.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.3, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.4, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.5, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.6, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.7, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.8, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 0.9, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 1.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 2.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 3.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 4.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 5.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 6.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 7.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 8.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 9.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 11.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 22.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 33.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 44.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 55.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 66.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 77.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
        redPacketRains.add(new RedPacketRain(this, 88.1, BitmapFactory.decodeResource(getResources(), R.drawable.red_packet)));
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
