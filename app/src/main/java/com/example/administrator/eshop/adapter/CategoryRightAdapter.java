package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodListInfoActivity;
import com.example.administrator.eshop.bean.CategoryRight;
import com.example.administrator.eshop.weight.MyGridView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class CategoryRightAdapter extends BaseAdapter {
    private Context context;
    private List<CategoryRight.DatasBean.ClassListBean> class_list;
    private List<CategoryRight.DatasBean.ClassListBean.ChildBean> child;

    public CategoryRightAdapter(Context context, List<CategoryRight.DatasBean.ClassListBean> class_list) {
        this.context=context;
        this.class_list=class_list;
    }

    @Override
    public int getCount() {
        return class_list.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view=View.inflate(context,R.layout.category_right,null);
            holder=new ViewHolder();
            holder.category_right_name= (TextView) view.findViewById(R.id.category_right_name);
            holder.iv_more= (ImageView) view.findViewById(R.id.iv_more);
            holder.item_category= (MyGridView) view.findViewById(R.id.item_category);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        final CategoryRight.DatasBean.ClassListBean bean = class_list.get(position);
        holder.category_right_name.setText(bean.getGc_name());
        holder.iv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gc_id = bean.getGc_id();
                Intent intent=new Intent(context, GoodListInfoActivity.class);
                intent.putExtra("good_list_id",gc_id);
                context.startActivity(intent);
            }
        });
         child = bean.getChild();
        holder.item_category.setAdapter(new ItemCategoryRightAdapter(context,child));
        return view;
    }

    class ViewHolder{
        TextView category_right_name;
        MyGridView item_category;
        ImageView iv_more;

    }

}
