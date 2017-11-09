package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.R;

/**
 * author : 焦洋
 * time   : 2017/11/8  17:14
 * desc   : WanDouJiaProgress
 */
public class WanDouJiaProgress extends View {
    private Paint mBgPaint;         // 背景
    private Paint mCurrentPaint;    // 当前进度
    private Paint mCachePaint;   // 缓存进度

    private int mViewHeight = 100;
    private int mRound = 5;

    public WanDouJiaProgress(Context context) {
        super(context);
        init();
    }

    public WanDouJiaProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WanDouJiaProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBgPaint = setPaintStyle(R.color.cf5f5f5, Paint.Style.FILL);
        mCachePaint = setPaintStyle(R.color.c388e3c, Paint.Style.FILL);
        mCurrentPaint = setPaintStyle(R.color.c4caf50, Paint.Style.FILL);
    }

    private Paint setPaintStyle(int color, Paint.Style style) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(color));
        paint.setStyle(style);
        return paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF bgRect = new RectF(0, 0, getWidth(), mViewHeight);
        canvas.drawRoundRect(bgRect, mRound, mRound, mBgPaint);

        RectF progressRect = new RectF(0, 0, 500, mViewHeight);
        canvas.drawRoundRect(progressRect, mRound, mRound, mCachePaint);

        RectF currentRect = new RectF(0, 0, 300, mViewHeight);
        canvas.drawRoundRect(currentRect, mRound, mRound, mCurrentPaint);
    }
}
