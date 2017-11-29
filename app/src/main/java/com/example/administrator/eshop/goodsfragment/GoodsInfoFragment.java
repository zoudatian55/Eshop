package com.example.administrator.eshop.goodsfragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodInfoActivity;
import com.example.administrator.eshop.adapter.CommandAdapter;
import com.example.administrator.eshop.adapter.GoodsDetailPagerAdapter;
import com.example.administrator.eshop.bean.CartBean;
import com.example.administrator.eshop.bean.GoodDetailBean;
import com.example.administrator.eshop.bean.ShoppingCart;
import com.example.administrator.eshop.utils.CacheUtils;
import com.example.administrator.eshop.utils.CartProvider;
import com.example.administrator.eshop.utils.Contants;
import com.example.administrator.eshop.weight.CommandGridView;
import com.example.administrator.eshop.weight.NumberAddSubView;
import com.example.administrator.eshop.weight.VirtualkeyboardHeight;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsInfoFragment extends Fragment implements View.OnClickListener{
    private ViewPager vp_imgs;
    //分享
    private ImageView iv_share;
    //收藏
    private ImageView iv_fav;
    //商品描述
    private TextView tv_goods_title;
    //商品价格
    private TextView tv_goods_price;
    //商品的位置
  private  TextView tv_goods_address;
    private TextView tv_store;
    private TextView tv_content;
    //商品属性的选择
    private TextView tv_nature;
    //点击之后显示商品属性
    private ImageView iv_detail;
    //服务

    //商品提供的优惠信息
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    //商品评价的信息
    private TextView tv_evaluate_detail;
    //评价人数
    private TextView tv_evaluate_detail_man;
    private ImageView iv_evaluate_detail;
    private CommandGridView commend;
    private TextView tv_chess_detail;
    private String detail;
    private GoodDetailBean.DatasBean datas;
    private Context context;
    private List<GoodDetailBean.DatasBean.ImageListBean> image_list;
    private List<String> list;
    private TextView store;
    private TextView decrible_tv1;
    private TextView math_tv1;
    private TextView prencent_tv1;
    private TextView decrible_tv2;
    private TextView math_tv2;
    private TextView prencent_tv2;
    private TextView decrible_tv3;
    private TextView math_tv3;
    private TextView prencent_tv3;
    private View service;
    private ImageView detail_store;
    private View goods_describe;
    private GoodDetailBean bean;
    private String good_id;
    private CartProvider cartProvider;






    public  GoodsInfoFragment(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_goods_info,null);
        context=getActivity();
         good_id= getActivity().getIntent().getStringExtra("good_id");
        initData(good_id);
        image_list=new ArrayList<>();
        vp_imgs  = (ViewPager) view.findViewById(R.id.vp_imgs);
        iv_share= (ImageView) view.findViewById(R.id.iv_share);
        //收藏
         iv_fav= (ImageView) view.findViewById(R.id.iv_fav);
        //商品描述
        tv_goods_title= (TextView) view.findViewById(R.id.tv_goods_title);
        //商品价格
        tv_goods_price= (TextView) view.findViewById(R.id.tv_goods_price);

        //商品的为师
        tv_goods_address= (TextView) view.findViewById(R.id.tv_goods_address);
        tv_content= (TextView) view.findViewById(R.id.tv_content);
        tv_store= (TextView) view.findViewById(R.id.tv_store);
        //商品属性的选择
       tv_nature= (TextView) view.findViewById(R.id.tv_nature);
        //点击之后显示商品属性
          iv_detail= (ImageView) view.findViewById(R.id.iv_detail);
        //商品提供的优惠信息
          img1= (ImageView) view.findViewById(R.id.img1);
          img2= (ImageView) view.findViewById(R.id.img2);
          img3= (ImageView) view.findViewById(R.id.img3);
         img4= (ImageView) view.findViewById(R.id.img4);
        tv1= (TextView) view.findViewById(R.id.tv1);
        tv2= (TextView) view.findViewById(R.id.tv2);
        tv3= (TextView) view.findViewById(R.id.tv3);
        tv4= (TextView) view.findViewById(R.id.tv4);
        //商品评价的信息
         tv_evaluate_detail= (TextView) view.findViewById(R.id.tv_evaluate_detail);
        //评价人数
         tv_evaluate_detail_man= (TextView) view.findViewById(R.id.tv_evaluate_detail_man);
         iv_evaluate_detail= (ImageView) view.findViewById(R.id.iv_evaluate_detail);

         store= (TextView) view.findViewById(R.id.store);
        goods_describe=view.findViewById(R.id.goods_describe);
        decrible_tv1= (TextView) view.findViewById(R.id.decrible_tv1);
        decrible_tv2= (TextView) view.findViewById(R.id.decrible_tv2);
        decrible_tv3= (TextView) view.findViewById(R.id.decrible_tv3);
        math_tv1=(TextView) view.findViewById(R.id.math_tv1);
        math_tv2=(TextView) view.findViewById(R.id.math_tv2);
        math_tv3=(TextView) view.findViewById(R.id.math_tv3);
        prencent_tv1=(TextView) view.findViewById(R.id.prencent_tv1);
        prencent_tv2=(TextView) view.findViewById(R.id.prencent_tv2);
        prencent_tv3=(TextView) view.findViewById(R.id.prencent_tv3);
        service = view.findViewById(R.id.service);
        detail_store = (ImageView) view.findViewById(R.id.detail_store);

        commend= (CommandGridView) view.findViewById(R.id.commend);
         tv_chess_detail= (TextView) view.findViewById(R.id.tv_chess_detail);;

        iv_share.setOnClickListener(this);
        iv_fav.setOnClickListener(this);
        iv_detail.setOnClickListener(this);
        iv_evaluate_detail.setOnClickListener(this);
        tv_chess_detail.setOnClickListener(this);
        detail_store.setOnClickListener(this);



        return view;

    }



    private void initData(String goods_id) {
        list=new ArrayList<>();
        cartProvider=CartProvider.getInstance();
        Intent intent =getActivity(). getIntent();
         bean= (GoodDetailBean) intent.getSerializableExtra("good_detail_bean");

        String url= Contants.GOOD_DETAIL_BASE_URL+goods_id;
        Log.e("url",url);
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder().
                get().url(url).build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(),"网络请求失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                detail = response.body().string();
                Log.e("result",detail);
                // 解析数据
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        processData(detail);

                    }
                });


            }
        });

    }

    private void processData(String json) {
        bean=prase(json);
        datas = bean.getDatas();

        image_list = datas.getImage_list();
        vp_imgs.setAdapter(new GoodsDetailPagerAdapter(image_list,context));
        tv_goods_title.setText(datas.getGoods_info().getGoods_name());
        tv_goods_price.setText("¥"+datas.getGoods_info().getGoods_price());
        tv_goods_address.setText(datas.getGoods_hair_info().getArea_name());
        tv_store.setText(datas.getGoods_hair_info().getIf_store_cn());
        tv_content.setText(datas.getGoods_hair_info().getContent());
        if(datas.getGoods_info().getContractlist()!=null){
            service.setVisibility(View.VISIBLE);
            Glide.with(context).load(datas.getGoods_info().getContractlist().get_$1().getCti_icon_url()).into(img1);
            Glide.with(context).load(datas.getGoods_info().getContractlist().get_$2().getCti_icon_url()).into(img2);
            Glide.with(context).load(datas.getGoods_info().getContractlist().get_$3().getCti_icon_url()).into(img3);
            Glide.with(context).load(datas.getGoods_info().getContractlist().get_$4().getCti_icon_url()).into(img4);
            tv1.setText(datas.getGoods_info().getContractlist().get_$1().getCti_name());
            tv2.setText(datas.getGoods_info().getContractlist().get_$2().getCti_name());
            tv3.setText(datas.getGoods_info().getContractlist().get_$3().getCti_name());
            tv4.setText(datas.getGoods_info().getContractlist().get_$4().getCti_name());
        }else{
            service.setVisibility(View.GONE);
        }
        if(datas.getStore_info().getStore_name().equals("电商壹号官方自营店")){
            goods_describe.setVisibility(View.GONE);

        }else{
            store.setText(datas.getStore_info().getStore_name());
            decrible_tv1.setText(datas.getStore_info().getStore_credit().getStore_desccredit().getText());
            decrible_tv2.setText(datas.getStore_info().getStore_credit().getStore_servicecredit().getText());
            decrible_tv3.setText(datas.getStore_info().getStore_credit().getStore_deliverycredit().getText());
            math_tv1.setText(datas.getStore_info().getStore_credit().getStore_desccredit().getCredit());
            prencent_tv1.setText(datas.getStore_info().getStore_credit().getStore_desccredit().getPercent_text());
            math_tv2.setText(datas.getStore_info().getStore_credit().getStore_servicecredit().getCredit());
            prencent_tv2.setText(datas.getStore_info().getStore_credit().getStore_servicecredit().getPercent_text());
            math_tv3.setText(datas.getStore_info().getStore_credit().getStore_deliverycredit().getCredit());
            prencent_tv3.setText(datas.getStore_info().getStore_credit().getStore_deliverycredit().getPercent_text());


        }


        //没有显示

    commend.setAdapter(new CommandAdapter(context,datas.getGoods_commend_list()));
        commend.setNumColumns(4);
        commend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String good_id = datas.getGoods_commend_list().get(i).getGoods_id();
                Intent intent=new Intent(context,GoodInfoActivity.class);
                intent.putExtra("good_id",good_id);
                context.startActivity(intent);
            }
        });
