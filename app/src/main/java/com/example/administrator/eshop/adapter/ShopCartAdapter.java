package com.example.administrator.eshop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.bean.GoodDetailBean;
import com.example.administrator.eshop.utils.CartProvider;
import com.example.administrator.eshop.weight.NumberAddSubView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17 0017.
 */

public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.ViewHolder> {
    private final Context mContext;
    private final List<GoodDetailBean> datas;
    private final TextView tvShopcartTotal;
    private final CheckBox checkboxAll;
    //完成状态下的删除CheckBox
    private final CheckBox cbAll;
    private    double totalPrice=0.0;



    public ShopCartAdapter(Context mContext, List<GoodDetailBean> good, TextView tvShopcartTotal, CheckBox checkboxAll, CheckBox cbAll) {
        this.mContext = mContext;
        this.datas = good;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxAll = checkboxAll;
        this.cbAll = cbAll;
        showTotalPrice();
        setListener();
        //检验是否为全选
        checkAll();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=View.inflate(mContext, R.layout.shopcart_item,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
         final GoodDetailBean bean = datas.get(position);
        holder.storeName.setText(bean.getDatas().getStore_info().getStore_name());
       holder.cbGov.setChecked(!bean.isChecked());
//        Glide.with(mContext).load(bean.getDatas().getSpec_image()).into(holder.ivGov);
        Glide.with(mContext).load(bean.getDatas().getSpec_image().get(0)).into(holder.iv_gov);
        holder.tvDescGov.setText(bean.getDatas().getGoods_info().getGoods_name());
        holder.tvPriceGov.setText("¥"+bean.getDatas().getGoods_info().getGoods_price());
        if(bean.getDatas().getGoods_info().getSpec_name()==null&&bean.getDatas().getGoods_info().getSpec_value()==null){
            holder.tv_name.setText("");
            holder.tv_value.setText("");
        }else{
            holder.tv_name.setText(bean.getDatas().getGoods_info().getSpec_name().toString());
            holder.tv_name.setText(bean.getDatas().getGoods_info().getSpec_value().toString());
        }
        holder.addSubView.setValue(bean.getCount());
        holder.addSubView.setMinValue(1);
        holder.addSubView.setMaxValue(10);
        //设置商品数量的变化
      holder.addSubView.setOnNumberChangeListener(new NumberAddSubView.OnNumberChangeListener() {
          @Override
          public void onNumberChange(int value) {
              bean.setCount(value);
              //2本地要更新
              CartProvider.getInstance().updataData(bean);
              //3.刷新适配器
              notifyItemChanged(position);
              //4.再次计算总价格
              showTotalPrice();

          }
      });
//     holder.cbGov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//         @Override
//         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//             if(b){
//                 datas.get(position).setChecked(true);
//                 holder.cbGov.setChecked(true);
//                 showTotalPrice();
//             }else{
//                 datas.get(position).setChecked(false);
//                 holder.cbGov.setChecked(false);
//             }
//         }
//     });






    }

    private void checkTotalPrice() {
        showTotalPrice();

    }


    public void deleteData(){
        if(datas != null && datas.size() >0){
            for (int i=0;i<datas.size();i++){
                //删除选中的
                GoodDetailBean goodsBean = datas.get(i);
                if(goodsBean.isChecked()){
                    //内存-把移除
                    datas.remove(goodsBean);
                    //保持到本地
                    CartProvider.getInstance().deleteData(goodsBean);
                    //刷新
                    notifyItemRemoved(i);
                    i--;
                }
            }
        }
    }



    @Override
    public int getItemCount() {
        return datas.size();
    }
    public void checkAll() {
        if(datas!=null&&datas.size()>0){
            int number=0;
            for (int i=0;i<datas.size();i++){
                GoodDetailBean detailBean = datas.get(i);
                if(!detailBean.isChecked()){
                    //非全选
                    checkboxAll.setChecked(false);
                    cbAll.setChecked(false);
                }else{
                    //选中的
                    number++;
                }
            }
            if(number==datas.size()){
                //全选
                checkboxAll.setChecked(true);
                cbAll.setChecked(true);
            }
        }else{
            checkboxAll.setChecked(false);
            cbAll.setChecked(false);
        }
    }

    public void setListener() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                GoodDetailBean bean = datas.get(position);
                //设置反选状态
                bean.setChecked(!bean.isChecked());

                //刷新状态
                notifyItemChanged(position);
                //检验是否为全选
                checkAll();
                //重新计算总价格
                showTotalPrice();
            }
        });
        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //得到状态
                boolean isCheck = checkboxAll.isChecked();
                //根据状态设置全选和非全选
                checkAll_none(isCheck);

            }
        });

    }

    public void checkAll_none(boolean isCheck) {
        if(datas!=null&&datas.size()>0){
            for (int i=0;i>datas.size();i++){
                GoodDetailBean detailBean = datas.get(i);
                detailBean.setChecked(isCheck);
                notifyItemChanged(i);
            }

        }
    }

    public void showTotalPrice() {
        tvShopcartTotal.setText("合计："+getTotalPrice());

    }

    public double getTotalPrice() {

        if(datas!=null&&datas.size()>0){
            for (int i=0;i<datas.size();i++){
                GoodDetailBean detailBean = datas.get(i);
                if(detailBean.isChecked()){
                    totalPrice=totalPrice+Double.valueOf(detailBean.getDatas().getGoods_info().getGoods_price())*Double.valueOf(detailBean.getCount());
                }
            }

        }
        return totalPrice;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView storeName;
        private CheckBox cbGov;
        private ImageView iv_gov;
        private TextView tvDescGov;
        private TextView tvPriceGov;
        private  TextView tv_name;
        private TextView tv_value;
        private NumberAddSubView addSubView;

        public ViewHolder(View itemView) {
            super(itemView);
            //店铺名
            storeName = (TextView)itemView.findViewById( R.id.store_name );
            cbGov = (CheckBox)itemView.findViewById( R.id.cb_gov );
            //展示图片
            iv_gov = (ImageView)itemView.findViewById( R.id.iv_gov );
            //标题
            tvDescGov = (TextView)itemView.findViewById( R.id.tv_desc_gov );
            //价格
            tvPriceGov = (TextView)itemView.findViewById( R.id.tv_price_gov );
            //规格
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_value= (TextView) itemView.findViewById(R.id.tv_value);
            addSubView = (NumberAddSubView)itemView.findViewById( R.id.addSubView );
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });


        }

    }

    /**
     * 点击item的监听者
     */
    public interface  OnItemClickListener{
        /**
         * 当点击某条的时候被回调
         * @param position
         */
        public void  onItemClick( int position);
    }
    private OnItemClickListener onItemClickListener;

    /**
     * 设置item的监听
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



}
