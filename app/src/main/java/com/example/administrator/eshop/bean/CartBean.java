package com.example.administrator.eshop.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/14 0014.
 */

public class CartBean implements Serializable{
    private String cart_good_id;
    private int count;

    public String getCart_good_id() {
        return cart_good_id;
    }

    public void setCart_good_id(String cart_good_id) {
        this.cart_good_id = cart_good_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
