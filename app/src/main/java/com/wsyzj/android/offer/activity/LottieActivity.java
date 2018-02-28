package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.wsyzj.android.offer.R;


/**
 * @author: wsyzj
 * @date: 2017-02-22 22:25
 * @comment: 最近碉堡了的动画效果
 */
public class LottieActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fl_discover;
    private FrameLayout fl_chat;
    private FrameLayout fl_shopping;
    private FrameLayout fl_personage;

    private LottieAnimationView lottie_discover;
    private LottieAnimationView lottie_chat;
    private LottieAnimationView lottie_shopping;
    private LottieAnimationView lottie_personage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        fl_discover = findViewById(R.id.fl_discover);
        fl_chat = findViewById(R.id.fl_chat);
        fl_shopping = findViewById(R.id.fl_shopping);
        fl_personage = findViewById(R.id.fl_personage);

        lottie_discover = findViewById(R.id.lottie_discover);
        lottie_chat = findViewById(R.id.lottie_chat);
        lottie_shopping = findViewById(R.id.lottie_shopping);
        lottie_personage = findViewById(R.id.lottie_personage);

        fl_discover.setOnClickListener(this);
        fl_chat.setOnClickListener(this);
        fl_shopping.setOnClickListener(this);
        fl_personage.setOnClickListener(this);

        lottie_discover.setProgress(1.0f);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_discover:
                changTab(R.id.fl_discover);
                break;
            case R.id.fl_chat:
                changTab(R.id.fl_chat);
                break;
            case R.id.fl_shopping:
                changTab(R.id.fl_shopping);
                break;
            case R.id.fl_personage:
                changTab(R.id.fl_personage);
                break;
            default:
                break;
        }
    }

    private void changTab(int id) {
        if (id == R.id.fl_discover) {
            if (!lottie_discover.isAnimating()) {
                lottie_discover.playAnimation();
            }

            lottie_chat.setProgress(0.0f);
            lottie_shopping.setProgress(0.0f);
            lottie_personage.setProgress(0.0f);

            lottie_chat.cancelAnimation();
            lottie_shopping.cancelAnimation();
            lottie_personage.cancelAnimation();
        } else if (id == R.id.fl_chat) {
            if (!lottie_chat.isAnimating()) {
                lottie_chat.playAnimation();
            }

            lottie_discover.setProgress(0.0f);
            lottie_shopping.setProgress(0.0f);
            lottie_personage.setProgress(0.0f);

            lottie_discover.cancelAnimation();
            lottie_shopping.cancelAnimation();
            lottie_personage.cancelAnimation();
        } else if (id == R.id.fl_shopping) {
            if (!lottie_shopping.isAnimating()) {
                lottie_shopping.playAnimation();
            }

            lottie_discover.setProgress(0.0f);
            lottie_chat.setProgress(0.0f);
            lottie_personage.setProgress(0.0f);

            lottie_discover.cancelAnimation();
            lottie_chat.cancelAnimation();
            lottie_personage.cancelAnimation();
        } else if (id == R.id.fl_personage) {
            if (!lottie_personage.isAnimating()) {
                lottie_personage.playAnimation();
            }

            lottie_discover.setProgress(0.0f);
            lottie_chat.setProgress(0.0f);
            lottie_shopping.setProgress(0.0f);

            lottie_discover.cancelAnimation();
            lottie_chat.cancelAnimation();
            lottie_shopping.cancelAnimation();
        }
    }
}
