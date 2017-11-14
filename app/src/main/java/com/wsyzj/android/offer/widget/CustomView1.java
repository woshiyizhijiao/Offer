package com.wsyzj.android.offer.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.wsyzj.android.offer.R;

/**
 * author : 焦洋
 * time   : 2017/11/10  10:30
 * desc   : CustomView1
 */
public class CustomView1 extends View {
    private Paint mCirclePaint;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private RectF mCircleRectF = new RectF();

    private int mCircleWidth = 20;
    private int mCurrentProgress = 0;  // 满是一百


    public CustomView1(Context context) {
        super(context);
        init();
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // 外圆
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(R.color.c388e3c));

        // 圆弧
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setColor(getResources().getColor(R.color.c4caf50));

        // 文字
        mTextPaint = new Paint();
        mTextPaint.setTextSize(50);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(getResources().getColor(R.color.white));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;

        int circleRadius = center - mCircleWidth;

        mCircleRectF.left = center - circleRadius - mCircleWidth / 2;
        mCircleRectF.top = center - circleRadius - mCircleWidth / 2;
        mCircleRectF.right = center + circleRadius + mCircleWidth / 2;
        mCircleRectF.bottom = center + circleRadius + mCircleWidth / 2;
        mArcPaint.setStrokeWidth(mCircleWidth);

        canvas.drawCircle(center, center, circleRadius, mCirclePaint);
        canvas.drawArc(mCircleRectF, 270, (float) (mCurrentProgress * 3.6), false, mArcPaint);

        String text = mCurrentProgress + "%";
        float textWidth = mTextPaint.measureText(text);
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float textX = (getWidth() - textWidth) / 2;
        float textY = getHeight() / 2 + (Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2;
        canvas.drawText(text, textX, textY, mTextPaint);
    }

    /**
     * 设置圆弧进度
     */
    public void setProgress(final int progress) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, progress);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mCurrentProgress = (int) value;
                invalidate();
            }
        });
        valueAnimator.start();
    }
}
