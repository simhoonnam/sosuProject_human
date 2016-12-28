package com.example.hoont.sosuproject;

import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by hoont on 2016-12-27.
 */

public class Sell_items extends RealmObject{

    @Index
    public long id;

    private String name;
    private String price;
    private String image;

    public Sell_items(){

    }

    public Sell_items(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
