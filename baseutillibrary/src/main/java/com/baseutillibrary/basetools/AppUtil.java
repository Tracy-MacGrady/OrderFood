package com.baseutillibrary.basetools;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;

import com.baseutillibrary.BuildConfig;

/**
 * Created by 李健健 on 2017/8/28.
 */

public class AppUtil {
    /**
     * 获取版本编号
     *
     * @return
     */
    public static String getVersionName(Application application) {
        if (application == null) return BuildConfig.VERSION_NAME;
        PackageInfo info = null;
        String versionName = "";
        try {
            PackageManager manager = application.getPackageManager();
            info = manager.getPackageInfo(application.getPackageName(), 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static int getApiLevel() {
        int level = Integer.valueOf(Build.VERSION.SDK);
        return level;
    }

    public static void exitApp(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(intent);
    }

    /**
     * 打开软键盘
     *
     * @param activity
     */
    public static void openKeyboard(Activity activity) {
        if (activity == null) return;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 关闭软键盘
     *
     * @param activity
     */
    public static void hiddenKeyboard(Activity activity) {
        if (activity == null) return;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        try {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
