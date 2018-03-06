package com.example.orderfood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.baseutillibrary.base.BaseActivity;
import com.baseutillibrary.baseentity.BaseDataBaseEntity;
import com.baseutillibrary.basetools.LogUtil;
import com.baseutillibrary.basetools.SQLiteDataBaseTool;
import com.example.orderfood.R;
import com.example.orderfood.constant.Constants;
import com.example.orderfood.entity.FoodMenuEntity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDataBaseTool.getInstance().setDbHelperInitTable(Constants.DATABASE_TABLE_FOOD_MENU_NAME, FoodMenuEntity.class);
        List<BaseDataBaseEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new FoodMenuEntity(i % 3, "测试" + i, false));
        }
        SQLiteDataBaseTool.getInstance().insert_Data(Constants.DATABASE_TABLE_FOOD_MENU_NAME, list);
        findViewById(R.id.orderfood_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.orderfood_view:
                startActivity(new Intent(this, OrderFoodActivity.class));
                finish();
                break;
        }
    }
}
