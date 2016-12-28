package com.example.hoont.sosuproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class StockAddActivity extends AppCompatActivity {

    private ListView listview;
    private CustomAdapter customAdapter;
    private List<Sell_items> sell_itemsList=new ArrayList<>();

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_add);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        listview=(ListView)findViewById(R.id.item_datas);
        CustomAdapter adapter =new CustomAdapter(getSell());

        listview.setAdapter(adapter);

        //리스트뷰 클릭
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                RealmResults<Sell_items> all = realm.where(Sell_items.class).findAll();
//                Sell_items sell_items=all.get(position);
//
//                realm.beginTransaction();
//                sell_items.deleteFromRealm();
//                realm.commitTransaction();

                customAdapter = new CustomAdapter(getSell());
                listview.setAdapter(customAdapter);
            }
        });
    }

    private List<Sell_items> getSell() {

        RealmResults<Sell_items> all =realm.where(Sell_items.class).findAll();
        sell_itemsList = new ArrayList<>();
        for(int i=0; i<all.size();i++){
            sell_itemsList.add(all.get(i));
        }
        return sell_itemsList;
    }
}
