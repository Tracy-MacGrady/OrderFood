package com.example.orderfood.constant;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class Constants {
    public static final String DATABASE_NAME = "ORDERFOOD";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE_FOOD_NAME = "FOODINFO";
    public static final String DATABASE_TABLE_FOOD_MENU_NAME = "FOODINFO";
    public static final String SELECT_FOOD_SQL = "select * from " + Constants.DATABASE_TABLE_FOOD_NAME + " where type=?";
    public static final String SELECT_FOOD_MENU_SQL = "select * from " + Constants.DATABASE_TABLE_FOOD_MENU_NAME;
    public static final String CONFIG_USERNAME = "username";
    public static final String CONFIG_PASSWORD = "password";
    public static final String CONFIG_NAME = "name";
    public static final String CONFIG_ADDRESS = "address";
}
