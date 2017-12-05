package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.R;

/**
 * @author 焦洋
 * @date 2017/12/4 14:34
 */
public class ClockView extends View {

    /**
     * 表盘刻度的数量
     */
    private final static int SCALE_COUNT = 60;

    private Paint mExcirclePaint;
    private Paint mScalePaint;
    private Paint mTextPaint;
    private int mWidth;
    private int mHeight;

    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mExcirclePaint = new Paint();
        mExcirclePaint.setAntiAlias(true);
        mExcirclePaint.setStyle(Paint.Style.STROKE);
        mExcirclePaint.setStrokeWidth(5);
        mExcirclePaint.setColor(getResources().getColor(R.color.ce64a19));

        mScalePaint = new Paint();
        mScalePaint.setAntiAlias(true);
        mScalePaint.setStyle(Paint.Style.STROKE);
        mScalePaint.setColor(getResources().getColor(R.color.ce64a19));

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(30);
        mTextPaint.setColor(getResources().getColor(R.color.ce64a19));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float radius = (float) (Math.min(mWidth / 2, mHeight / 2) * 0.8);
        int scale = 0;

        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.rotate(180);
        canvas.drawCircle(0, 0, radius, mExcirclePaint);
        for (int i = 0; i < SCALE_COUNT; i++) {
            if (i % 5 == 0) {
                mScalePaint.setStrokeWidth(7);
                canvas.drawLine(0, radius - 40, 0, radius, mScalePaint);
                if (scale == 0) {
                    canvas.drawText(String.valueOf(12), -15, radius - 70, mTextPaint);
                } else {
                    canvas.drawText(String.valueOf(scale), -15, radius - 70, mTextPaint);
                }
                scale += 1;
            } else {
                mScalePaint.setStrokeWidth(3);
                canvas.drawLine(0, radius - 30, 0, radius, mScalePaint);
            }
            canvas.rotate(6);
        }
    }
}
