package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * @author: wsyzj
 * @date: 2017-04-02 18:21
 * @comment: 登录界面带视频播放的view需要重测宽高，否则显示不了全屏
 */
public class LoginVideoView extends VideoView {

    public LoginVideoView(Context context) {
        super(context);
    }

    public LoginVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
