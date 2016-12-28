package com.example.hoont.sosuproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class StockActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText_name, editText_price,editText_image;
    Button button;

    private ListView listview;
    private CustomAdapter customAdapter;
    private List<Sell_items> sell_itemsList=new ArrayList<>();

    private String name;
    private String price;
    private String image;

    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        //데이터베이스 낼름 초기화
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        setDefault();
    } private void setDefault() {

        //변수 선언
        editText_name=(EditText)findViewById(R.id.editName);
        editText_price=(EditText)findViewById(R.id.editPrice);
        editText_image=(EditText) findViewById(R.id.editImage);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(this);

        listview=(ListView)findViewById(R.id.item_datas);
        CustomAdapter adapter =new CustomAdapter(getSell());

        listview.setAdapter(adapter);

        //리스트뷰 클릭
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RealmResults<Sell_items> all = realm.where(Sell_items.class).findAll();
                Sell_items sell_items=all.get(position);

                realm.beginTransaction();
                sell_items.deleteFromRealm();
                realm.commitTransaction();

                customAdapter = new CustomAdapter(getSell());
                listview.setAdapter(customAdapter);
            }
        });
    }

    //클릭 이벤트
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                getAppend();
                break;
        }
    }

    //데이터베이스 값추가1
    private void getAppend() {
        name=editText_name.getText().toString();
        price=editText_price.getText().toString();
        image=editText_image.getText().toString();

        realmHere();
    }

    //데이터베이스 값추가2
    private void realmHere() {

        realm.beginTransaction();
        Sell_items sell_items=realm.createObject(Sell_items.class);
        sell_items.setName(name);
        sell_items.setPrice(price);
        sell_items.setImage(image);

        realm.commitTransaction();

        sell_itemsList.add(sell_items);

        customAdapter = new CustomAdapter(getSell());
        listview.setAdapter(customAdapter);
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
