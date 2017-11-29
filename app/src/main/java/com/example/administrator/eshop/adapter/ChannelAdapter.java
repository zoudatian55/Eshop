package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodListInfoActivity;
import com.example.administrator.eshop.bean.ChannelTitleBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/23 0023.
 */

public class ChannelAdapter extends BaseAdapter {
    private Context context;
    private List<ChannelTitleBean> channel;
    private ChannelTitleBean bean;
    public ChannelAdapter(Context context, List<ChannelTitleBean> channel) {
        this.context=context;
        this.channel=channel;
    }

    @Override
    public int getCount() {
        return channel.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.channel_item,null);
            holder=new ViewHolder();
            holder.img= (ImageView) view.findViewById(R.id.iv_channel);
            holder.title= (TextView) view.findViewById(R.id.tv_channel);

            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        bean = channel.get(position);
        holder.img.setImageResource(bean.getImgaddress());
        holder.title.setText(bean.getTitle());
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.ll_channel);
//        layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               switch (position){
//                   case  0:
//                   case  1:
//                   case  2:
//                   case  3:
//                   case  5:
//                   case  6:
//                   case  7:
//                   case  8:
//                       Intent intent=new Intent(context,GoodListInfoActivity.class);
//                       intent.putExtra("good_list_id",bean.getUrl());
//                       context.startActivity(intent);
//                       break;
//                   case  4:
//
//                       break;
//                   case  9:
//                       break;
//
//
//
//
////               }
//            }
//        });
        return view;
    }
    class ViewHolder{
        private ImageView img;
        private TextView title;
    }
}
