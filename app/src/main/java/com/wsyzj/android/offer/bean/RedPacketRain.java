package com.wsyzj.android.offer.bean;

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
    public double money;
    public float x;
    public float y;
    public float rotate;
    public double speed;
    private float addRegion;
    public Bitmap bitmap;

    public RedPacketRain(Context context, double money, Bitmap bitmap) {
        this.bitmap = bitmap;
        this.money = money;
        x = getRandomX(context);
        y = -bitmap.getHeight();
        speed = Math.random() + 0.5;
        rotate = nextInt(0, 360);
        addRegion = 10;
    }

    /**
     * 增加点击区域
     *
     * @param mX
     * @param mY
     * @return
     */
    public boolean isContains(float mX, float mY) {
        return x - addRegion < mX && x + addRegion + bitmap.getWidth() > mX
                && y - addRegion < mY && y + addRegion + bitmap.getHeight() > mY;
    }

    /**
     * 计算x轴的位置，最大值不能超多图片的最高值
     *
     * @param context
     * @return
     */
    private float getRandomX(Context context) {
        int screenWidth = DisplayUtils.getScreenWidth(context);
        return nextInt(0, screenWidth - (Math.max(bitmap.getWidth(), bitmap.getHeight())));
    }

    /**
     * 生成min->max之间的数,最小生成的随机数为min，最大生成的随机数为max
     *
     * @param min
     * @param max
     * @return
     */
    private float nextInt(int min, int max) {
        Random rdm = new Random();
        return (float) rdm.nextInt(max - min + 1) + min;
    }
}
