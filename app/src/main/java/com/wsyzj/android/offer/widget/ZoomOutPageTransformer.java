package com.wsyzj.android.offer.widget;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * @author: wsyzj
 * @date: 2017-05-20 13:53
 * @comment: 走廊效果实现接口
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE_X = 0.99f;
    private static final float MIN_SCALE_Y = 0.8f;
//    private static final float MIN_ALPHA = 0.72f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {
//            page.setAlpha(MIN_ALPHA);
            page.setScaleX(MIN_SCALE_X);
            page.setScaleY(MIN_SCALE_Y);
        } else if (position <= 1) { // [-1,1]
            float scaleFactor = Math.max(MIN_SCALE_X, 1 - Math.abs(position));
            if (position < 0) {
                float scaleX = 1 + 0.01f * position;
                float scaleY = 1 + 0.2f * position;
                Log.d("google_lenve_fb", "transformPage: scaleX:" + scaleX);
                page.setScaleX(scaleX);
                page.setScaleY(scaleY);
            } else {
                float scaleX = 1 - 0.01f * position;
                float scaleY = 1 - 0.2f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleY);
            }
//            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE_X) / (1 - MIN_SCALE_X) * (1 - MIN_ALPHA));
        }
    }
}
