package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.bean.GoodDetailBean;
import com.example.administrator.eshop.fragment.ShopCartFragment;
import com.example.administrator.eshop.utils.CartProvider;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class ShoppingCartAdapter extends BaseAdapter {
    private boolean isShow = true;//是否显示编辑/完成
    private List<GoodDetailBean> GoodDetailBeanList;
    private CheckInterface checkInterface;
    private ModifyCountInterface modifyCountInterface;
    private Context context;

    public ShoppingCartAdapter(Context context) {
        this.context = context;
    }


    public void setGoodDetailBeanList(List<GoodDetailBean> GoodDetailBeanList) {
        this.GoodDetailBeanList = GoodDetailBeanList;
        notifyDataSetChanged();
    }

    /**
     * 单选接口
     *
     * @param checkInterface
     */
    public void setCheckInterface(CheckInterface checkInterface) {
        this.checkInterface = checkInterface;
    }

    /**
     * 改变商品数量接口
     *
     * @param modifyCountInterface
     */
    public void setModifyCountInterface(ModifyCountInterface modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }

    @Override
    public int getCount() {
        return GoodDetailBeanList == null ? 0 : GoodDetailBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return GoodDetailBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * 是否显示可编辑
     *
     * @param flag
     */
    public void isShow(boolean flag) {
        isShow = flag;
        notifyDataSetChanged();
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopping_cart_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final GoodDetailBean goodDetailBean = GoodDetailBeanList.get(position);
        boolean choosed = goodDetailBean.isChecked();
        if (choosed){
            holder.ckOneChose.setChecked(true);
        }else{
            holder.ckOneChose.setChecked(false);
        }
//        String attribute = goodDetailBean.getDatas().getGoods_info().getSpec_value();
//        if (!StringUtil.isEmpty(attribute)){
//            holder.tvCommodityAttr.setText(attribute);
//        }else{
//            holder.tvCommodityAttr.setText(shoppingCartBean.getDressSize()+"");
//        }

//        holder.tvCommodityName.setText(GoodDetailBean.getShoppingName());
        holder.storeName.setText(goodDetailBean.getDatas().getStore_info().getStore_name());
        holder.tvCommodityPrice.setText("¥"+goodDetailBean.getDatas().getGoods_info().getGoods_price());
     //   holder.tvCommodityNum.setText(" X"+goodDetailBean.getCount()+"");
        holder.tvCommodityShowNum.setText(goodDetailBean.getCount()+"");
        Glide.with(context).load(goodDetailBean.getDatas().getSpec_image().get(0)).into(holder.ivShowPic);
        //单选框按钮
        holder.ckOneChose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goodDetailBean.setChecked(((CheckBox) v).isChecked());
                        checkInterface.checkGroup(position, ((CheckBox) v).isChecked());//向外暴露接口
                    }
                }
        );
        //增加按钮
        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyCountInterface.doIncrease(position, holder.tvCommodityShowNum, holder.ckOneChose.isChecked());//暴露增加接口
            }
        });
        //删减按钮
        holder.ivSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyCountInterface.doDecrease(position, holder.tvCommodityShowNum, holder.ckOneChose.isChecked());//暴露删减接口
            }
        });
        //删除弹窗
        holder.tvCommodityDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                             modifyCountInterface.childDelete(position);//删除 目前只是从item中移除
                //从容器内移除
                    CartProvider.getInstance().deleteData(goodDetailBean);
                   notifyDataSetChanged();

                            }

        });
        //判断是否在编辑状态下
        if (isShow) {
            holder.tvCommodityName.setVisibility(View.VISIBLE);
            holder.rlEdit.setVisibility(View.VISIBLE);
           // holder.tvCommodityNum.setVisibility(View.VISIBLE);
            holder.tvCommodityDelete.setVisibility(View.GONE);
        } else {
            holder.tvCommodityName.setVisibility(View.VISIBLE);
            holder.rlEdit.setVisibility(View.GONE);
          //  holder.tvCommodityNum.setVisibility(View.GONE);
            holder.tvCommodityDelete.setVisibility(View.VISIBLE);
        }
      if(CartProvider.getInstance().getDataFromLocal().size()==0){
          convertView=LayoutInflater.from(context).inflate(R.layout.empty_cart,parent,false);
      }



        return convertView;
    }



    //初始化控件
    class ViewHolder {
        ImageView ivShowPic,tvCommodityDelete;
        TextView tvCommodityName, tvCommodityAttr, tvCommodityPrice, tvCommodityNum, tvCommodityShowNum,ivSub, ivAdd,storeName;
        CheckBox ckOneChose;
        LinearLayout rlEdit;
        public ViewHolder(View itemView) {
            storeName= (TextView) itemView.findViewById(R.id.store_name);
            ckOneChose = (CheckBox) itemView.findViewById(R.id.ck_chose);
            ivShowPic = (ImageView) itemView.findViewById(R.id.iv_show_pic);
            ivSub = (TextView) itemView.findViewById(R.id.iv_sub);
            ivAdd = (TextView) itemView.findViewById(R.id.iv_add);
            tvCommodityName = (TextView) itemView.findViewById(R.id.tv_commodity_name);
          //  tvCommodityAttr = (TextView) itemView.findViewById(R.id.tv_commodity_attr);
            tvCommodityPrice = (TextView) itemView.findViewById(R.id.tv_commodity_price);
          //  tvCommodityNum = (TextView) itemView.findViewById(R.id.tv_commodity_num);
            tvCommodityShowNum = (TextView) itemView.findViewById(R.id.tv_commodity_show_num);
            tvCommodityDelete = (ImageView) itemView.findViewById(R.id.tv_commodity_delete);
            rlEdit = (LinearLayout) itemView.findViewById(R.id.rl_edit);


        }
    }
    /**
     * 复选框接口
     */
    public interface CheckInterface {
        /**
         * 组选框状态改变触发的事件
         *
         * @param position  元素位置
         * @param isChecked 元素选中与否
         */
        void checkGroup(int position, boolean isChecked);
    }


    /**
     * 改变数量的接口
     */
    public interface ModifyCountInterface {
        /**
         * 增加操作
         *
         * @param position      元素位置
         * @param showCountView 用于展示变化后数量的View
         * @param isChecked     子元素选中与否
         */
        void doIncrease(int position, View showCountView, boolean isChecked);

        /**
         * 删减操作
         *
         * @param position      元素位置
         * @param showCountView 用于展示变化后数量的View
         * @param isChecked     子元素选中与否
         */
        void doDecrease(int position, View showCountView, boolean isChecked);

        /**
         * 删除子item
         *
         * @param position
         */
        void childDelete(int position);
    }
}
