package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.tools.UIUtils;

/**
 * @author: wsyzj
 * @date: 2017-03-13 11:40
 * @comment: 自定义View
 */
public class CustomView extends View {
    private final int black = UIUtils.getColor(R.color.black);

    private Paint mPaint = new Paint();
    private int width;
    private int height;

    public CustomView(Context context) {
        super(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(black);
        mPaint.setStrokeWidth(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 画一个表格分成四个
        canvas.drawLines(new float[]{0, height / 2, width, height / 2, width / 2, 0, width / 2, height}, mPaint);
        canvas1(canvas);
        canvas2(canvas);
    }

    /**
     * 画一个大圆一个小圆周围 360° 每隔一段距离画一条大圆到小圆的线
     *
     * @param canvas
     */
    private void canvas1(Canvas canvas) {
        int cX = width / 4;
        int cY = height / 4;
        int circleOther = cX - 20;          // 外圆半径
        int circleWithin = cX - 50;         // 内圆半径

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cX, cY, circleOther, mPaint);
        canvas.drawCircle(cX, cY, circleWithin, mPaint);
        canvas.translate(cX, cY);

        for (int x = 0; x < 36; x++) {
            canvas.drawLine(0, circleWithin, 0, circleOther, mPaint);
            canvas.rotate(10);
        }
    }

    private int[] arcs = {30, 60, 90, 180};
    private int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.LTGRAY};

    /**
     * 画一个饼状图
     *
     * @param canvas
     */
    private void canvas2(Canvas canvas) {
        canvas.translate(width / 2, 0);     // 把原点移动到第二个格子的正中间

        mPaint.setStyle(Paint.Style.FILL);

        int b = width / 4;
        int currentAngle = 0;
        RectF rectF = new RectF(-b, -b, b, b);

        for (int x = 0; x < arcs.length; x++) {
            mPaint.setColor(colors[x]);
            canvas.drawArc(rectF, currentAngle, arcs[x], true, mPaint);
            currentAngle += arcs[x];
        }
    }
}
