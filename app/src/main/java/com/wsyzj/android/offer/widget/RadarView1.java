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
 * @author 焦洋
 * @date 2017/12/4 11:42
 */
public class RadarView1 extends View {
    private Paint mPaint;
    private Path mPath;
    private int mWidth;
    private int mHeight;

    public RadarView1(Context context) {
        super(context);
        init();
    }

    public RadarView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadarView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(1);

        mPath = new Path();
        mPath.moveTo(0, 0);
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
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.save();
        canvas.scale(1, -1);
        canvas.save();

        drawNet(canvas);
    }

    /**
     * 绘制网格
     *
     * @param canvas
     */
    private void drawNet(Canvas canvas) {
        canvas.save();
        for (int i = 0; i < 1; i++) {
            drawOneNet(canvas, i * 100);
        }
    }

    /**
     * 绘制网格
     *
     * @param canvas
     * @param width
     */
    private void drawOneNet(Canvas canvas, int width) {
        int height = (int) (width * Math.cos(Math.toRadians(30)));
        for (int i = 0; i < 6; i++) {
            canvas.restore();
            canvas.drawLine(-width / 2, height, width / 2, height, mPaint);
            canvas.rotate(60, 0, 0);
            canvas.save();
        }
    }
}
