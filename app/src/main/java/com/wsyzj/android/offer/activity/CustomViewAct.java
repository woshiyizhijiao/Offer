package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wsyzj.android.offer.R;

/**
 * @author: wsyzj
 * @date: 2017-02-26 15:09
 * @comment: 自定义View
 * 1: 自定义View主要掌握一下四点
 * -- 绘制机制：掌握onMeasure,onLayout,onDraw及相关类的使用。
 * -- 事件传递机制：掌握dispathTouchEvent(),onInterceptEvent(),onTouchEvent()三者的相关逻辑。
 * -- 属性动画，因为属性动画核心是对数值的变化，使用属性动画对值View做动画操作。
 * -- 相关手势类。
 * 2: View基础
 * -- 安卓中的坐标系，是以屏幕左上角为原点
 * -- View的坐标系统是相对于父控件而言的
 * --- getTop();获取子View左上角距父View顶部的距离  getLeft();获取子View左上角距父View左侧的距离
 * --- getBottom();获取子View右下角距父View顶部的距离   getRight();获取子View右下角距父View左侧的距离
 * -- MotionEvent中 get 和 getRaw 的区别
 * --- event.getX(); event.getY(); 触摸点相对于其所在组件坐标系的坐标
 * --- event.getRawX(); event.getRawY(); 触摸点相对于屏幕默认坐标系的坐标
 * -- 安卓中角度(angle)与弧度(radian)的有关问题
 * --- 角度: 两条射线从圆心向圆周射出，形成一个夹角和夹角正对的一段弧。(当这段弧长正好等于圆周长的360分之一时，两条射线的夹角的大小为1度.)
 * --- 弧度: 两条射线从圆心向圆周射出，形成一个夹角和夹角正对的一段弧。(当这段弧长正好等于圆的半径时，两条射线的夹角大小为1弧度.)
 * --- 角度和弧度的换算关系 :圆一周对应的角度为360度(角度)，对应的弧度为2π弧度。故得等价关系:360(角度) = 2π(弧度) ==> 180(角度) = π(弧度)
 * --- 在默认的屏幕坐标系中角度增大方向为顺时针。
 */
public class CustomViewAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_custom_view);
    }
}
