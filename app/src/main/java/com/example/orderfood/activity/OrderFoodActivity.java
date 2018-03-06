package com.example.orderfood.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.baseutillibrary.base.BaseActivity;
import com.baseutillibrary.basetools.SQLiteDataBaseTool;
import com.example.orderfood.R;
import com.example.orderfood.adapter.FoodRecyclerViewAdapter;
import com.example.orderfood.adapter.MenuListViewAdapter;
import com.example.orderfood.adapter.OrderRecyclerViewAdapter;
import com.example.orderfood.constant.Constants;
import com.example.orderfood.entity.FoodInfoEntity;
import com.example.orderfood.entity.FoodMenuEntity;

import java.util.List;

public class OrderFoodActivity extends BaseActivity implements View.OnClickListener {
    private View returnHomeView;
    private TextView orderMoneyView;
    private View placeOrderView, chooseTasteView;
    private ListView menuListView;
    private RecyclerView foodRecyclerView, orderRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private FoodRecyclerViewAdapter foodAdapter;
    private MenuListViewAdapter menuAdapter;
    private OrderRecyclerViewAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        setListener();
        initData();
    }

    private void initData() {
        menuAdapter.setList(SQLiteDataBaseTool.getInstance().select_Data(Constants.SELECT_FOOD_MENU_SQL, null, new FoodMenuEntity()));
        if (menuAdapter.getList() != null && menuAdapter.getList().size() > 0) {
            List<FoodInfoEntity> list = SQLiteDataBaseTool.getInstance().select_Data(Constants.SELECT_FOOD_SQL, new String[]{menuAdapter.getList().get(0).getType() + ""}, new FoodInfoEntity());
            foodAdapter.setList(list);
        }
    }

    private void setListener() {
        returnHomeView.setOnClickListener(this);
        placeOrderView.setOnClickListener(this);
        chooseTasteView.setOnClickListener(this);
    }

    private void initView() {
        returnHomeView = findViewById(R.id.returnhome_textview);
        orderMoneyView = (TextView) findViewById(R.id.order_money);
        placeOrderView = findViewById(R.id.place_order_button);
        chooseTasteView = findViewById(R.id.choose_taste);
        menuListView = (ListView) findViewById(R.id.menu_listview);
        foodRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        orderRecyclerView = (RecyclerView) findViewById(R.id.orderfood_recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 3);
        foodAdapter = new FoodRecyclerViewAdapter(this);
        menuAdapter = new MenuListViewAdapter(this);
        orderAdapter = new OrderRecyclerViewAdapter(this);
        menuListView.setAdapter(menuAdapter);
        foodRecyclerView.setLayoutManager(gridLayoutManager);
        foodRecyclerView.setAdapter(foodAdapter);
        orderRecyclerView.setLayoutManager(linearLayoutManager);
        orderRecyclerView.setAdapter(orderAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.returnhome_textview:
                finish();
                break;
            case R.id.choose_taste:

                break;
            case R.id.place_order_button:

                break;
        }
    }
}
