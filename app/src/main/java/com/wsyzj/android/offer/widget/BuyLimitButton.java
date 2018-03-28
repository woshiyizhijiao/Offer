package com.wsyzj.android.offer.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.wsyzj.android.offer.tools.LogUtils;

/**
 * <pre>
 *     author : 焦洋
 *     e-mail : jiao35478729@163.com
 *     time   : 2018/03/28
 *     desc   :
 * </pre>
 */
public class BuyLimitButton extends TextView {

    private int mStorkeWidth = 5;
    private int mStorkeRadius = 10;

    private int mWidth;
    private int mHeight;

    private float mFillBgProgress = 0.0f;
    private int mFillBgDuration = 1000;
    private ValueAnimator mFillBgAnim;

    private Paint mStrokePaint;
    private Paint mBgPaint;
    private Paint mTextPaint;

    private String mCurrentText = "我是一只焦";
    private int mNormalColor = Color.BLACK;
    private int mNoverlapColor = Color.GREEN;

    private LinearGradient mProgressTextGradient;

    public BuyLimitButton(Context context) {
        super(context);
        init();
    }

    public BuyLimitButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BuyLimitButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mStrokePaint = new Paint();
        mStrokePaint.setAntiAlias(true);
        mStrokePaint.setStrokeWidth(mStorkeWidth);
        mStrokePaint.setColor(Color.BLACK);
        mStrokePaint.setStyle(Paint.Style.STROKE);

        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setColor(Color.RED);
        mBgPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(500);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(new RectF(0, 0, mWidth, mHeight), mStorkeRadius, mStorkeRadius, mStrokePaint);
        canvas.drawRect(mStorkeWidth, mStorkeWidth, (mWidth - mStorkeWidth) * mFillBgProgress, mHeight - mStorkeWidth, mBgPaint);
        testDraw(canvas);
    }

    /**
     * 填充背景色
     */
    public void startAnim() {
        mFillBgAnim = ValueAnimator.ofFloat(0, 1);
        mFillBgAnim.setDuration(mFillBgDuration);
        mFillBgAnim.setInterpolator(new LinearInterpolator());
        mFillBgAnim.start();

        mFillBgAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                mFillBgProgress = animatedValue;
                invalidate();
            }
        });
    }

    private void testDraw(Canvas canvas) {
        LogUtils.e("这里走了几次 " + mFillBgProgress);
        final float y = canvas.getHeight() / 2 - (mTextPaint.descent() / 2 + mTextPaint.ascent() / 2);
        final float textWidth = mTextPaint.measureText(mCurrentText);

        float w = getMeasuredWidth() - 2 * mStorkeWidth;
        //进度条压过距离
        float coverlength = w * (mWidth - mStorkeWidth) * mFillBgProgress;
        //开始渐变指示器
        float indicator1 = w / 2 - textWidth / 2;
        //结束渐变指示器
        float indicator2 = w / 2 + textWidth / 2;
        //文字变色部分的距离
        float coverTextLength = textWidth / 2 - w / 2 + coverlength;
        float textProgress = coverTextLength / textWidth;
        if (coverlength <= indicator1) {
            mTextPaint.setShader(null);
            mTextPaint.setColor(Color.BLACK);
        } else if (indicator1 < coverlength && coverlength <= indicator2) {
            mProgressTextGradient = new LinearGradient((w - textWidth) / 2 + mStorkeWidth, 0,
                    (w + textWidth) / 2 + mStorkeWidth, 0,
                    new int[]{mNoverlapColor, Color.BLACK},
                    new float[]{textProgress, textProgress + 0.001f},
                    Shader.TileMode.CLAMP);
            mTextPaint.setColor(Color.BLACK);
            mTextPaint.setShader(mProgressTextGradient);
        } else {
            mTextPaint.setShader(null);
            mTextPaint.setColor(mNoverlapColor);
        }
        canvas.drawText(mCurrentText, (w - textWidth) / 2 + mStorkeWidth, y, mTextPaint);
    }
}
