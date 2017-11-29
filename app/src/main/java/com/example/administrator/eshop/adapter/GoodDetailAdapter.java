package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodInfoActivity;
import com.example.administrator.eshop.bean.ShopHomeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class GoodDetailAdapter extends BaseAdapter {
    private LinearLayout layout;
    private Context context;
    private List<ShopHomeBean.DatasBean.GoodsBean.ItemBeanX> lists;
    public GoodDetailAdapter(Context context, List<ShopHomeBean.DatasBean.GoodsBean.ItemBeanX> item) {
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
        ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.good_item,null);
            holder=new ViewHolder();
            holder.imageView= (ImageView) view.findViewById(R.id.iv_hot);
            holder.title= (TextView) view.findViewById(R.id.tv_name);
            holder.price= (TextView) view.findViewById(R.id.tv_price);
            layout = (LinearLayout) view.findViewById(R.id.good_detail_item);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        ShopHomeBean.DatasBean.GoodsBean.ItemBeanX beanX = lists.get(i);
        Glide.with(context).load(beanX.getGoods_image()).into(holder.imageView);
        holder.title.setText(beanX.getGoods_name());
        holder.price.setText("¥"+beanX.getGoods_promotion_price());
        final String goods_id = beanX.getGoods_id();
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
