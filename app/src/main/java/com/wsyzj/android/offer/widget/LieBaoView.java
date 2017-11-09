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
 * time   : 2017/11/9  15:05
 * desc   : LieBaoView
 */
public class LieBaoView extends View {

    private Paint mExcirclePaint;
    private Paint mInnerPaint;
    private Paint mTextPaint;
    private int mCurrentProgress;
    private RectF mRectF;

    public LieBaoView(Context context) {
        super(context);
        init();
    }

    public LieBaoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LieBaoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // 外圆
        mExcirclePaint = new Paint();
        mExcirclePaint.setAntiAlias(true);
        mExcirclePaint.setColor(getResources().getColor(R.color.c388e3c));

        // 内圆
        mInnerPaint = new Paint();
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setColor(getResources().getColor(R.color.c4caf50));

        // 文字
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(getResources().getColor(R.color.white));

        mRectF = new RectF(0, 0, 200, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float excircleRadius = getWidth() / 2 - getPaddingLeft() - getPaddingRight();
        float innerRadius = excircleRadius - 20;

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, excircleRadius, mExcirclePaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, innerRadius, mInnerPaint);

        float textWidth = mTextPaint.measureText(mCurrentProgress + "%");
        float textX = (getWidth() - textWidth) / 2;
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float textY = getHeight() / 2 + (Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2;
        canvas.drawText(mCurrentProgress + "%", textX, textY, mTextPaint);
        for (int x = 0; x < 180; x++) {
            canvas.drawArc(mRectF, x, x + 1, false, mExcirclePaint);
        }

        canvas.drawRect(mRectF, mExcirclePaint);
    }
}
