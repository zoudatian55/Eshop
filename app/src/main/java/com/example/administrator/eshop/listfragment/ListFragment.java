package com.example.administrator.eshop.listfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodInfoActivity;
import com.example.administrator.eshop.adapter.GoodListAdapter;
import com.example.administrator.eshop.bean.ListGoodListBean;
import com.example.administrator.eshop.utils.Contants;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private ListView listView;
    private String url;
    private int curr=1;
    private String data;
    private  List<ListGoodListBean.DatasBean.GoodsListBean> goods_list;
    private GoodListAdapter adapter;
    private String good_list_id;
    private PullToRefreshListView pull_refresh_list;
    private boolean isLoadMore=false;
    private String datas;


    public ListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_list,null);
        pull_refresh_list= (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
//        listView= (ListView) view.findViewById(R.id.listview);
        listView=pull_refresh_list.getRefreshableView();



        initData();
        pull_refresh_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                getDataForNet();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                  getMoreDataForNet();
            }
        });
        return view;
    }

    private void getMoreDataForNet() {
        curr=curr+1;
        good_list_id=getActivity().getIntent().getStringExtra("good_list_id");
        url= Contants.GOOD_LIST_URL+good_list_id+Contants.GOOD_LIST_SUFFIX + Contants.CURRENT+ curr + Contants.PAGE;
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().
                get().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "网络请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                datas = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pull_refresh_list.onRefreshComplete();
                        isLoadMore=true;
                        process(datas);

                    }
                });

            }
        });


    }

    private void initData() {
        good_list_id=getActivity().getIntent().getStringExtra("good_list_id");
        url= Contants.GOOD_LIST_URL+good_list_id+Contants.GOOD_LIST_SUFFIX + Contants.CURRENT + curr + Contants.PAGE;
        getDataForNet();
    }

    private void getDataForNet() {

//        url= Contants.GOOD_LIST_URL+good_list_id+Contants.GOOD_LIST_SUFFIX + Contants.CURRENT + curr + Contants.PAGE;
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().
                get().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               Toast.makeText(getActivity(), "网络请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        process(data);
                        pull_refresh_list.onRefreshComplete();

                    }
                });

            }
        });

    }

    private void process(String data) {
        ListGoodListBean.DatasBean bean = prase(data).getDatas();
        if(!isLoadMore){
            //第一次  未加载更多;
             goods_list = bean.getGoods_list();
            adapter=new GoodListAdapter(getContext(),goods_list);
            listView.setAdapter(adapter);


        }else{
            //加载更多
            isLoadMore=false;
            goods_list.addAll(bean.getGoods_list());
            adapter.notifyDataSetChanged();
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Intent intent=new Intent(getContext(), GoodInfoActivity.class);
//                    intent.putExtra("good_id",good_list_id);
//                    getContext().startActivity(intent);
//                }
//            });
        }


    }
//
//    private void showList() {
//
//
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Intent intent=new Intent(getContext(), GoodInfoActivity.class);
////               intent.putExtra("good_id",good_list_id);
////               getContext().startActivity(intent);
////            }
////        });
//
//    }

    private ListGoodListBean prase(String data) {

        return new Gson().fromJson(data,ListGoodListBean.class);

    }

    }

