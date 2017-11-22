package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author : 焦洋
 * time   : 2017/11/22  10:13
 * desc   : RadarView
 */
public class RadarView extends View {
    private int mCount = 6; // 数据个数
    private float mAngle = (float) (Math.PI * 2 / mCount);
    private float mRadius;  // 网格最大半径
    private float mCenterX;
    private float mCenterY;
    private String[] mTitles = {"A", "B", "C", "D", "E", "F"};
    private double[] data = {100, 60, 60, 60, 100, 50, 10, 20}; //各维度分值
    private float mMaxValue = 100; // 数据最大值
    private Paint mMainPaint;  // 雷达画笔
    private Paint mValuePaint;  // 数据区画笔
    private Paint mTextPaint; // 文本画笔


    public RadarView(Context context) {
        super(context);
        init();
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mMainPaint = new Paint();
        mMainPaint.setStrokeWidth(10);
        mMainPaint.setColor(Color.BLACK);
        mMainPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadius = Math.min(w, h) / 2 * 0.9f;
        mCenterX = w / 2;
        mCenterY = h / 2;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        float r = mRadius / (mCount - 1);   // 蜘蛛丝之间的间距
        for (int i = 0; i < mCount; i++) {
            float currentR = r * i;         // 当前半径
            path.reset();
            for (int j = 0; j < mCount; j++) {
                if (j == 0) {
                    path.moveTo(mCenterX + currentR, mCenterY);
                } else {
                    // 根据半径，计算蜘蛛丝上每个点的坐标
                    float x = (float) (mCenterX + currentR * Math.cos(mAngle * j));
                    float y = (float) (mCenterY + currentR * Math.sin(mAngle * j));
                    path.moveTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, mMainPaint);
        }
    }
}
