package com.example.administrator.eshop.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.MainActivity;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodInfoActivity;
import com.example.administrator.eshop.activity.GoodListInfoActivity;
import com.example.administrator.eshop.adapter.ChannelAdapter;
import com.example.administrator.eshop.adapter.GoodShowAdapter;

import com.example.administrator.eshop.bean.ChannelTitleBean;
import com.example.administrator.eshop.bean.ShopHomeBean;
import com.example.administrator.eshop.utils.Contants;
import com.example.administrator.eshop.weight.MyGridView;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnLoadImageListener;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopHomeFragment extends Fragment {
    private LinearLayout sweep;
    private LinearLayout message;
    private LinearLayout search;
    private ImageButton ib_top;
    private String s;
    private   List<ShopHomeBean.DatasBean> datas;
    private GoodShowAdapter adapter;
    private MyGridView gridView;
    private  Banner banner;
    private RecyclerView rv_home;

    private String[] title=new String[]{"壹号生鲜","食品饮料","粮油副食","中外名酒","全部分类",
            "母婴用品","美妆个护","居家生活","营养保健","中国搜索"};
    private String[] url_good_id=new String[]{
            "2392","2460","2559","2641","","2683","2723","2780","3413",""
    };
    private int[] imgs=new int[]{R.drawable.column_fresh,R.drawable.column_food,
            R.drawable.column_oil, R.drawable.column_wine,
            R.drawable.column_all, R.drawable.column_baby,
            R.drawable.column_mask,R.drawable.column_life,
            R.drawable.column_health,R.drawable.column_search
    };
    private List<ChannelTitleBean> channel;
    //分类的列表
    private ChannelAdapter channeladapter;
    private  List<ShopHomeBean.DatasBean.AdvListBean.ItemBean> item;
    private  ScrollView scrollview;



    public ShopHomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shop_home,null);
        //扫一扫
        sweep= (LinearLayout) view.findViewById(R.id.sweep);
        //消息
        message= (LinearLayout) view.findViewById(R.id.message);
        //搜索
        search= (LinearLayout) view.findViewById(R.id.search);
        //回到顶部的按钮
        ib_top= (ImageButton) view.findViewById(R.id.ib_top);
        banner = (Banner) view.findViewById(R.id.banner);
        gridView = (MyGridView) view.findViewById(R.id.gridview);
        rv_home= (RecyclerView) view.findViewById(R.id.rv_home);
        scrollview= (ScrollView) view.findViewById(R.id.scrollview);
        initListener();
        initData();
        return view;
    }

    private void initData() {

      String  url= Contants.SHHOP_URL;
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
                s = response.body().string();
                Log.e("tag",s);
                // 解析数据
                MainActivity main= (MainActivity) getContext();
                main.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        processData(s);
                    }
                });

            }
        });
        setChannel();

    }

    private void setChannel() {
        channel=new ArrayList<>();
        for(int i=0;i<title.length;i++) {
            final ChannelTitleBean titleBean = new ChannelTitleBean();
            titleBean.setTitle(title[i]);
            titleBean.setImgaddress(imgs[i]);
            titleBean.setUrl(url_good_id[i]);

            channel.add(titleBean);
        }
            channeladapter = new ChannelAdapter(getContext(), channel);
            gridView.setAdapter(channeladapter);
            gridView.setNumColumns(5);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                    if (j == 4) {
                        ShopFragment shopfragment = (ShopFragment) getParentFragment();
                        shopfragment.getShopCategory();

                    }else if(j==9) {
                        Toast.makeText(getContext(), "跳转到网址", Toast.LENGTH_SHORT).show();

                    } else {
                        Intent intent = new Intent(getContext(), GoodListInfoActivity.class);
                        intent.putExtra("good_list_id",url_good_id[j]);
                        getContext().startActivity(intent);

                    }

                }

            });


    }

    private void processData(String json) {
        ShopHomeBean bean=prase(json);
         datas = bean.getDatas();
        if(datas!=null){
            item= datas.get(0).getAdv_list().getItem();
            setBanner(item);
          setGoodList(datas);


        }
        }

    private void setGoodList( List<ShopHomeBean.DatasBean> data) {
        rv_home.setAdapter(new GoodShowAdapter(getContext(),data));
        GridLayoutManager manager=new GridLayoutManager(getContext(),1);
        rv_home.setLayoutManager(manager);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position<=1){
                    ib_top.setVisibility(View.GONE);
                }else{
                    ib_top.setVisibility(View.VISIBLE);
                }
                return 1;
            }
        });

    }

    private void setBanner(final List<ShopHomeBean.DatasBean.AdvListBean.ItemBean> item) {
        //设置Banner 适配器
        List<String> imageurl=new ArrayList<>();
        //得到图片的地址
        for(int i=0;i<item.size();i++){
            String imageUrl=item.get(i).getImage();
            imageurl.add(imageUrl);

        }
        //设置是效果
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setBannerAnimation(Transformer.Accordion);
        banner.setImages(imageurl, new OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(getContext()).load(url).into(view);
            }
        });
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                //根据位置分别设置
                String type = item.get(position-1).getType();
                String data=item.get(position-1).getData();
                //判断是否跳转到商品详情页还是商品列表
                if((position-1)%2==1){
                    //跳转到商品列表页
                    Intent intent=new Intent(getContext(), GoodListInfoActivity.class);
                    intent.putExtra("type",type);
                    intent.putExtra("data",data);
                    getContext().startActivity(intent);
                }else{
                    Intent intent=new Intent(getContext(),GoodInfoActivity.class);
                    intent.putExtra("type",type);
                    intent.putExtra("data",data);
                    getContext().startActivity(intent);

                }


            }
        });


    }




    private ShopHomeBean prase(String json) {
        return new Gson().fromJson(json,ShopHomeBean.class);
    }

    private void initListener() {
     // 置顶的监听
            ib_top.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View v) {
                 // 回到顶部
                    scrollview.scrollTo(0,0);
                }
            });
              // 搜素的监听
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), " 搜索",
                            Toast.LENGTH_SHORT).show();
                }
            });
              // 消息的监听
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), " 进入消息中心",
                            Toast.LENGTH_SHORT).show();
                }
            });
        //扫一扫的监听
        sweep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
//intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                startActivityForResult(intent, 0);


            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == 0 && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                Toast.makeText(getActivity(), "扫描结果"+content, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
