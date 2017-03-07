/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Raphaël Bussa - Fingerlinks
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
