package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.adapter.RvLottieAdapter;

import java.util.Arrays;


/**
 * @author: wsyzj
 * @date: 2017-02-22 22:25
 * @comment: 最近碉堡了的动画效果
 */
public class LottieAct extends AppCompatActivity {

    private RecyclerView recycler;
    private String[] mDatas = {"EmptyState.json", "HamburgerArrow.json", "LottieLogo1.json", "LottieLogo2.json"
            , "MotionCorpse-Jrcanest.json", "PinJump.json", "TwitterHeart.json"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lottie);

        setLottieData();
    }

    /**
     * 设置lottie的数据
     */
    private void setLottieData() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        RvLottieAdapter adapter = new RvLottieAdapter(R.layout.rv_item_lottie, Arrays.asList(mDatas));
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
