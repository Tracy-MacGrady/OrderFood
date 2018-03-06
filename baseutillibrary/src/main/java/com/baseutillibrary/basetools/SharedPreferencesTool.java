package com.baseutillibrary.basetools;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.Set;

/**
 * Created by 李健健 on 2016/11/15.
 */
public class SharedPreferencesTool {
    public static final String ALL_SP_FILENAME = "SharePreferenceTool";//存储未定义文件名的sp数据

    /**
     * 获取String类型的数据
     *
     * @param context
     * @param spKey
     * @param spFileName
     * @return
     */
    public static String getStringVal(Context context, String spKey, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return "";
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sp.getString(spKey, "");
    }

    /**
     * 获取int类型的数据
     *
     * @param context
     * @param spKey
     * @param spFileName
     * @return 返回結果為-10001表示錯誤碼
     */
    public static int getIntVal(Context context, String spKey, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return -10001;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sp.getInt(spKey, -10001);
    }

    /**
     * 获取float类型的数据
     *
     * @param context
     * @param spKey
     * @param spFileName
     * @return 返回結果為-10001表示錯誤碼
     */
    public static float getFloatVal(Context context, String spKey, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return -10001;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sp.getFloat(spKey, -10001);
    }

    /**
     * 获取long类型的数据
     *
     * @param context
     * @param spKey
     * @param spFileName
     * @return 返回結果為-10001表示錯誤碼
     */
    public static long getLongVal(Context context, String spKey, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return -10001;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sp.getLong(spKey, -10001);
    }

    /**
     * 获取boolean类型的数据
     *
     * @param context
     * @param spKey
     * @param spFileName
     * @return
     */
    public static boolean getBooleanVal(Context context, String spKey, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return false;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sp.getBoolean(spKey, false);
    }

    /**
     * 获取Set<String>类型的数据
     *
     * @param context
     * @param spKey
     * @param spFileName
     * @return
     */
    public static Set<String> getStringSetVal(Context context, String spKey, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return null;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sp.getStringSet(spKey, null);
    }

    /**
     * 存储string类型的数据
     *
     * @param context
     * @param spKey
     * @param spSaveValue
     * @param spFileName
     */
    public static boolean saveStringVal(Context context, String spKey, String spSaveValue, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName) || spSaveValue == null || spSaveValue.isEmpty()) {
            return false;
        }
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(spKey, spSaveValue);
        return editor.commit();
    }

    /**
     * 存储int类型的数据
     *
     * @param context
     * @param spKey
     * @param spSaveValue
     * @param spFileName
     */
    public static boolean saveIntVal(Context context, String spKey, int spSaveValue, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return false;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(spKey, spSaveValue);
        return editor.commit();
    }

    /**
     * 存储float类型的数据
     *
     * @param context
     * @param spKey
     * @param spSaveValue
     * @param spFileName
     */
    public static boolean saveFolatVal(Context context, String spKey, float spSaveValue, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return false;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(spKey, spSaveValue);
        return editor.commit();
    }

    /**
     * 存储long类型的数据
     *
     * @param context
     * @param spKey
     * @param spSaveValue
     * @param spFileName
     */
    public static boolean saveLongVal(Context context, String spKey, long spSaveValue, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return false;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(spKey, spSaveValue);
        return editor.commit();
    }

    /**
     * 存储boolean类型的数据
     *
     * @param context
     * @param spKey
     * @param spSaveValue
     * @param spFileName
     */
    public static boolean saveBooleanVal(Context context, String spKey, boolean spSaveValue, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName)) return false;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(spKey, spSaveValue);
        return editor.commit();
    }

    /**
     * 存储boolean类型的数据
     *
     * @param context
     * @param spKey
     * @param spSaveValue
     * @param spFileName
     */
    public static boolean saveStringSetVal(Context context, String spKey, Set<String> spSaveValue, String spFileName) {
        if (checkKeyFileNameIsNull(context, spKey, spFileName) || spSaveValue == null) return false;
        SharedPreferences sp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet(spKey, spSaveValue);
        return editor.commit();
    }

    /**
     * 检测spKey跟spFileName是否为空
     *
     * @param spKey
     * @param spFileName
     * @return
     */
    private static boolean checkKeyFileNameIsNull(Context context, String spKey, String spFileName) {
        if (spKey == null || spKey.isEmpty() || spFileName == null || spFileName.isEmpty()) {
            Toast.makeText(context, "spKey或者spFileName为空", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public static SharedPreferences.Editor getEditor(Context context, String allSpFilename) {
        SharedPreferences sp = context.getSharedPreferences(allSpFilename, Context.MODE_PRIVATE);
        return sp.edit();
    }
}
