package com.wsyzj.android.offer.model;

import android.support.annotation.NonNull;

/**
 * @author: wsyzj
 * @date: 2017-03-09 11:19
 * @comment: 饼状图的数据
 */
public class PieData {
    // 用户关心数据
    public String name;        // 名字
    public float value;        // 数值
    public float percentage;   // 百分比

    // 非用户关心数据
    public int color = 0;      // 颜色
    public float angle = 0;    // 角度

    public PieData(@NonNull String name, @NonNull float value) {
        this.name = name;
        this.value = value;
    }
}
