package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @name: ScrollGridView
 * @author: wsyzj
 * @company: 曙华科技
 * @date: 2016-11-16 15:21
 * @comment: 多个滑动控件嵌套时使用
 */
public class ScrollGridView extends GridView {

    public ScrollGridView(Context context) {
        super(context);
    }

    public ScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
