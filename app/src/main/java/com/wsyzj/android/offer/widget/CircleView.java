package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.R;

/**
 * @author: wsyzj
 * @date: 2017-09-09 16:34
 * @comment: 自定义view练习
 */
public class CircleView extends View {

    private Paint mPaint;
    private int mCircleColor;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mCircleColor = array.getColor(R.styleable.CircleView_circle_color, Color.GRAY);
        init();
    }

//    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    private void init() {
        // 创建画笔
        mPaint = new Paint();
        // 设置画笔颜色
        mPaint.setColor(mCircleColor);
        // 画笔大小
        mPaint.setStrokeWidth(10);
        // 设置内容为填充
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getPaddingRight();
        int bottom = getPaddingBottom();

        // 需要获取padding值，设置宽高时计算在内，否则布局设置padding无效
        int width = getWidth() - left - right;
        int height = getHeight() - top - bottom;

        int r = Math.min(width / 2, height / 2);
        canvas.drawColor(Color.RED);
        canvas.drawCircle(left + width / 2, top + height / 2, r, mPaint);
    }
}
