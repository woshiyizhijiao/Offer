package com.wsyzj.android.offer.offer;

/**
 * @author: wsyzj
 * @date: 2017-03-06 12:17
 * @comment: 单利设计模式: 懒汉式
 */
public class Singleton2 {

    // 声明变量
    private static Singleton2 instance;

    // 私有构造方法
    private Singleton2() {

    }

    // 提供对外方法
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
