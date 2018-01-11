package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.wsyzj.android.offer.bean.SaRedPacket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 焦洋
 * @date 2018/1/11 11:47
 * @Description: $desc$
 */
public class SaRedPacketView extends View {

    private Paint mPaint;
    private int mHeight;
    private boolean isStart;
    private int addRegion;
    private List<SaRedPacket> mRedPacketData = new ArrayList<>();
    private Matrix matrix = new Matrix();

    public SaRedPacketView(Context context) {
        super(context, null);

    }

    public SaRedPacketView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SaRedPacketView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setFilterBitmap(true);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

    public void setRedPacketData(List<SaRedPacket> redPacketData) {
        this.mRedPacketData = redPacketData;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isStart) {
            for (int i = 0; i < mRedPacketData.size(); i++) {
                SaRedPacket redPacket = mRedPacketData.get(i);

                if (redPacket.y > mHeight) {
                    redPacket.x = redPacket.getX();
                    redPacket.y = redPacket.getY();
                } else {
                    redPacket.y += redPacket.speed;
                    redPacket.rotate += 1;
                }

                matrix.reset();
                matrix.postTranslate(-redPacket.dWidth / 2, -redPacket.dHeight / 2);
                matrix.postRotate(redPacket.rotate);
                matrix.postTranslate(redPacket.dWidth / 2 + redPacket.x, redPacket.dHeight / 2 + redPacket.y);
                canvas.drawBitmap(redPacket.bitmap, matrix, mPaint);
            }
            invalidate();
        } else {
            for (int i = 0; i < mRedPacketData.size(); i++) {
                SaRedPacket redPacket = mRedPacketData.get(i);

                matrix.reset();
                matrix.postTranslate(-redPacket.dWidth / 2, -redPacket.dHeight / 2);
                matrix.postRotate(redPacket.rotate);
                matrix.postTranslate(redPacket.dWidth / 2 + redPacket.x, redPacket.dHeight / 2 + redPacket.y);
                canvas.drawBitmap(redPacket.bitmap, matrix, mPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                SaRedPacket redPacket = checkedRedPacket(event.getX(), event.getY());
                if (redPacket != null && isStart) {
                    redPacket.x = redPacket.getX();
                    redPacket.y = redPacket.getY();
                }
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 是否点击中红包
     *
     * @return
     */
    private SaRedPacket checkedRedPacket(float mX, float mY) {
        for (int i = mRedPacketData.size() - 1; i >= 0; i--) {
            SaRedPacket redPacket = mRedPacketData.get(i);
            if (isCheckRedPacket(redPacket, mX, mY)) {
                return redPacket;
            }
        }
        return null;
    }

    /**
     * 计算
     *
     * @param saRedPacket
     * @param mX
     * @param mY
     * @return
     */
    private boolean isCheckRedPacket(SaRedPacket saRedPacket, float mX, float mY) {
        return saRedPacket.x - addRegion < mX && saRedPacket.x + addRegion + saRedPacket.dWidth > mX
                && saRedPacket.y - addRegion < mY && saRedPacket.y + addRegion + saRedPacket.dWidth > mY;
    }

    /**
     * 开始撒红包
     */
    public void start() {
        if (!isStart) {
            isStart = true;
            invalidate();
        }
    }

    /**
     * 停止
     */
    public void stop() {
        if (isStart) {
            isStart = false;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isStart) {
            isStart = false;
        }
    }
}
