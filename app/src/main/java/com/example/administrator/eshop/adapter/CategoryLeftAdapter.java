package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.bean.CategoryLeft;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class CategoryLeftAdapter extends BaseAdapter {
    private Context context;
    private List<CategoryLeft.DatasBean.ClassListBean> list;
    private LinearLayout layout;


    public CategoryLeftAdapter(Context context, List<CategoryLeft.DatasBean.ClassListBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
      final ViewHolder holder;
        LinearLayout layout = null;
        if(view==null){
            view=View.inflate(context, R.layout.category_left,null);
            holder=new ViewHolder();
            holder.category_image= (ImageView) view.findViewById(R.id.category_image);
            holder.category_name= (TextView) view.findViewById(R.id.category_name);

            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        CategoryLeft.DatasBean.ClassListBean bean = list.get(i);
        Glide.with(context).load(bean.getImage()).into(holder.category_image);
        //获得图片的颜色
        holder.category_name.setText(bean.getGc_name());
        return view;
    }


    public  class ViewHolder {
        ImageView category_image;
        TextView category_name;
    }
}
