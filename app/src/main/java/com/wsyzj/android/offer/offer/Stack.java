package com.wsyzj.android.offer.offer;

/**
 * @author: wsyzj
 * @date: 2017-07-31 11:12
 * @comment: //TODO
 */
public class Stack {
    private int[] data;
    private int maxSize;
    public int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        top = -1;
    }

    /**
     * 依次加入数据
     *
     * @param data 要加入的数据
     * @return 添加是否成功
     */
    public boolean push(int data) {
        if (top + 1 == maxSize) {
            System.out.println("栈已满");
            return false;
        }
        this.data[++top] = data;
        return true;
    }

    /**
     * 从栈中取出数据
     *
     * @return 取出的数据
     */
    public int pop() throws Exception {
        if (top == -1) {
            throw new Exception("栈已满");
        }
        return this.data[top--];
    }
}
