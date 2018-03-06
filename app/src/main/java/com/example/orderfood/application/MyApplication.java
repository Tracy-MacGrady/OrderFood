package com.example.orderfood.application;

import android.app.Application;

import com.baseutillibrary.basetools.LogUtil;
import com.baseutillibrary.basetools.SQLiteDataBaseTool;
import com.example.orderfood.constant.Constants;
import com.example.orderfood.entity.UserInfo;
import com.example.orderfood.utils.ConfigUtil;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class MyApplication extends Application {
    private static MyApplication application;
    private UserInfo userInfo;

    public static MyApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        LogUtil.setLogEnable(true);
        initUserinfo();
        initDataBase();
    }

    private void initUserinfo() {
        userInfo = new UserInfo(
                ConfigUtil.getPropValue(Constants.CONFIG_USERNAME),
                ConfigUtil.getPropValue(Constants.CONFIG_PASSWORD),
                ConfigUtil.getPropValue(Constants.CONFIG_NAME),
                ConfigUtil.getPropValue(Constants.CONFIG_ADDRESS)
        );
    }

    private void initDataBase() {
        SQLiteDataBaseTool.getInstance().setInitDBHelper(this, Constants.DATABASE_NAME, Constants.DATABASE_VERSION);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
