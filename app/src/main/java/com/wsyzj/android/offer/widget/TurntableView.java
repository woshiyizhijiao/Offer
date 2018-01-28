package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.R;

/**
 * @author 焦洋
 * @date 2018/1/12 14:13
 * @Description: 转盘
 */
public class TurntableView extends View {
    private int[] mBgColor = {R.color.c388e3c, R.color.c4caf50};
    private String[] mDesc = {"三星Note8", "三星note9"};

    private int mProductNum = 6;                // 商品数量
    private float mAngle = 0;                   // 圆形的角度
    private float mWidth;
    private float mHeight;
    private float mCenter;
    private float mRadius;
    private Paint mSectorPaint;                 // 每个扇形的背景
    private Paint mTextPaint;                // 商品的描述

    public TurntableView(Context context) {
        super(context);
        init();
    }

    public TurntableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TurntableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mSectorPaint = new Paint();
        mSectorPaint.setAntiAlias(true);
        mSectorPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(60);

        mAngle = (float) 360 / mProductNum;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mCenter = mWidth / 2;
        mRadius = mCenter - 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawSectorBg(canvas);
    }

    /**
     * 绘制扇形
     *
     * @param canvas
     */
    private void drawSectorBg(Canvas canvas) {
        float startAngle = -mAngle / 2 - 90;
        for (int i = 0; i < mProductNum; i++) {
            mSectorPaint.setColor(getResources().getColor(mBgColor[i % 2]));
            RectF rectF = new RectF(mCenter - mRadius, mCenter - mRadius, mCenter + mRadius, mCenter + mRadius);
            canvas.drawArc(rectF, startAngle, mAngle, true, mSectorPaint);
            drawText(startAngle, mDesc[i % 2], mRadius, canvas);
            startAngle += mAngle;
        }
    }

    /**
     * 绘制商品描述
     *
     * @param startAngle
     * @param desc
     * @param radius
     * @param canvas
     */
    private void drawText(float startAngle, String desc, float radius, Canvas canvas) {
        Path circlePath = new Path();
        RectF rectF = new RectF(mCenter - mRadius, mCenter - mRadius, mCenter + mRadius, mCenter + mRadius);
        // 创建绘制路径
        circlePath.addArc(rectF, startAngle, mAngle);
        //圆弧的水平偏移  与路径起始点的水平偏移距离
        float textWidth = mTextPaint.measureText(desc);
        //圆弧的垂直偏移  与路径中心的垂直偏移量
        float hOffset = (float) (Math.sin(mAngle / 2 / 180 * Math.PI) * radius) - textWidth / 2;

        //绘制文字
        canvas.drawTextOnPath(desc, circlePath, hOffset, radius / 4, mTextPaint);
    }
}
