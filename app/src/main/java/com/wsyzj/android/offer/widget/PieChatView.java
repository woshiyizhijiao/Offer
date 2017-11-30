package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wsyzj.android.offer.bean.PieChat;

import java.util.List;

/**
 * @author 焦洋
 * @date 2017/11/30 11:24
 */
public class PieChatView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private RectF mRectF;

    private List<PieChat> mPieChats;

    public PieChatView(Context context) {
        super(context);
        init();
    }

    public PieChatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieChatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);

        mRectF = new RectF();
    }

    /**
     * 设置饼状图的数据
     *
     * @param pieChats
     */
    public void setPieChats(List<PieChat> pieChats) {
        mPieChats = pieChats;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPieChats == null) {
            return;
        }

        int currentStartAngle = 0;

        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);
        mRectF.set(-r, -r, r, r);       // 宽和高小的值*0.8作为半径

        canvas.translate(mWidth / 2, mHeight / 2);      // 将原点移至控件中心位置

        for (int i = 0; i < mPieChats.size(); i++) {
            PieChat pieChat = mPieChats.get(i);
            float radian = pieChat.getRadian();
            int color = pieChat.color;
            mPaint.setColor(color);
            canvas.drawArc(mRectF, currentStartAngle, radian, true, mPaint);
            currentStartAngle += radian;
        }
    }
}
