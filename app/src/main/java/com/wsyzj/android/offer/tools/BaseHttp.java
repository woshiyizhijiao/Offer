package com.wsyzj.android.offer.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wsyzj.android.offer.BaseApp;

/**
 * 网络请求相关
 *
 * @author Administrator
 */
public class BaseHttp {

    /**
     * 加载普通图片
     *
     * @param context
     * @param url
     * @param placeholder
     * @param imageView
     */
    public static void with(Context context, String url, int placeholder, ImageView imageView) {
        Glide.with(BaseApp.getBaseApp()).load(url).placeholder(placeholder).into(imageView);
    }

    /**
     * 加载圆形图片需要做的处理
     *
     * @param context
     * @param url
     * @param placeholder
     * @param imageView
     */
    public static void withHead(Context context, String url, int placeholder, ImageView imageView) {
        Glide.with(BaseApp.getBaseApp()).load(url).dontAnimate().placeholder(placeholder).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }

}
