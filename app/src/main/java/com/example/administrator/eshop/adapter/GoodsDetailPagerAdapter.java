package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.bean.GoodDetailBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/3 0003.
 */

public class GoodsDetailPagerAdapter extends PagerAdapter {
    private List<GoodDetailBean.DatasBean.ImageListBean> image_list;
    private Context context;

    public GoodsDetailPagerAdapter(List<GoodDetailBean.DatasBean.ImageListBean> image_list,Context context) {
        this.image_list=image_list;
        this.context=context;

    }

    @Override
    public int getCount() {
        return image_list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       ImageView imageView=new ImageView(context);
        Glide.with(context).load(image_list.get(position).get_mid()).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
