package com.baseutillibrary.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by 李健健 on 2017/8/28.
 */

public class ActivityManagerUtil {
    private Stack<Activity> activities;
    private static volatile ActivityManagerUtil activityManagerUtil;

    public static ActivityManagerUtil getInstance() {
        if (activityManagerUtil == null) synchronized (ActivityManagerUtil.class) {
            if (activityManagerUtil == null) activityManagerUtil = new ActivityManagerUtil();
        }
        return activityManagerUtil;
    }

    public void addToStack(Activity activity) {
        if (activity == null) return;
        if (activities == null) activities = new Stack<>();
        activities.push(activity);
    }

    public void removeFromStack(Activity activity) {
        if (activities == null || activity == null) return;
        activities.remove(activity);
    }

    public Activity getTopAndRemoveFromStack() {
        if (activities != null) {
            return activities.pop();
        }
        return null;
    }

    public void closeAllActivity() {
        if (activities == null) return;
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = getTopAndRemoveFromStack();
            if (activity != null) activity.finish();
        }
    }
}