//        list.add((String) datas.getGoods_info().getSpec_value());



    }



    private GoodDetailBean prase(String json) {
        return new Gson().fromJson(json,GoodDetailBean.class);
    }



    @Override
    public void onClick(View view) {
        GoodInfoActivity goodinfoactivity= (GoodInfoActivity) context;
        switch (view.getId()){
            case R.id.iv_fav:
                Toast.makeText(context, "收藏", Toast.LENGTH_SHORT).show();
                iv_fav.setImageResource(R.drawable.nc_icon_fav_on);
                //需要添加到sdcard中去
            break;
            case R.id.iv_share:
              //  Toast.makeText(context, "分享", Toast.LENGTH_SHORT).show();
             showShare();
                break;
            case R.id.iv_detail:
               showPopWindow();
                break;
            case R.id.iv_evaluate_detail:
                goodinfoactivity.getgoodscommentfragment();
                break;
            case R.id.tv_chess_detail:
                goodinfoactivity.getgoodsdetailfragment();
                break;
            case R.id.detail_store:
                Toast.makeText(context, "店铺详情", Toast.LENGTH_SHORT).show();
            break;

        }

    }


    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享");

        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(datas.getGoods_info().getGoods_url());

        // text是分享文本，所有平台都需要这个字段
        oks.setText(datas.getGoods_info().getGoods_name());

        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setImageUrl(datas.getSpec_image().get(0));

        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(datas.getGoods_info().getGoods_url());
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
       // oks.setComment(mWare.getName());

        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));

        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
     //   oks.setSiteUrl("http://www.cniao5.com");

