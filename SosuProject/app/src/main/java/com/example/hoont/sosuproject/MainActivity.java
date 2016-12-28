package com.example.hoont.sosuproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button stock_man_tv;
    Button stock_tv;

    ImageView linked_to_site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, splashActivity.class));

        setDefault();
    }

    private void setDefault() {
        stock_man_tv=(Button) findViewById(R.id.stockaddButton);
        stock_tv=(Button)findViewById(R.id.stockButton);
        linked_to_site=(ImageView)findViewById(R.id.humanimage);

        linked_to_site.setOnClickListener(this);
        stock_man_tv.setOnClickListener(this);
        stock_tv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.stockaddButton:
                intent = new Intent(MainActivity.this,StockActivity.class);
                startActivity(intent);
                break;
            case R.id.stockButton:
                intent = new Intent(MainActivity.this,StockAddActivity.class);
                startActivity(intent);
                break;
            case R.id.humanimage:
                Uri uri = Uri.parse("http://lakickz.com/product/list.html?cate_no=545");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;
        }
    }
}
