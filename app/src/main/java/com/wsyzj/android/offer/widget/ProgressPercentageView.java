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
 * time   : 2017/11/8  11:20
 * desc   : 百分比进度条
 */
public class ProgressPercentageView extends View {
    private Paint mProPaint;
    private Paint mBgPaint;
    private Paint mRectPaint;
    private Paint mTextPaint;

    private int mWidth;
    private int mHeight;
    private int mViewHeight;
    private int mPaintHeight = 15;
    private int mRectHeight = 80;
    private int mRectWidth = 150;
    private float mMoveRect = 0;
    private float mProgress = 100;
    private float mCurrentProgress = 0;

    private ValueAnimator mProgressAnim;

    public ProgressPercentageView(Context context) {
        super(context);
        init();
    }

    public ProgressPercentageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressPercentageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mBgPaint = new Paint();
        mBgPaint.setColor(getResources().getColor(R.color.c666));
        mBgPaint.setStrokeWidth(mPaintHeight);

        mProPaint = new Paint();
        mProPaint.setColor(getResources().getColor(R.color.ce64a19));
        mProPaint.setStrokeWidth(mPaintHeight);

        mRectPaint = new Paint();
        mRectPaint.setColor(getResources().getColor(R.color.c03a9f4));
        mRectPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        mTextPaint.setColor(getResources().getColor(R.color.white));
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(30);

        mViewHeight = mPaintHeight + mRectHeight;

        initAnimation();
    }

    private void initAnimation() {
        mProgressAnim = ValueAnimator.ofFloat(0, mProgress);
        mProgressAnim.setDuration(1500);
        mProgressAnim.setStartDelay(1000);
        mProgressAnim.setInterpolator(new LinearInterpolator());
        mProgressAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mCurrentProgress = (mWidth - getPaddingLeft() - getPaddingRight()) * value / mProgress;

                if ((mWidth - mCurrentProgress - getPaddingRight()) > mRectWidth) {
                    mMoveRect = mCurrentProgress;
                }
                invalidate();
            }
        });
        mProgressAnim.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();

        canvas.drawLine(paddingLeft, mRectHeight + (mPaintHeight / 2), mWidth - paddingRight, mRectHeight + (mPaintHeight / 2), mBgPaint);
        canvas.drawLine(paddingLeft, mRectHeight + (mPaintHeight / 2), paddingLeft + mCurrentProgress, mRectHeight + (mPaintHeight / 2), mProPaint);

        RectF rectF = new RectF(paddingLeft + mMoveRect, 0, mRectWidth + mMoveRect, mRectHeight);
        canvas.drawRect(rectF, mRectPaint);

        canvas.drawText(mCurrentProgress + "%", mRectWidth / 2 + mMoveRect, mRectHeight / 2, mTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int WidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(measureWidth(WidthMode, widthSize), measureHeight(heightMode, heightSize));
    }

    private int measureWidth(int mode, int width) {
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY:
                mWidth = width;
                break;
            case MeasureSpec.AT_MOST:
                break;
            default:
                break;
        }
        return mWidth;
    }

    private int measureHeight(int mode, int height) {
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY:
                mHeight = height;
                break;
            case MeasureSpec.AT_MOST:
                mHeight = mViewHeight;
                break;
            default:
                break;
        }
        return mHeight;
    }
}
