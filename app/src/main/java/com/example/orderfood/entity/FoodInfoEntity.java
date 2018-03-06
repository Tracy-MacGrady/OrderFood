package com.example.orderfood.entity;

import com.baseutillibrary.baseentity.BaseDataBaseEntity;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class FoodInfoEntity extends BaseDataBaseEntity {
    private int type;
    private String name;
    private String path;
    private int hasNum;
    private int chooseNum;


    public FoodInfoEntity(int type, String name, String path, int hasNum, int chooseNum) {
        this.type = type;
        this.name = name;
        this.path = path;
        this.hasNum = hasNum;
        this.chooseNum = chooseNum;
    }

    public FoodInfoEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getHasNum() {
        return hasNum;
    }

    public void setHasNum(int hasNum) {
        this.hasNum = hasNum;
    }

    public int getChooseNum() {
        return chooseNum;
    }

    public void setChooseNum(int chooseNum) {
        this.chooseNum = chooseNum;
    }
}
