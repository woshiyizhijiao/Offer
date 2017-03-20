package com.wsyzj.android.offer.tools;

import android.view.View;

import com.wsyzj.android.offer.BaseApp;

/**
 * @author: wsyzj
 * @date: 2017-03-06 14:45
 * @comment: Ui工具类
 */
public class UIUtils {

    /**
     * @param colorId
     * @return 返回颜色值
     */
    public static int getColor(int colorId) {
        return BaseApp.getBaseApp().getResources().getColor(colorId);
    }

    /**
     * @param resource
     * @return 获取一个试图
     */
    public static View inflate(int resource) {
        return View.inflate(BaseApp.getBaseApp(), resource, null);
    }
}
