package com.example.orderfood.entity;

import com.baseutillibrary.baseentity.BaseDataBaseEntity;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class FoodMenuEntity extends BaseDataBaseEntity {
    private int type;
    private String name;
    private boolean isChoosed = false;

    public FoodMenuEntity(int type, String name, boolean isChoosed) {
        this.type = type;
        this.name = name;
        this.isChoosed = isChoosed;
    }

    public FoodMenuEntity() {

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }
}
