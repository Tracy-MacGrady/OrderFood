package com.baseutillibrary.basetools;

import android.util.Log;

public class LogUtil {
    private static final String TAG = "LogUtil========";
    public static boolean logEnable = true;

    public static void setLogEnable(boolean logEnable1) {
        logEnable = logEnable1;
    }

    public static void v(String val) {
        if (logEnable) {
            Log.v(TAG, val);
        }
    }

    public static void d(String val) {
        if (logEnable) {
            Log.d(TAG, val);
        }
    }

    public static void i(String val) {
        if (logEnable) {
            Log.i(TAG, val);
        }
    }

    public static void w(String val) {
        if (logEnable) {
            Log.w(TAG, val);
        }
    }

    public static void e(String val) {
        if (logEnable) {
            Log.e(TAG, val);
        }
    }

    public static void v(String tag, String val) {
        if (logEnable) {
            Log.v(tag, val);
        }
    }

    public static void d(String tag, String val) {
        if (logEnable) {
            Log.d(tag, val);
        }
    }

    public static void i(String tag, String val) {
        if (logEnable) {
            Log.i(tag, val);
        }
    }

    public static void w(String tag, String val) {
        if (logEnable) {
            Log.w(tag, val);
        }
    }

    public static void e(String tag, String val) {
        if (logEnable) {
            Log.e(tag, val);
        }
    }
}
