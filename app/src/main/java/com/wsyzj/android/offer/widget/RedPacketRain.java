package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Bitmap;

import com.wsyzj.android.offer.tools.DisplayUtils;

import java.util.Random;

/**
 * @author 焦洋
 * @date 2018/1/9 14:47
 * @Description: $desc$
 */
public class RedPacketRain {
    public float x;
    public float y;
    public Bitmap bitmap;

    public RedPacketRain(Context context, Bitmap bitmap) {
        this.bitmap = bitmap;
        int screenWidth = DisplayUtils.getScreenWidth(context);
        // 计算x轴的位置，最大值不能超多图片的最高值
        float randomX = getRandomNum(0, screenWidth - (Math.max(bitmap.getWidth(), bitmap.getHeight())));
        x = randomX;
        y = -bitmap.getHeight();
    }

    /**
     * 生成min->max之间的数,最小生成的随机数为min，最大生成的随机数为max
     *
     * @param min
     * @param max
     * @return
     */
    public static float getRandomNum(int min, int max) {
        Random rdm = new Random();
        return (float) rdm.nextInt(max - min + 1) + min;
    }
}
