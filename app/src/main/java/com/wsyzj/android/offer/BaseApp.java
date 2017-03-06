package com.wsyzj.android.offer;

import android.app.Application;

/**
 * @author: wsyzj
 * @date: 2017-03-06 14:45
 * @comment: 应用程序的入口
 */
public class BaseApp extends Application {

    private static BaseApp baseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    public static BaseApp getBaseApp() {
        return baseApp;
    }
}
