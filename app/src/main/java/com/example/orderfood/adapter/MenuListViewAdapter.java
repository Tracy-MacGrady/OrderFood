package com.example.orderfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.orderfood.R;
import com.example.orderfood.entity.FoodMenuEntity;

import java.util.List;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class MenuListViewAdapter extends BaseAdapter {
    private Context context;
    private List<FoodMenuEntity> list;
    private ViewHolder holder;
    private int lastSelectedIndex = 0;

    public MenuListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_orderfood_menu_layout, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.initData(list.get(position));
        return convertView;
    }

    public void setList(List<FoodMenuEntity> list) {
        this.list = list;
        this.lastSelectedIndex = 0;
        this.list.get(lastSelectedIndex).setChoosed(true);
    }

    public List<FoodMenuEntity> getList() {
        return list;
    }

    class ViewHolder implements View.OnClickListener {
        private TextView textview;

        public ViewHolder(View view) {
            textview = (TextView) view.findViewById(R.id.textview);
            textview.setOnClickListener(this);
            view.setTag(this);
        }

        public void initData(FoodMenuEntity entity) {
            if (entity == null) return;
            textview.setTag(entity);
            textview.setSelected(entity.isChoosed());
            textview.setText(entity.getName());
        }

        @Override
        public void onClick(View v) {
            if (v.getTag() == null) return;
            if (v.getId() == R.id.textview) {
                try {
                    FoodMenuEntity entity = (FoodMenuEntity) v.getTag();
                    if (entity == null) return;
                    int nowClickIndex = list.indexOf(entity);
                    if (nowClickIndex == lastSelectedIndex) return;
                    list.get(lastSelectedIndex).setChoosed(false);
                    entity.setChoosed(true);
                    lastSelectedIndex = nowClickIndex;
                    notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
