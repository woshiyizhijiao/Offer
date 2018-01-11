package com.wsyzj.android.offer.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.RedPacketRain;
import com.wsyzj.android.offer.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 焦洋
 * @date 2018/1/9 14:05
 * @Description: $desc$
 */
public class RedPacketRainView extends View {

    private int mSpeed;     // 红包下落速度
    private int mHeight;    // 控件高度
    private Paint mPaint;   // bitmap的画笔
    private ValueAnimator mRedPacketAnim;   // 红包执行的动画
    private List<RedPacketRain> mRedPacketData = new ArrayList<>();     // 保存红包的数据

    public RedPacketRainView(Context context) {
        super(context);
        init();
    }

    public RedPacketRainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        init();

    }

    public RedPacketRainView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);      // 是否抗锯齿
        mPaint.setDither(true);         // 设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        mPaint.setFilterBitmap(true);   // 如果该项设置为true，则图像在动画进行中会滤掉对Bitmap图像的优化操作 ,加快显示速度，本设置项依赖于dither和xfermode的设置
        // 在图形下面设置阴影层，产生阴影效果，radius为阴影的角度，dx和dy为阴影在x轴和y轴上的距离，color为阴影的颜色
        // 注意：在Android4.0以上默认开启硬件加速，有些图形的阴影无法显示。关闭View的硬件加
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
        initRedPacketAnim();
    }

    /**
     * 获取在xml中的属性
     *
     * @param attrs
     */
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RedPacketRainView);
        mSpeed = typedArray.getInt(R.styleable.RedPacketRainView_red_packet_speed, 20);
        typedArray.recycle();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight = getMeasuredHeight();
    }

    /**
     * 设置红包的数据
     *
     * @param redPacketData
     */
    public void setRedPacketData(List<RedPacketRain> redPacketData) {
        mRedPacketData = redPacketData;
    }

    /**
     * 初始化红包的动画并进行监听
     */
    private void initRedPacketAnim() {
        mRedPacketAnim = ValueAnimator.ofFloat(0, 10);
        mRedPacketAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                for (int i = 0; i < mRedPacketData.size(); i++) {
                    RedPacketRain redPacketRain = mRedPacketData.get(i);
                    if (redPacketRain.y > mHeight) {
                        redPacketRain.y = -redPacketRain.bitmap.getHeight();
                    } else {
                        redPacketRain.y += 10 * redPacketRain.speed;
                    }
                    redPacketRain.rotate += 1;
                }
                invalidate();
            }
        });
        mRedPacketAnim.setInterpolator(new DecelerateInterpolator());
        mRedPacketAnim.setRepeatCount(ValueAnimator.INFINITE);
        mRedPacketAnim.setDuration(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < mRedPacketData.size(); i++) {
            RedPacketRain redPacket = mRedPacketData.get(i);
            int width = redPacket.bitmap.getWidth();
            int height = redPacket.bitmap.getHeight();

            Matrix matrix = new Matrix();
            matrix.setTranslate(-width / 2, -height / 2);
            matrix.postRotate(redPacket.rotate);
            matrix.postTranslate(width / 2 + redPacket.x, height / 2 + redPacket.y);
            canvas.drawBitmap(redPacket.bitmap, matrix, mPaint);
        }
    }

    /**
     * 开始撒红包
     */
    public void start() {
        mRedPacketAnim.start();
    }

    /**
     * 停止撒红包
     */
    public void stop() {
        mRedPacketAnim.cancel();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                RedPacketRain clickRedPacket = getClickRedPacket(event.getX(), event.getY());
                if (clickRedPacket != null) {
                    ToastUtils.showToast("金额是 : " + clickRedPacket.money);
                    clickRedPacket.y = -clickRedPacket.bitmap.getHeight();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 获取被点击的那个红包
     */
    private RedPacketRain getClickRedPacket(float x, float y) {
        for (int i = 0; i < mRedPacketData.size(); i++) {
            RedPacketRain redPacketRain = mRedPacketData.get(i);
            if (redPacketRain.isContains(x, y)) {
                return redPacketRain;
            }
        }
        return null;
    }
}
