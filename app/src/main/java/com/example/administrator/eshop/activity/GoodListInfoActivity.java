package com.example.administrator.eshop.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.listfragment.GridFragment;
import com.example.administrator.eshop.listfragment.ListFragment;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.adapter.GoodListAdapter;
import com.example.administrator.eshop.adapter.GridListViewAdapter;
import com.example.administrator.eshop.bean.ListGoodListBean;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

public class GoodListInfoActivity extends AppCompatActivity {
    private ListView good_list_listview;
    private String moreurl;
    private String url;
    private ImageButton ib_list_top;
    private String good_list_id;
    private String data;
    private ImageView ib_list_grid;
    private TextView ranking;
    private TextView priority;
    private TextView classes;
    private boolean Flag = true;
    private GridView good_list_gridview;
    private Context context;
    private int page = 10;
    //private List<GoodListBean.DatasBean.GoodsListBean> goods_list;
    private List<ListGoodListBean.DatasBean.GoodsListBean> good_list;
    private List<ListGoodListBean.DatasBean.GoodsListBean> goods_list;
    private GoodListAdapter adapter;
    private GridListViewAdapter mAdapter;
    private String goods_id;
    private PullToRefreshListView listView;
    private PullToRefreshGridView gridView;
    private int current=1;
    private  FragmentTransaction ft;
    private FragmentManager fm;
    private ListFragment list;
    private GridFragment grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_list_info);
        good_list_id = getIntent().getStringExtra("good_list_id");
        Toast.makeText(this, "id是" + good_list_id, Toast.LENGTH_SHORT).show();
//        listView = (PullToRefreshListView) findViewById(R.id.good_list_listview);
//        ib_list_top = (ImageButton) findViewById(R.id.ib_list_top);
        ib_list_grid = (ImageView) findViewById(R.id.ib_list_grid);
        //综合排序
        ranking = (TextView) findViewById(R.id.ranking);
        //销量优先
        priority = (TextView) findViewById(R.id.priority);
        //筛选
        classes = (TextView) findViewById(R.id.classes);
//        gridView = (PullToRefreshGridView) findViewById(R.id.good_list_gridview);
        context = GoodListInfoActivity.this;
        initView();

    }

    private void initView() {
        fm=getSupportFragmentManager();
        ft=  fm.beginTransaction();
        list=new ListFragment();
        grid=new GridFragment();
        ft.add(R.id.fl_list_grid,list).add(R.id.fl_list_grid,grid);
        showList();
        ft.commit();

        ib_list_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Flag){
                    ib_list_grid.setImageResource(R.drawable.nc_icon_goods_grid);
                    Flag=false;
                    showGrid();

                }else{
                    ib_list_grid.setImageResource(R.drawable.nc_icon_goods_list);
                    Flag=true;
                   showList();
                }
            }


        });
    }

    private void showGrid() {
        getSupportFragmentManager().beginTransaction().show(grid).hide(list).commit();

    }
    private void showList() {
        getSupportFragmentManager().beginTransaction().show(list).hide(grid).commit();

    }


//        ib_list_grid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!Flag) {
//                ib_list_grid.setImageResource(R.drawable.nc_icon_goods_grid);
//                    good_list_listview.setVisibility(View.GONE);
//                    good_list_gridview.setVisibility(View.VISIBLE);
//                    Flag=true;
//                    showGrid();
//                } else {
//                    ib_list_grid.setImageResource(R.drawable.nc_icon_goods_list);
////                    ft.replace(R.id.fl_list_grid, new ListFragment());
////                    ft.commit();
////                    Flag = true;
//                    good_list_listview.setVisibility(View.VISIBLE);
//                    good_list_gridview.setVisibility(View.GONE);
//                    Flag=false;
//                    showList();
//                }
//            }
//        });
//    }
//
//    private void initView() {
//        good_list_listview = listView.getRefreshableView();
//        good_list_gridview = gridView.getRefreshableView();
//        listView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
//        listView.setScrollingWhileRefreshingEnabled(true);
//
//        gridView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
//        gridView.setScrollingWhileRefreshingEnabled(true);
//    }
//    private void showList() {
//        adapter=new GoodListAdapter(context,good_list);
//        good_list_listview.setAdapter(adapter);
//         listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
//             @Override
//             public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//
//             }
//
//             @Override
//             public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
//                 current=current+1;
//                 initData(current);
//                 good_list.addAll(good_list);
//                 adapter.notifyDataSetChanged();
//                 listView.onRefreshComplete();
//
//
//             }
//         });
//
//        good_list_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(context, GoodInfoActivity.class);
//               goods_id= good_list.get(i-1).getGoods_id();
//                intent.putExtra("good_id",goods_id);
//                context.startActivity(intent);
//
//            }
//        });
//
//
//    }
//
//    private void showGrid() {
//        good_list_gridview.setNumColumns(2);
//        mAdapter=new GridListViewAdapter(context,good_list);
//        good_list_gridview.setAdapter(mAdapter);
//        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
//
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
//                current=current+1;
//                initData(current);
//                good_list.addAll(good_list);
//                mAdapter.notifyDataSetChanged();
//                gridView.onRefreshComplete();
//
//            }
//        });
//
//    }
//
//
//
//    private void initData(int curr) {
//        good_list = new ArrayList<>();
//        goods_list=new ArrayList<>();
//        //根据网络请求获取数据
//        url = Contants.GOOD_LIST_URL + good_list_id + Contants.GOOD_LIST_SUFFIX + Contants.CURRENT + curr + Contants.PAGE;
//        Log.e("url", url);
//        OkHttpClient client = new OkHttpClient();
//        final Request request = new Request.Builder().
//                get().url(url).build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Toast.makeText(GoodListInfoActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                data = response.body().string();
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        process(data);
//
//                    }
//                });
//
//            }
//        });
//
//    }
//
//    private void process(String data) {
//        good_list=prase(data).getDatas().getGoods_list();
////        showList();
//        showGrid();
//
//
//
//
//
//
//    }
//
//    private ListGoodListBean prase(String data) {
//
//        return new Gson().fromJson(data,ListGoodListBean.class);
//
//    }

}
