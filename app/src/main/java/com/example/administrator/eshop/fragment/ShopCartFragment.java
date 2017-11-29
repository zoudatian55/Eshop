package com.example.administrator.eshop.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.eshop.R;
import com.example.administrator.eshop.adapter.ShopCartAdapter;
import com.example.administrator.eshop.adapter.ShoppingCartAdapter;
import com.example.administrator.eshop.bean.GoodDetailBean;
import com.example.administrator.eshop.utils.CartProvider;

import java.io.Serializable;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCartFragment extends Fragment implements View.OnClickListener
        , ShoppingCartAdapter.CheckInterface, ShoppingCartAdapter.ModifyCountInterface{
//    private View view;
//   private View cartview;
//    private List<GoodDetailBean> good;
//    private TextView tvShopcartEdit;
//    private RecyclerView recyclerview;
//    private LinearLayout llCheckAll;
//    private CheckBox checkboxAll;
//    private TextView tvShopcartTotal;
//    private LinearLayout llDelete;
//    private CheckBox cbAll;
//    private Button btnDelete;
//    private Button btnCollection;
//    private ImageView ivEmpty;
//    private TextView tvEmptyCartTobuy;
//    private LinearLayout ll_empty_shopcart;
//    private ShopCartAdapter adapter;
//    private Context mContext;
//    //编辑状态
//    private static final int ACTION_EDIT = 1;
//    //完成状态
//    private static final int ACTION_COMPLETE = 2;
//
//
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//         mContext=getContext();
//        view = inflater.inflate(R.layout.fragment_shop_cart, null);
//        tvShopcartEdit = (TextView)view.findViewById( R.id.tv_shopcart_edit );
//        recyclerview = (RecyclerView)view.findViewById( R.id.recyclerview );
//        llCheckAll = (LinearLayout)view.findViewById( R.id.ll_check_all );
//        checkboxAll = (CheckBox)view.findViewById( R.id.checkbox_all );
//        tvShopcartTotal = (TextView)view.findViewById( R.id.tv_shopcart_total );
//        llDelete = (LinearLayout)view.findViewById( R.id.ll_delete );
//        cbAll = (CheckBox)view.findViewById( R.id.cb_all );
//        btnDelete = (Button)view.findViewById( R.id.btn_delete );
//        btnCollection = (Button)view.findViewById( R.id.btn_collection );
//        ivEmpty = (ImageView)view.findViewById( R.id.iv_empty );
//        tvEmptyCartTobuy = (TextView)view.findViewById( R.id.tv_empty_cart_tobuy );
//        ll_empty_shopcart= (LinearLayout) view.findViewById(R.id.ll_empty_shopcart);
//        initData();
//        initListenter();
//        btnDelete.setOnClickListener( this );
//        btnCollection.setOnClickListener( this );
//        return view;
//    }
//
//    private void initListenter() {
//
//        tvShopcartEdit.setTag(ACTION_EDIT);
//        tvShopcartEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int action = (int) v.getTag();
//                if (action == ACTION_EDIT) {
//                    //切换为完成状态
//                    showDelete();
//                } else {
//                    //切换成编辑状态
//                    hideDelete();
//                }
//            }
//        });
//
//    }
//
//    private void hideDelete() {
//        //1.设置状态和文本-编辑
//        tvShopcartEdit.setTag(ACTION_EDIT);
//        tvShopcartEdit.setText("编辑");
//        //2.变成非勾选
//        if (adapter != null) {
//            adapter.checkAll_none(true);
//            adapter.checkAll();
//            adapter.showTotalPrice();
//        }
//        //3.删除视图显示
//        llDelete.setVisibility(View.GONE);
//        //4.结算视图隐藏
//        llCheckAll.setVisibility(View.VISIBLE);
//    }
//
//    private void showDelete() {
//        //1.设置状态和文本-完成
//        tvShopcartEdit.setTag(ACTION_COMPLETE);
//        tvShopcartEdit.setText("完成");
//        //2.变成非勾选
//        if (adapter != null) {
//            adapter.checkAll_none(false);
//            adapter.checkAll();
//        }
//        //3.删除视图显示
//        llDelete.setVisibility(View.VISIBLE);
//        //4.结算视图隐藏
//        llCheckAll.setVisibility(View.GONE);
//
//
//    }
//
//
//    /**
//     * 模拟数据<br>
//     * 遵循适配器的数据列表填充原则，组元素被放在一个list中，对应着组元素的下辖子元素被放在Map中
//     * 其Key是组元素的Id
//     */
//    private void initData() {
//        CartProvider provider = CartProvider.getInstance();
//        good = provider.getAllData();
//
//        if(this.good !=null&& this.good.size()>0){
//            tvShopcartEdit.setVisibility(View.VISIBLE);
//            llCheckAll.setVisibility(View.VISIBLE);
//            //有数据，把当前数据显示的布局
//            ll_empty_shopcart.setVisibility(View.GONE);
//            //设置适配器
//            adapter=new ShopCartAdapter(mContext, this.good,tvShopcartTotal,checkboxAll,cbAll);
//            recyclerview.setAdapter(adapter);
//            recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL, false));
//
//        }else{
//            //没有数据
//            emptyShoppingcart();
//        }
//
//    }
//
//    private void emptyShoppingcart() {
//        ll_empty_shopcart.setVisibility(View.VISIBLE);
//        tvShopcartEdit.setVisibility(View.GONE);
//        llDelete.setVisibility(View.GONE);
//    }
//
//
//    @Override
//    public void onClick(View v) {
////        if (v == btnDelete) {
//////            // Handle clicks for btnCheckOut
//////            //结算
//////            pay(v);
////        } else
//               if (v == btnDelete) {
//            // Handle clicks for btnDelete
//            //删除选中的
//            adapter.deleteData();
//            //校验状态
//            adapter.checkAll();
//            //数据大小为0
//            if(adapter.getItemCount()==0){
//                emptyShoppingcart();
//            }
//
//        } else if (v == btnCollection) {
//            // Handle clicks for btnCollection
//        }
//}
//    @Override
//    public void onResume() {
//        super.onResume();
//        initData();
//    }


    private View view;
    private TextView bt_header_right;
    private LinearLayout  ll_detail;
    private LinearLayout  ll_empty_shopcart;
    Button btnBack;
    private Button btn_empty_cart_tobuy;
    //全选
    CheckBox ckAll;
    //总额
    TextView tvShowPrice;
    //结算
    TextView tvSettlement;
    //编辑
    TextView btnEdit;//tv_edit

    ListView list_shopping_cart;
    private ShoppingCartAdapter shoppingCartAdapter;
    private boolean flag = false;
  //  private List<ShoppingCartBean> data = new ArrayList<>();
    private List<GoodDetailBean> data;
    private boolean mSelect;
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_shopping_cart_activity);
//        initView();
//        ImageLoader imageLoader=ImageLoader.getInstance();
//        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_cart_shop,null);
        initView();
        return view;
    }

    private void initView() {

        ckAll= (CheckBox)view. findViewById(R.id.ck_all);
        tvShowPrice= (TextView) view.findViewById(R.id.tv_show_price);
        tvSettlement= (TextView)view. findViewById(R.id.tv_settlement);
        bt_header_right= (TextView) view.findViewById(R.id.bt_header_right);
        btnEdit= (TextView) view.findViewById(R.id.bt_header_right);
        list_shopping_cart= (ListView)view. findViewById(R.id.list_shopping_cart);
        ll_detail= (LinearLayout) view.findViewById(R.id.ll_detail);
        ll_empty_shopcart= (LinearLayout) view.findViewById(R.id.ll_empty_shopcart);
        btn_empty_cart_tobuy= (Button) view.findViewById(R.id.btn_empty_cart_tobuy);
        btnEdit.setOnClickListener(this);
        ckAll.setOnClickListener(this);
        tvSettlement.setOnClickListener(this);
        btn_empty_cart_tobuy.setOnClickListener(this);
//        btnBack.setOnClickListener(this);

        initData();
    }
    //初始化数据
    protected void initData() {
        data = CartProvider.getInstance().getAllData();
        shoppingCartAdapter = new ShoppingCartAdapter(getContext());
        shoppingCartAdapter.setCheckInterface(this);
        shoppingCartAdapter.setModifyCountInterface(this);
        list_shopping_cart.setAdapter(shoppingCartAdapter);

        if(data.size()==0){
               emptyShoppingcart();
           }else{
            shoppingCartAdapter.setGoodDetailBeanList(data);


        }
    }

    private void emptyShoppingcart() {
        ll_empty_shopcart.setVisibility(View.VISIBLE);
        ll_detail.setVisibility(View.GONE);
        bt_header_right.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //全选按钮
            case R.id.ck_all:
                if (data.size() != 0) {
                    if (ckAll.isChecked()) {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setChecked(true);
                        }
                        shoppingCartAdapter.notifyDataSetChanged();
                    } else {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setChecked(false);
                        }
                        shoppingCartAdapter.notifyDataSetChanged();
                    }
                }
                statistics();
                break;
            case R.id.bt_header_right:
                flag = !flag;
                if (flag) {
                    btnEdit.setText("完成");
                    shoppingCartAdapter.isShow(false);
                } else {
                    btnEdit.setText("编辑");
                    shoppingCartAdapter.isShow(true);
                }
                break;
            case R.id.tv_settlement: //结算
             //   lementOnder();
                Toast.makeText(getContext(), "结算", Toast.LENGTH_SHORT).show();
                //需要集成支付宝或者微信支付
                break;

            case R.id.btn_empty_cart_tobuy:
                //跳转到首页
                ShopFragment shopfragment = (ShopFragment) getParentFragment();
                shopfragment.getShopHome();


        }
    }

    /**
     * 结算订单、支付
     */
