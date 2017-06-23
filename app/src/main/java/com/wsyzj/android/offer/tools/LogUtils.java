package com.wsyzj.android.offer.tools;

/**
 * @name:
 * @author: wsyzj
 * @company: 曙华科技
 * @date: 2016-06-30 11:56
 * @comment: 打印日志的工具类
 */
public class LogUtils {
    /**
     * 日志输出级别NONE
     */

    public static final int LEVEL_NONE = 0;

    /**
     * 日志输出级别V
     */

    public static final int LEVEL_VERBOSE = 1;

    /**
     * 日志输出级别D
     */

    public static final int LEVEL_DEBUG = 2;

    /**
     * 日志输出级别I
     */

    public static final int LEVEL_INFO = 3;

    /**
     * 日志输出级别W
     */

    public static final int LEVEL_WARN = 4;

    /**
     * 日志输出级别E
     */

    public static final int LEVEL_ERROR = 5;

    /**
     * 日志输出时的TAG
     */

    private static String mTag = "哈哈";

    /**
     * 是否允许输出log
     */

    private static int mDebuggable = LEVEL_ERROR;

    /**
     * 用于记时的变量
     */

    private static long mTimestamp = 0;

    /**
     * 以级别为 d 的形式输出LOG
     */

    public static void v(String msg) {

        if (mDebuggable >= LEVEL_VERBOSE) {

            android.util.Log.v(mTag, msg);

        }

    }

    /**
     * 以级别为 d 的形式输出LOG
     */

    public static void d(String msg) {

        if (mDebuggable >= LEVEL_DEBUG) {

            android.util.Log.d(mTag, msg);

        }

    }

    /**
     * 以级别为 i 的形式输出LOG
     */

    public static void i(String msg) {

        if (mDebuggable >= LEVEL_INFO) {

            android.util.Log.i(mTag, msg);

        }

    }

    /**
     * 以级别为 w 的形式输出LOG
     */

    public static void w(String msg) {

        if (mDebuggable >= LEVEL_WARN) {

            android.util.Log.w(mTag, msg);

        }

    }

    /**
     * 以级别为 w 的形式输出Throwable
     */

    public static void w(Throwable tr) {

        if (mDebuggable >= LEVEL_WARN) {

            android.util.Log.w(mTag, "", tr);

        }

    }

    /**
     * 以级别为 w 的形式输出LOG信息和Throwable
     */

    public static void w(String msg, Throwable tr) {

        if (mDebuggable >= LEVEL_WARN && null != msg) {

            android.util.Log.w(mTag, msg, tr);

        }

    }

    /**
     * 以级别为 e 的形式输出LOG
     *
     * @param msg
     */

    public static void e(String msg) {

        if (mDebuggable >= LEVEL_ERROR) {

            android.util.Log.e(mTag, msg);

        }

    }

    /**
     * 以级别为 e 的形式输出Throwable
     */

    public static void e(Throwable tr) {

        if (mDebuggable >= LEVEL_ERROR) {

            android.util.Log.e(mTag, "", tr);

        }

    }

    /**
     * 以级别为 e 的形式输出LOG信息和Throwable
     */

    public static void e(String msg, Throwable tr) {

        if (mDebuggable >= LEVEL_ERROR && null != msg) {

            android.util.Log.e(mTag, msg, tr);

        }

    }

    /**
     * 以级别为 e 的形式输出msg信息,附带时间戳，用于输出一个时间段结束点* @param msg 需要输出的msg
     */

    public static void elapsed(String msg) {

        long currentTime = System.currentTimeMillis();

        long elapsedTime = currentTime - mTimestamp;

        mTimestamp = currentTime;

        e("[Elapsed：" + elapsedTime + "]" + msg);

    }

}
