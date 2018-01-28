package com.wsyzj.android.offer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.SaRedPacket;
import com.wsyzj.android.offer.widget.SaRedPacketView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 焦洋
 * @date 2018/1/11 11:42
 * @Description: $desc$
 */
public class SaRedPacketActivity extends Activity {

    private SaRedPacketView saRedPacket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_red_packet);

        saRedPacket = findViewById(R.id.saRedPacket);
        saRedPacket.setRedPacketData(getRedPacketData());
    }

    public List<SaRedPacket> getRedPacketData() {
        List<SaRedPacket> redPackets = new ArrayList<>();
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        redPackets.add(new SaRedPacket(this, R.drawable.red_packet));
        return redPackets;
    }

    public void start(View view) {
        saRedPacket.start();
    }

    public void stop(View view) {
        saRedPacket.stop();
    }
}
