package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * author : 焦洋
 * time   : 2017/11/22  10:13
 * desc   : RadarView
 */
public class RadarView extends View {
    // 画笔对象
    private Paint mPaint;

    // 绘制6条坐标轴
    private Path mPath;

    // view宽度
    private int mWidth;

    // view高度
    private int mHeight;
    /**
     * 范围在(0,400],默认数值
     */
    private int[] values = {100, 150, 200, 150, 300, 400};

    public RadarView(Context context) {
        super(context);
        init(context, null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    /**
     * 初始化画笔相关
     *
     * @param context 上下文
     * @param attrs   属性
     */
    private void init(Context context, AttributeSet attrs) {
        // 实例化画笔
        mPaint = new Paint();

        // 设置画笔样式为描边模式
        mPaint.setStyle(Paint.Style.STROKE);

        // 开启抗锯齿
        mPaint.setAntiAlias(true);

        // 实例化坐标轴path
        mPath = new Path();

        // 移动至坐标原点
        mPath.moveTo(0, 0);

    }


    /**
     * 先绘制网格
     * 其次,绘制5条直线,并设置值,旋转度数,计算旋转后顶点的坐标
     * 第三,根据顶点绘制path
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置画笔颜色为蓝色
        mPaint.setColor(Color.BLUE);

        // 设置画笔宽度为1
        mPaint.setStrokeWidth(1);

        // 移动画布到屏幕中心
        canvas.translate(mWidth / 2, mHeight / 2);

        // 第1次保存画布在屏幕中心画布状态,restoreCount为0
        canvas.save();

        // 坐标以X轴翻转
        canvas.scale(1, -1);

        // 第2次,保存坐标以x轴翻转的画布状态,restoreCount为1
        canvas.save();

        // 绘制网格
        drawNet(canvas);

        // 绘制所有坐标顶点
        drawPoints(canvas, values);

    }


    /**
     * 动态设置值
     *
     * @param values 待展示值,每个坐标不能超过400
     */
    public void setValues(int[] values) {
        this.values = values;
        invalidate();// 重新绘制
    }

    /**
     * 连接各个顶点
     *
     * @param canvas 画笔工具
     * @param points 顶点
     */
    private void point2Line(Canvas canvas, Point[] points) {
        canvas.restoreToCount(1);
        Path path = new Path();
        Paint paint = new Paint();
        paint.setColor(0x7f1aaf03);// 50%的透明度的绿色
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);

        path.moveTo(points[0].x, points[0].y);
        for (int i = 1; i < points.length; i++) {
            path.lineTo(points[i].x, points[i].y);
        }
        // 闭合线路
        path.close();
        canvas.drawPath(path, paint);
    }

    // 绘制网络
    private void drawNet(Canvas canvas) {
        // 第2-5保存旋转后的线条状态
        canvas.save();
        for (int i = 0; i < 5; i++) {
            drawOneNet(canvas, i * 100);
            if (i == 4) {
                drawLines(canvas, i * 100);
            }
        }
    }

    /**
     * 绘制素所有坐标顶点
     *
     * @param canvas
     */
    private void drawPoints(Canvas canvas, int[] values) {
        Point[] points = new Point[values.length];
        // 绘制顶点
        for (int i = 0; i < values.length; i++) {
            Point point = getRotatePoint(i, values[i]);
            points[i] = point;
            drawPoint(point, canvas);
        }

        // 连接各个顶点
        point2Line(canvas, points);
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

    /**
     * 绘制线条
     *
     * @param canvas
     */
    private void drawLines(Canvas canvas, int width) {
        for (int i = 0; i < 6; i++) {
            canvas.restore();
            if (i == 0) {
                canvas.rotate(30, 0, 0);
            } else {
                canvas.rotate(60, 0, 0);
            }
            mPath.lineTo(0, width);
            canvas.drawPath(mPath, mPaint);
            canvas.save();
        }
    }

    /**
     * 绘制坐标顶点
     *
     * @param point 坐标顶点
     */
    private void drawPoint(Point point, Canvas canvas) {
        // 回滚到第二次保存状态
        canvas.restoreToCount(1);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        canvas.drawPoint(point.x, point.y, mPaint);
    }

    /**
     * 根据值计算旋转后的坐标顶点
     *
     * @param index 第几条边,起始边为1点钟方向那条边
     * @param value 待计算值
     * @return
     */
    private Point getRotatePoint(int index, int value) {
        int degrees = index * 60 + 30;
        double radians = Math.toRadians(degrees);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        int x = (int) (sin * value);
        int y = (int) (cos * value);
        Log.d("tag", "x:" + x + ",y:" + y);
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }
}
