package org.fingerlinks.mobile.android.support.base;

import android.util.Log;

/**
 * Created by raphaelbussa on 07/03/16.
 */
public class LogHelper {

    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;

    private static LogHelper instance;
    private boolean showLog = true;

    private String TAG;

    public static LogHelper with(Class clazz) {
        if (instance == null) {
            instance = new LogHelper();
        }
        instance.init(clazz);
        return instance;
    }

    public static void showLog(boolean showLog) {
        if (instance == null) {
            instance = new LogHelper();
        }
        instance.showLog = showLog;
    }

    public static boolean isShowLog() {
        if (instance == null) {
            instance = new LogHelper();
        }
        return instance.showLog;
    }

    private void init(Class clazz) {
        this.TAG = clazz.getName();
    }

    public void v(String msg, Throwable tr) {
        if (showLog) Log.v(TAG, msg, tr);
    }

    public void v(String msg) {
        if (showLog) Log.v(TAG, msg);
    }

    public void d(String msg) {
        if (showLog) Log.d(TAG, msg);
    }

    public void d(String msg, Throwable tr) {
        if (showLog) Log.d(TAG, msg, tr);
    }

    public void i(String msg) {
        if (showLog) Log.i(TAG, msg);
    }

    public void i(String msg, Throwable tr) {
        if (showLog) Log.i(TAG, msg, tr);
    }

    public void w(String msg) {
        if (showLog) Log.w(TAG, msg);
    }

    public void w(String msg, Throwable tr) {
        if (showLog) Log.w(TAG, msg, tr);
    }

    public void w(Throwable tr) {
        if (showLog) Log.w(TAG, tr);
    }

    public void e(String msg) {
        if (showLog) Log.e(TAG, msg);
    }

    public void e(String msg, Throwable tr) {
        if (showLog) Log.e(TAG, msg, tr);
    }

}
