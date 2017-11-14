package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.widget.CustomView1;

/**
 * @author: wsyzj
 * @date: 2017-02-26 15:09
 * @comment: 自定义View
 * -- 关闭整个应用的硬件加速 AndroidMenifest文件中application节点下添上 android:hardwareAccelerated=”false”
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
 * -- 颜色
 * --- 安卓支持的颜色模式：ARGB8888 四通道高精度(32位) - ARGB4444 四通道低精度(16位) - RGB565 屏幕默认模式(16位) - Alpha8 仅有透明通道(8位)
 * --- 以ARGB8888为例介绍颜色定义:
 * ---- 类型      	解释 	0(0x00)  255(0xff)
 * ---- A(Alpha) 	透明度 	透明 	  不透明
 * ---- R(Red)   	红色 	无色 	   红色
 * ---- G(Green) 	绿色 	无色  	   绿色
 * ---- B(Blue) 	蓝色 	无色 	   蓝色
 * ---- 其中 A R G B 的取值范围均为0~255(即16进制的0x00~0xff)
 * ---- A 从ox00到oxff表示从透明到不透明。 RGB 从0x00到0xff表示颜色从浅到深。当RGB全取最小值(0或0x000000)时颜色为黑色，全取最大值(255或0xffffff)时颜色为白色
 * --- 几种创建或使用颜色的方式
 * ---- int color = Color.GRAY;                   //灰色
 * ---- int color = Color.argb(127, 255, 0, 0);   //半透明红色
 * ---- int color = 0xaaff0000;                   //带有透明度的红色
 * ---- #f00            // 低精度 - 不带透明通道红色
 * ---- #af00           // 低精度 - 带透明通道红色
 * ---- #ff0000         // 高精度 - 不带透明通道红色
 * ---- #aaff0000       // 高精度 - 带透明通道红色
 */
public class CustomViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        final CustomView1 viewById = (CustomView1) findViewById(R.id.custom);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewById.setProgress(90);
            }
        });
    }

}
