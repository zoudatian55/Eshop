package com.example.administrator.eshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.eshop.MainActivity;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.adapter.ItemTitlePagerAdapter;
import com.example.administrator.eshop.fragment.ShopCartFragment;
import com.example.administrator.eshop.fragment.ShopFragment;
import com.example.administrator.eshop.fragment.ShopHomeFragment;
import com.example.administrator.eshop.goodsfragment.GoodsCommentFragment;
import com.example.administrator.eshop.goodsfragment.GoodsDetailFragment;
import com.example.administrator.eshop.goodsfragment.GoodsInfoFragment;
import com.example.administrator.eshop.weight.NoScrollViewPager;
import com.gxz.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

public class GoodInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private String s;
    public PagerSlidingTabStrip psts_tabs;
    public NoScrollViewPager vp_content;
    public TextView tv_title;
    private TextView tv_chat;
    private TextView tv_cart;
    private Button btn_buy;
    private Button btn_cart;
    private ImageView iv_back;
    private List<Fragment> fragmentList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_info);
        String good_id = getIntent().getStringExtra("good_id");
        Bundle bundle=new Bundle();
        psts_tabs = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);
        vp_content = (NoScrollViewPager) findViewById(R.id.vp_content);
        tv_chat= (TextView) findViewById(R.id.tv_chat);
        tv_cart= (TextView) findViewById(R.id.tv_cart);
        btn_buy= (Button) findViewById(R.id.btn_buy);
        btn_cart= (Button) findViewById(R.id.btn_cart);
        iv_back= (ImageView) findViewById(R.id.iv_back);
        fragmentList.add(new GoodsInfoFragment());

        fragmentList.add( new GoodsDetailFragment());
        fragmentList.add(new GoodsCommentFragment());
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"商品", "详情", "评价"}));
        vp_content.setOffscreenPageLimit(3);

        psts_tabs.setViewPager(vp_content);
        tv_cart.setOnClickListener(this);
        tv_chat.setOnClickListener(this);
        btn_buy.setOnClickListener(this);
        btn_cart.setOnClickListener(this);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }


    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.tv_chat:
               Toast.makeText(this, "客服", Toast.LENGTH_SHORT).show();
               break;
           case R.id.tv_cart:
               Toast.makeText(this, "购物车", Toast.LENGTH_SHORT).show();
               //跳转到购物车页面
           Intent intent=new Intent(GoodInfoActivity.this,MainActivity.class);
               intent.putExtra("id",1);
               startActivity(intent);

               break;
           case R.id.btn_buy:
               GoodsInfoFragment goodsInfoFragment = (GoodsInfoFragment) getSupportFragmentManager().getFragments().get(0);
                //需要传入一些值

               //有一个popwindow,跳转到属性界面
               Toast.makeText(this,"立即购买",Toast.LENGTH_SHORT).show();
               break;
           case R.id.btn_cart:
               //跳转到属性界面
               ((GoodsInfoFragment) getSupportFragmentManager().getFragments().get(0)).showPopWindow();
               Toast.makeText(this,"加入购物车",Toast.LENGTH_SHORT).show();
               break;
       }

    }



    public void getgoodsdetailfragment(){
        vp_content.setCurrentItem(1);
    }
    public void getgoodscommentfragment(){
        vp_content.setCurrentItem(2);
    }


}
