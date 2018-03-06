package com.example.orderfood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.R;
import com.example.orderfood.entity.FoodInfoEntity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<FoodInfoEntity> list;

    public FoodRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_orderfood_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setList(List<FoodInfoEntity> list) {
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView foodImgView;
        private TextView foodNameView;
        private TextView foodTipNumView;
        private View addFoodView;

        public MyViewHolder(View itemView) {
            super(itemView);
            foodImgView = (ImageView) itemView.findViewById(R.id.imageview);
            foodNameView = (TextView) itemView.findViewById(R.id.textview);
            foodTipNumView = (TextView) itemView.findViewById(R.id.num_tip_view);
            addFoodView = itemView.findViewById(R.id.add_to_car_view);
            addFoodView.setOnClickListener(this);
        }

        public void initData(FoodInfoEntity entity) {
            if (entity == null) return;
            foodNameView.setText(entity.getName());
            addFoodView.setTag(entity);
//            entity.get
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add_to_car_view:

                    break;
            }
        }
    }
}
