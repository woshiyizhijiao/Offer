package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 焦洋
 * @date 2017/11/23 15:52
 */
public class AnimatedPieView extends View {

    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;

    private RectF mRectF = new RectF();

    public AnimatedPieView(Context context) {
        super(context);
        init();
    }

    public AnimatedPieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnimatedPieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.RED);
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(80);
        mPaint1.setAntiAlias(true);


        mPaint2 = new Paint();
        mPaint2.setColor(Color.GREEN);
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeWidth(80);
        mPaint2.setAntiAlias(true);

        mPaint3 = new Paint();
        mPaint3.setColor(Color.BLUE);
        mPaint3.setStyle(Paint.Style.STROKE);
        mPaint3.setStrokeWidth(80);
        mPaint3.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingLeft() - getPaddingRight();

        canvas.translate(width / 2, height / 2);
        float radius = (float) (Math.min(width, height) / 2 * 0.85);
        mRectF.set(-radius, -radius, radius, radius);

        canvas.drawArc(mRectF, 0, 120, false, mPaint1);
        canvas.drawArc(mRectF, 120, 120, false, mPaint2);
        canvas.drawArc(mRectF, 240, 120, false, mPaint3);
    }
}
