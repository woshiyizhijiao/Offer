package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.tools.LogUtils;

/**
 * author : 焦洋
 * time   : 2017/11/9  10:33
 * desc   : ProgressRingView
 */
public class ProgressRingView extends View {

    private Paint mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF;

    private int mWidth;
    private int mHeight;

    public ProgressRingView(Context context) {
        super(context);
        init();
    }

    public ProgressRingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressRingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBgPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        LogUtils.e(measuredWidth + " --- " + measuredHeight);

        if (mRectF == null) {
            mRectF = new RectF(0, 0, measuredWidth, measuredHeight);
        }
    }

    private int measureWidth(int mode, int width) {
        switch (mode) {
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mWidth = width;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
            default:
                break;
        }
        return mWidth;
    }

    private int measureHeight(int mode, int height) {
        switch (mode) {
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mHeight = height;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
            default:
                break;
        }
        return mHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(mRectF, 0, 120, true, mBgPaint);
    }
}
