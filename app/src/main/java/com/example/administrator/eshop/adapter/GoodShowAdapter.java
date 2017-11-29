package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.activity.GoodInfoActivity;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.bean.ShopHomeBean;
import com.example.administrator.eshop.weight.MyGridView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/24 0024.
 */

public class GoodShowAdapter extends RecyclerView.Adapter<GoodShowAdapter.ViewHolder> {

     private Context context;
    private int currentType=0;
    private   List<ShopHomeBean.DatasBean> goods;
    private LayoutInflater inflater;
    public static final int GOODSHOW_1=0;
    public static final int GOODSHOW_2=1;
    public static final int GOODSHOW_3=2;
    public static final int GOODSHOW_4=3;
    public static final int GOODSHOW_5=4;
    public static final int GOODSHOW_6=5;

    public GoodShowAdapter(Context context,  List<ShopHomeBean.DatasBean> goods) {
        this.context=context;
       this.goods=goods;
        this.goods=goods;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==GOODSHOW_1){
            return new ViewHolder(context,inflater.inflate(R.layout.good_viewpger,null));
        }
        else if(viewType==GOODSHOW_2){
            return new ViewHolder(context,inflater.inflate(R.layout.good_viewpger,null));
        }
        else if(viewType==GOODSHOW_3){
            return new ViewHolder(context,inflater.inflate(R.layout.good_viewpger,null));
        }
        else if(viewType==GOODSHOW_4){
            return new ViewHolder(context,inflater.inflate(R.layout.good_viewpger,null));
        }
        else if(viewType==GOODSHOW_5){
            return new ViewHolder(context,inflater.inflate(R.layout.good_viewpger,null));
        }else if(viewType==GOODSHOW_6){
            return new ViewHolder(context,inflater.inflate(R.layout.good_viewpger,null));
        }
        return null;
    }
    //绑定ViewHoder

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(getItemViewType(position)==GOODSHOW_1) {
            holder.setGoodData(goods.get(2).getGoods());
        }
        else if(getItemViewType(position)==GOODSHOW_2) {
            holder.setGoodData(goods.get(3).getGoods());
        }
        else if(getItemViewType(position)==GOODSHOW_3) {
            holder.setGoodData(goods.get(4).getGoods());
        }
        else if(getItemViewType(position)==GOODSHOW_4) {
            holder.setGoodData(goods.get(5).getGoods());
        }else if(getItemViewType(position)==GOODSHOW_5) {
            holder.setGoodData(goods.get(6).getGoods());
        }else if(getItemViewType(position)==GOODSHOW_6) {
            holder.setGoodData(goods.get(7).getGoods());
        }


    }

    @Override
    public int getItemCount() {
        return 7;
    }

@Override
public int getItemViewType(int position) {
    switch (position){
        case GOODSHOW_1:
            currentType=GOODSHOW_1;
            break;
        case GOODSHOW_2:
            currentType=GOODSHOW_2;
            break;
        case GOODSHOW_3:
            currentType=GOODSHOW_3;
            break;
        case GOODSHOW_4:
            currentType=GOODSHOW_4;
            break;
        case GOODSHOW_5:
            currentType=GOODSHOW_5;
            break;
        case GOODSHOW_6:
            currentType=GOODSHOW_6;
            break;
    }
    return currentType;
}

    class ViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private View item;
        private TextView good_title;
        private MyGridView good_gridView;

        public ViewHolder(Context context,View itemView) {
            super(itemView);
            this.mContext=context;
            this.item=itemView;
            good_title= (TextView) item.findViewById(R.id.good_title);
            good_gridView= (MyGridView) item.findViewById(R.id.good_gridview);

        }

        public void setGoodData(ShopHomeBean.DatasBean.GoodsBean goodData) {
            good_title.setText(goodData.getTitle());
            good_gridView.setAdapter(new GoodDetailAdapter(mContext,goodData.getItem()));
        }
    }

}
