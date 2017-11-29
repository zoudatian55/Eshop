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
import com.example.administrator.eshop.bean.GoodListBean;
import com.example.administrator.eshop.bean.ListGoodListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class GoodListAdapter extends BaseAdapter {
    private Context context;
   // private List<GoodListBean.DatasBean.GoodsListBean> goods_list;
    private List<ListGoodListBean.DatasBean.GoodsListBean> good_list;
    private  ListGoodListBean.DatasBean.GoodsListBean goodsListBean;
    private LinearLayout layout;

    public GoodListAdapter(Context context, List<ListGoodListBean.DatasBean.GoodsListBean> goods_list) {
        this.context=context;
        this.good_list=goods_list;
    }

    @Override
    public int getCount() {
        return good_list.size();
    }

    @Override
    public Object getItem(int i) {
        return good_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
      ViewHolder  holder;
        if(view==null){
            view=View.inflate(context,R.layout.list_item,null);
            holder=new ViewHolder();
            holder.list_image= (ImageView) view.findViewById(R.id.list_image);
            holder.list_good_name= (TextView) view.findViewById(R.id.list_good_name);
            holder.list_else_name= (TextView) view.findViewById(R.id.list_else_name);
            holder.list_price= (TextView) view.findViewById(R.id.list_price);
            holder.store_list= (TextView) view.findViewById(R.id.list_store_list);
              layout= (LinearLayout) view.findViewById(R.id.ll_list);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        goodsListBean = good_list.get(position);
        Glide.with(context).load(goodsListBean.getGoods_image_url()).into(holder.list_image);
        holder.list_good_name.setText(goodsListBean.getGoods_name());
        if(goodsListBean.getGoods_jingle()==null){
            holder.list_else_name.setVisibility(View.GONE);
        }else{
            holder.list_else_name.setText(goodsListBean.getGoods_jingle().toString());
        }
        holder.list_price.setText("¥"+goodsListBean.getGoods_price());
        if(goodsListBean.getStore_name().contentEquals("电商壹号官方自营店")){
            holder.store_list.setText("自营");
        }
        holder.store_list.setText(goodsListBean.getStore_name());
        notifyDataSetChanged();
        final String goods_id =goodsListBean.getGoods_id();
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
        ImageView list_image;
        TextView list_good_name;
        TextView list_else_name;
        TextView list_price;
        TextView store_list;

    }
}
