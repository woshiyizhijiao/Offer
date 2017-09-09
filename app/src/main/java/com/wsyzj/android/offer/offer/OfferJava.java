package com.wsyzj.android.offer.offer;

/**
 * @author: wsyzj
 * @date: 2017-03-01 22:35
 * @comment: 面试时java知识
 */
public class OfferJava {

    public static void main(String[] array) throws Exception {
        /**
         * 使用java代码编写堆栈
         */
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        while (stack.top >= 0) {
            System.out.println(stack.pop());
        }
    }
}