// 启动分享GUI
        oks.show(context);
    }


    public void showPopWindow() {
        // 1 利用layoutInflater获得View
   //     LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = View.inflate(context,R.layout.popupwindow_add_product, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画



        // 4 控件处理
        ImageView iv_goodinfo_photo = (ImageView) view.findViewById(R.id.iv_goodinfo_photo);
        TextView tv_goodinfo_name = (TextView) view.findViewById(R.id.tv_goodinfo_name);
        TextView tv_goodinfo_price = (TextView) view.findViewById(R.id.tv_goodinfo_price);
        TextView store = (TextView) view.findViewById(R.id.tv_goodinfo_store);
        final NumberAddSubView nas_goodinfo_num = (NumberAddSubView) view.findViewById(R.id.nas_goodinfo_num);
        Button bt_goodinfo_cancel = (Button) view.findViewById(R.id.bt_goodinfo_cancel);
        Button bt_goodinfo_confim = (Button) view.findViewById(R.id.bt_goodinfo_confim);
        TextView tv_type= (TextView) view.findViewById(R.id.tv_type);



        // 加载图片
        Glide.with(context).load(datas.getSpec_image().get(0)).into(iv_goodinfo_photo);

        // 名称
        tv_goodinfo_name.setText(datas.getGoods_info().getGoods_name());
        // 显示价格
        tv_goodinfo_price.setText("¥"+datas.getGoods_info().getGoods_price());
        //库存
        store.setText("库存："+datas.getGoods_info().getGoods_storage());



        // 设置最大值和当前值
        nas_goodinfo_num.setMaxValue(10);
        nas_goodinfo_num.setMinValue(1);

        nas_goodinfo_num.setOnNumberChangeListener(new NumberAddSubView.OnNumberChangeListener() {
            @Override
            public void onNumberChange(int value) {
                bean.setCount(value);
            }
        });

        bt_goodinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });

        bt_goodinfo_confim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                //添加购物车

            cartProvider.addData(bean);


                Toast.makeText(context, "添加购物车成功", Toast.LENGTH_SHORT).show();
            }
        });

        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(getActivity().findViewById(R.id.ll_good_root),
                Gravity.CENTER_VERTICAL,0 , VirtualkeyboardHeight.getBottomStatusHeight(getActivity()));

    }




}


