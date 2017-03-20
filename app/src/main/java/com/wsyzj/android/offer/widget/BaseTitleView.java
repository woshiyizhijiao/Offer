package com.wsyzj.android.offer.widget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.tools.UIUtils;

/**
 * @author: wsyzj
 * @date: 2017-03-18 10:38
 * @comment: 统一的标题布局
 */
public class BaseTitleView extends LinearLayout {

    private Context mContext;

    private View base_layout;
    private ImageView base_back;
    private TextView base_title;

    public BaseTitleView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        setOrientation(LinearLayout.VERTICAL);
        base_layout = UIUtils.inflate(R.layout.widget_base_title_view);
        base_back = (ImageView) base_layout.findViewById(R.id.base_back);
        base_title = (TextView) base_layout.findViewById(R.id.base_title);
        addView(base_layout);

        base_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext instanceof Activity) {
                    ((Activity) mContext).finish();     // 通知处理返回键
                }
            }
        });
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        base_title.setText(title);
    }
}
