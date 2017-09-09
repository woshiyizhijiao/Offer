package com.wsyzj.android.offer.offer;

/**
 * @author: wsyzj
 * @date: 2017-08-27 16:07
 * @comment: 从结果中可以看出，在执行到other.action（）时，由于两个线程都在试图获取对方的锁，
 * 但对方都没有释放自己的锁，因而便产生了死锁，在主线程中试图中断两个线程，但都无果。大部分代
 * 码并不容易产生死锁，死锁可能在代码中隐藏相当长的时间，等待不常见的条件地发生，但即使是很小的
 * 概率，一旦发生，便可能造成毁灭性的破坏。避免死锁是一件困难的事，遵循以下原则有助于规避死锁：
 * 只在必要的最短时间内持有锁，考虑使用同步语句块代替整个同步方法；尽量编写不在同一时刻需要持有
 * 多个锁的代码，如果不可避免，则确保线程持有第二个锁的时间尽量短暂；创建和使用一个大锁来代替若
 * 干小锁，并把这个锁用于互斥，而不是用作单个对象的对象级别锁；
 */
public class Deadlock {

    private String objID;

    public Deadlock(String id) {
        objID = id;
    }

    public synchronized void checkOther(Deadlock other) {
        print("entering checkOther()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException x) {
        }
        print("in checkOther() - about to " + "invoke 'other.action()'");
        //调用other对象的action方法，由于该方法是同步方法，因此会试图获取other对象的对象锁
        other.action();
        print("leaving checkOther()");
    }

    public synchronized void action() {
        print("entering action()");
        try {
            Thread.sleep(500);
        } catch (InterruptedException x) {
        }
        print("leaving action()");
    }

    public void print(String msg) {
        threadPrint("objID=" + objID + " - " + msg);
    }

    public static void threadPrint(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + msg);
    }

    public static void main(String[] args) {
        final Deadlock obj1 = new Deadlock("obj1");
        final Deadlock obj2 = new Deadlock("obj2");

        Runnable runA = new Runnable() {
            public void run() {
                obj1.checkOther(obj2);
            }
        };

        Thread threadA = new Thread(runA, "threadA");
        threadA.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException x) {
        }

        Runnable runB = new Runnable() {
            public void run() {
                obj2.checkOther(obj1);
            }
        };

        Thread threadB = new Thread(runB, "threadB");
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException x) {
        }

        threadPrint("finished sleeping");

        threadPrint("about to interrupt() threadA");

        threadA.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException x) {
        }

        threadPrint("about to interrupt() threadB");
        threadB.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException x) {
        }

        threadPrint("did that break the deadlock?");
    }
}
