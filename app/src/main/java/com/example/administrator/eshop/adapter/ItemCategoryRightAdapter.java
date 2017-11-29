package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodListInfoActivity;
import com.example.administrator.eshop.bean.CategoryRight;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class ItemCategoryRightAdapter extends BaseAdapter {
    private Context context;
    private List<CategoryRight.DatasBean.ClassListBean.ChildBean> child;


    public ItemCategoryRightAdapter(Context context, List<CategoryRight.DatasBean.ClassListBean.ChildBean> child) {
        this.context=context;
        this.child=child;
    }

    @Override
    public int getCount() {
        return child.size();
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
        ViewHolder holder;
        if(view==null){
           view=View.inflate(context,R.layout.item_grid,null);
            holder=new ViewHolder();
            holder.tv_grid= (TextView) view.findViewById(R.id.tv_item);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        final CategoryRight.DatasBean.ClassListBean.ChildBean bean = child.get(i);
        holder.tv_grid.setText(bean.getGc_name());
        holder.tv_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gc_id = bean.getGc_id();
                Intent intent=new Intent(context, GoodListInfoActivity.class);
                intent.putExtra("good_list_id",gc_id);
                context.startActivity(intent);

            }
        });

        return view;
    }
    class ViewHolder{
        TextView tv_grid;
    }
}
