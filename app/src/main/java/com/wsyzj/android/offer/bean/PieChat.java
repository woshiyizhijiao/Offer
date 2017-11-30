package com.wsyzj.android.offer.bean;

/**
 * @author 焦洋
 * @date 2017/11/30 11:28
 */
public class PieChat {
    public int color;       // 颜色
    public float percentage;  // 百分比

    public PieChat(int color, float percentage) {
        this.color = color;
        this.percentage = percentage;
    }

    public float getRadian() {
        return 360 * percentage;
    }
}
