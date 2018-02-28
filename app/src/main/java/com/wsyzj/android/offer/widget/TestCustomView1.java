package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 焦洋
 * @date 2018/2/8 9:35
 * @Description: $desc$
 */
public class TestCustomView1 extends View {

    private Paint mPaint;
    private float mWidth;
    private float mHeight;

    public TestCustomView1(Context context) {
        super(context);
        init();
    }

    public TestCustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestCustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawLine(-mWidth / 2, 0, mWidth / 2, 0, mPaint);
        canvas.drawLine(0, -mHeight / 2, 0, mHeight / 2, mPaint);
        mPaint.setTextSize(100);

        float textWidth = mPaint.measureText("我是一坨焦");
        canvas.drawText("我是一坨焦", -textWidth / 2, Math.abs(mPaint.ascent() + mPaint.descent()) / 2, mPaint);
    }
}
