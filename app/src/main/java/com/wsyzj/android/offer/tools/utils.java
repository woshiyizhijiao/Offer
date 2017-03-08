package com.wsyzj.android.offer.tools;

import android.os.Environment;

/**
 * @author: wsyzj
 * @date: 2017-03-08 13:36
 * @comment: 一些常用的工具类
 */
public class utils {
    /**
     * 是否有sd卡
     *
     * @return
     */
    public static boolean isSdCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
