package com.wsyzj.android.offer.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.wsyzj.android.offer.tools.DisplayUtils;

import java.util.Random;

/**
 * @author 焦洋
 * @date 2018/1/11 11:48
 * @Description: $desc$
 */
public class SaRedPacket {
    public Context context;
    public Bitmap bitmap;
    public int dWidth;
    public int dHeight;
    public float x;
    public float y;
    public float rotate;
    public float speed;

    public SaRedPacket(Context context, int drawableId) {
        this.context = context;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), drawableId);
        this.dWidth = bitmap.getWidth();
        this.dHeight = bitmap.getHeight();
        this.x = getX();
        this.y = getY();
        this.rotate = nextFloat(0f, 360f);
        this.speed = nextFloat(10f, 15f);
    }

    /**
     * 红包初始X轴方向
     *
     * @return
     */
    public float getX() {
        int screenWidth = DisplayUtils.getScreenWidth(context);
        return nextFloat(0, screenWidth - bitmap.getWidth());
    }

    /**
     * 生成min->max之间的数,最小生成的随机数为min，最大生成的随机数为max
     *
     * @param min
     * @param max
     * @return
     */
    public static float nextFloat(float min, float max) {
        return min + ((max - min) * new Random().nextFloat());
    }

    /**
     * 红包初始Y轴方向
     *
     * @return
     */
    public float getY() {
        int screenHeight = DisplayUtils.getScreenHeight(context);
        return -nextFloat((float) Math.hypot(dWidth, dHeight), screenHeight);
    }
}

