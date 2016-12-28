package com.example.hoont.sosuproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hoont on 2016-12-27.
 */

public class CustomAdapter extends BaseAdapter{

    private List<Sell_items> sell_itemsList;

    public CustomAdapter(List<Sell_items> sell) {
        this.sell_itemsList = sell;
    }

    @Override
    public int getCount() {
        return sell_itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return sell_itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_humanbeing,null);

        ImageView imageView = (ImageView)view.findViewById(R.id.image_item);
        TextView textView_name = (TextView)view.findViewById(R.id.name_item);
        TextView textView_price = (TextView)view.findViewById(R.id.price_item);

        Sell_items sell_items = sell_itemsList.get(position);

        String name = sell_items.getName();
        String price = sell_items.getPrice();

        String image = sell_items.getImage();

        textView_name.setText(name);
        textView_price.setText(price);
        Glide.with(parent.getContext()).load(image).into(imageView);


        return view;
    }
}
