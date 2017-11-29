package com.example.administrator.eshop.utils;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class Contants {

    //购物页面的网址
    public static final String BASE_URL="http://www.emall001.com/mobile/index.php?";
    //首页的网址
    public static final String SHHOP_URL=BASE_URL+"act=index&op=index";
    //商品详情页面的基本网址
    public static final String GOOD_DETAIL_BASE_URL=BASE_URL+"act=goods&op=goods_detail&goods_id=";
    public static final String KEY="&key=c59f0f6bf28e3fc7099a922d8588d7cd";
    //商品的详情页的地址
    public static final String GOOD_DETAIL_DETSIL_URL=BASE_URL+"act=goods&op=goods_body&goods_id=";
    //商品的列表的地址
    public static final String GOOD_LIST_URL=BASE_URL+"act=goods&op=goods_list&gc_id=";
    public static final String GOOD_LIST_SUFFIX="&key=&order=2&gift=null&groupbuy=null&xianshi=null&own_shop=null&price_from=null&price_to=null&area_id=null&ci=null&";

    public static final String CURRENT="curpage=";
    public static final String PAGE="&page=10";
    //分类的网址
    public static final String CATEGORY=BASE_URL+"act=goods_class";
    public static final String CATEGORY_RIGHT="&op=get_child_all&gc_id=";


    public static final String USER_JSON="user_json";
    public static final String TOKEN="token";


}
