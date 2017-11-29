package com.example.administrator.eshop.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;


import com.example.administrator.eshop.MyAppliction;
import com.example.administrator.eshop.bean.GoodDetailBean;
import com.example.administrator.eshop.bean.ShoppingCart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


/**
 * 购物车数据存储类
 */
public class CartProvider {
    public static final String JSON_CART = "json_cart";
    private Context context;
    //优化过的HashMap集合
    private SparseArray<GoodDetailBean> datas;

    private static CartProvider cartProvider;

    private CartProvider(Context context) {
        this.context = context;
        datas = new SparseArray<>(100);
        listToSparse();
    }

    public static CartProvider getInstance() {
        if (cartProvider == null) {
            cartProvider = new CartProvider(MyAppliction.getInstance());
        }
        return cartProvider;
    }

    private void listToSparse() {
        List<GoodDetailBean> carts = getAllData();
        //放到sparseArry中
        if (carts != null && carts.size() > 0) {
            for (int i = 0; i < carts.size(); i++) {
                GoodDetailBean goodsBean = carts.get(i);
                datas.put(Integer.parseInt(goodsBean.getDatas().getGoods_info().getGoods_id()), goodsBean);
            }
        }
    }


    private List<GoodDetailBean> parsesToList() {
        List<GoodDetailBean> carts = new ArrayList<>();
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                GoodDetailBean shoppingCart = datas.valueAt(i);
                carts.add(shoppingCart);
            }
        }
        return carts;
    }

    public List<GoodDetailBean> getAllData() {
        return getDataFromLocal();
    }

    //本地获取json数据，并且通过Gson解析成list列表数据
    public List<GoodDetailBean> getDataFromLocal() {
        List<GoodDetailBean> carts = new ArrayList<>();
        //从本地获取缓存数据
        String savaJson = CacheUtils.getString(context, JSON_CART);
        if (!TextUtils.isEmpty(savaJson)) {
            //把数据转换成列表
            carts = new Gson().fromJson(savaJson, new TypeToken<List<GoodDetailBean>>() {
            }.getType());
        }
        return carts;

    }

    public void addData(GoodDetailBean cart) {

        //添加数据
        GoodDetailBean tempCart = datas.get(Integer.parseInt(cart.getDatas().getGoods_info().getGoods_id()));
        if (tempCart != null) {
            tempCart.setCount(tempCart.getCount() + cart.getCount());
        } else {
            tempCart = cart;
            tempCart.setCount(1);
        }

        datas.put(Integer.parseInt(tempCart.getDatas().getGoods_info().getGoods_id()), tempCart);



        //保存数据
        commit();
    }

    //保存数据
    private void commit() {
        //把parseArray转换成list
        List<GoodDetailBean> carts = parsesToList();
        //把转换成String
        String json = new Gson().toJson(carts);

        // 保存
        CacheUtils.putString(context, JSON_CART, json);

    }


    public void deleteData(GoodDetailBean cart) {

        //删除数据

        datas.delete(Integer.parseInt(cart.getDatas().getGoods_info().getGoods_id()));


        //保存数据
        commit();
    }

    public void updataData(GoodDetailBean cart) {
        //修改数据
        datas.put(Integer.parseInt(cart.getDatas().getGoods_info().getGoods_id()), cart);
        //保存数据
        commit();
    }

    /**
     * 根据key查找书籍
     * @param goods_bean
     * @return
     */
    public GoodDetailBean findData(GoodDetailBean goods_bean) {
        GoodDetailBean goodsBean = datas.get(Integer.parseInt(goods_bean.getDatas().getGoods_info().getGoods_id()));
        if(goodsBean != null){
            return goods_bean;
        }
        return null;
    }
}
