package com.wsyzj.android.offer.offer;

/**
 * @author: wsyzj
 * @date: 2017-03-06 12:14
 * @comment: 单利设计模式:饿汉式
 */
public class Singleton1 {
    // 直接创建对象
    private static Singleton1 instance = new Singleton1();

    // 私有构造方法
    private Singleton1() {

    }

    // 返回对象实例
    public static Singleton1 getInstance() {
        return instance;
    }
}
