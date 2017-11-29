package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.bean.GoodDetailBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/4 0004.
 */

public class CommandAdapter extends BaseAdapter {
    private Context context;
    private  List<GoodDetailBean.DatasBean.GoodsCommendListBean> list;
    public CommandAdapter(Context context, List<GoodDetailBean.DatasBean.GoodsCommendListBean> commend_list) {
        this.context=context;
        this.list=commend_list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder  holder;
        if(view==null){
            view=View.inflate(context,R.layout.command_item,null);
            holder=new ViewHolder();
            holder.tv_title= (TextView) view.findViewById(R.id.command_title);
            holder.iv_img= (ImageView) view.findViewById(R.id.command_img);
            holder.tv_price= (TextView) view.findViewById(R.id.command_price);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        GoodDetailBean.DatasBean.GoodsCommendListBean listBean = list.get(i);
        holder.tv_title.setText(listBean.getGoods_name());
        Glide.with(context).load(listBean.getGoods_image_url()).into(holder.iv_img);
        holder.tv_price.setText("¥"+listBean.getGoods_promotion_price());


        return view;
    }
    class ViewHolder{
        TextView tv_title;
        ImageView iv_img;
        TextView tv_price;
    }
}
