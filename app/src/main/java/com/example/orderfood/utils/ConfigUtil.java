package com.example.orderfood.utils;

import com.example.orderfood.application.MyApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PropertyResourceBundle;

/**
 * Created by 李健健 on 2016/12/22.
 */
public class ConfigUtil {
    private static PropertyResourceBundle prb;

    /**
     * 加载配置文件信息
     */
    private static void loadProperties() {
        String propFileName = "config.properties";
        BufferedReader reader = null;
        try {
            InputStream inputStream = MyApplication.getInstance().getAssets().open(propFileName);
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            prb = new PropertyResourceBundle(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * 根据KEY 获取Value
     *
     * @param key
     * @return
     */
    public static String getPropValue(String key) {
        if (prb == null) loadProperties();
        String value = prb.getString(key);
        return value;
    }
}
