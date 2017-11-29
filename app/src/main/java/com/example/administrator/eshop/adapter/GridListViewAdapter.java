package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodInfoActivity;
import com.example.administrator.eshop.bean.ListGoodListBean;
import com.example.administrator.eshop.bean.ShopHomeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class GridListViewAdapter extends BaseAdapter {
    private LinearLayout layout;
    private Context context;
    private List<ListGoodListBean.DatasBean.GoodsListBean> lists;
    public GridListViewAdapter(Context context, List<ListGoodListBean.DatasBean.GoodsListBean> item) {
        this.context=context;
        this.lists=item;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        GridListViewAdapter.ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.good_item,null);
            holder=new GridListViewAdapter.ViewHolder();
            holder.imageView= (ImageView) view.findViewById(R.id.iv_hot);
            holder.title= (TextView) view.findViewById(R.id.tv_name);
            holder.price= (TextView) view.findViewById(R.id.tv_price);
            layout = (LinearLayout) view.findViewById(R.id.good_detail_item);
            view.setTag(holder);
        }else {
            holder= (GridListViewAdapter.ViewHolder) view.getTag();
        }
        ListGoodListBean.DatasBean.GoodsListBean goodsListBean = lists.get(i);
        Glide.with(context).load(goodsListBean.getGoods_image_url()).into(holder.imageView);
        holder.title.setText(goodsListBean.getGoods_name());
        holder.price.setText("¥"+goodsListBean.getGoods_price());
        this.notifyDataSetChanged();
        final String goods_id = goodsListBean.getGoods_id();
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, GoodInfoActivity.class);
                intent.putExtra("good_id",goods_id);
                context.startActivity(intent);
            }
        });

        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView price;
    }
}
