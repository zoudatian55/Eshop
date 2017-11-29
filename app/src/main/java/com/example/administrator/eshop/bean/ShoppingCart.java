package com.example.administrator.eshop.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/14 0014.
 */

public class ShoppingCart extends GoodDetailBean.DatasBean implements Serializable {
    private String store_name;
    private String name;
    private String figure;
    private int good_id;
    private String price;
    private int count;
    private boolean isChecked=true;

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(GoodDetailBean.DatasBean data) {
        this.store_name = data.getStore_info().getStore_name();
    }

    public String getName() {
        return name;
    }

    public void setName(GoodDetailBean.DatasBean data) {
        this.name = data.getGoods_info().getGoods_name();
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(GoodDetailBean.DatasBean data) {
        this.figure = (String) data.getGoods_info().getSpec_value();
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(GoodDetailBean.DatasBean data) {
        this.good_id = Integer.parseInt(data.getGoods_info().getGoods_id());
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(GoodDetailBean.DatasBean data) {
        this.price = data.getGoods_info().getGoods_price();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
