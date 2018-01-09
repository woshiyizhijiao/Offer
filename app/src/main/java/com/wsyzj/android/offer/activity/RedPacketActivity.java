package com.wsyzj.android.offer.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.widget.sahongbao.RedPacket;
import com.wsyzj.android.offer.widget.sahongbao.RedPacketTest;

/**
 * @author 焦洋
 * @date 2018/1/9 11:25
 * @Description: $desc$
 */
public class RedPacketActivity extends Activity implements View.OnClickListener {

    private RedPacketTest redRainView1;
    private Button start, stop;
    private TextView money;
    private int totalmoney = 0;
    AlertDialog.Builder ab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packet);
        ab = new AlertDialog.Builder(RedPacketActivity.this);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        money = (TextView) findViewById(R.id.money);
        redRainView1 = (RedPacketTest) findViewById(R.id.red_packets_view1);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start) {
            startRedRain();
        } else if (v.getId() == R.id.stop) {
            stopRedRain();
        }
    }

    /**
     * 开始下红包雨
     */
    private void startRedRain() {
        redRainView1.startRain();
        redRainView1.setOnRedPacketClickListener(new RedPacketTest.OnRedPacketClickListener() {
            @Override
            public void onRedPacketClickListener(RedPacket redPacket) {
                redRainView1.pauseRain();
                ab.setCancelable(false);
                ab.setTitle("红包提醒");
                ab.setNegativeButton("继续抢红包", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        redRainView1.restartRain();
                    }
                });

                if (redPacket.isRealRed) {
                    ab.setMessage("恭喜你，抢到了" + redPacket.money + "元！");
                    totalmoney += redPacket.money;
                    money.setText("中奖金额: " + totalmoney);
                } else {
                    ab.setMessage("很遗憾，下次继续努力！");
                }
                redRainView1.post(new Runnable() {
                    @Override
                    public void run() {
                        ab.show();
                    }
                });
            }
        });
    }

    /**
     * 停止下红包雨
     */
    private void stopRedRain() {
        totalmoney = 0;//金额清零
        redRainView1.stopRainNow();
    }
}