//    private void lementOnder() {
//        //选中的需要提交的商品清单
//        for (GoodDetailBean bean:data ){
//            boolean choosed = bean.isChecked();
//            if (choosed){
//                String shoppingName = bean.getDatas().getStore_info().getStore_name();
//                int count = bean.getCount();
//                double price = Double.valueOf(bean.getDatas().getGoods_info().getGoods_price());
//                String attribute = bean.getAttribute();
//                int id = bean.getId();
//                Log.d(TAG,id+"----id---"+shoppingName+"---"+count+"---"+price+"--size----"+size+"--attr---"+attribute);
//            }
//        }
//        ToastUtil.showL(this,"总价："+totalPrice);
//
//        //跳转到支付界面
//    }
    /**
     * 单选
     * @param position  组元素位置
     * @param isChecked 组元素选中与否
     */

    public void checkGroup(int position, boolean isChecked) {
        data.get(position).setChecked(isChecked);
        if (isAllCheck())
            ckAll.setChecked(true);
        else
            ckAll.setChecked(false);
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }
    /**
     * 遍历list集合
     * @return
     */
    private boolean isAllCheck() {

        for (GoodDetailBean group : data) {
            if (!group.isChecked())
                return false;
        }
        return true;
    }
    /**
     * 统计操作
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作
     * 3.给底部的textView进行数据填充
     */
    public void statistics() {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < data.size(); i++) {
            GoodDetailBean bean = data.get(i);
//            ShoppingCartBean shoppingCartBean = data.get(i);
            if (bean.isChecked()) {
                totalCount++;
                totalPrice = totalPrice +Double.valueOf( bean.getDatas().getGoods_info().getGoods_price()) * bean.getCount();
            }
        }
        tvShowPrice.setText("合计:" + totalPrice);
        tvSettlement.setText("结算(" + totalCount + ")");
    }
    /**
     * 增加
     * @param position      组元素位置
     * @param showCountView 用于展示变化后数量的View
     * @param isChecked     子元素选中与否
     */

    public void doIncrease(int position, View showCountView, boolean isChecked) {
       // ShoppingCartBean shoppingCartBean = data.get(position);
        GoodDetailBean detailBean = data.get(position);
        int currentCount = detailBean.getCount();
        currentCount++;
        detailBean.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }
    /**
     * 删减
     *
     * @param position      组元素位置
     * @param showCountView 用于展示变化后数量的View
     * @param isChecked     子元素选中与否
     */

    public void doDecrease(int position, View showCountView, boolean isChecked) {
        GoodDetailBean shoppingCartBean = data.get(position);
        int currentCount = shoppingCartBean.getCount();
        if (currentCount == 1) {
            return;
        }
        currentCount--;
        shoppingCartBean.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }
    /**
     * 删除
     *
     * @param position
     */

    public void childDelete(int position) {
        data.remove(position);
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }

}
