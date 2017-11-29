package com.example.administrator.eshop.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodListInfoActivity;
import com.example.administrator.eshop.adapter.CategoryLeftAdapter;
import com.example.administrator.eshop.adapter.CategoryRightAdapter;
import com.example.administrator.eshop.bean.CategoryLeft;
import com.example.administrator.eshop.bean.CategoryRight;
import com.example.administrator.eshop.bean.ListGoodListBean;
import com.example.administrator.eshop.utils.Contants;
import com.google.gson.Gson;

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
public class ShopCategoryFragment extends Fragment {
    private String url;
    private ListView listView;
    private String s;
    private  List<CategoryLeft.DatasBean.ClassListBean> list;
    private Context context;
    private String[] ids=new String[]{
            "2723","2683","3894","2392","2460",
            "2641","3891","2559","3413","2780","3899"
    };
    private String  right_url;
    private ListView rightlistView;
    private String data;
    private  List<CategoryRight.DatasBean.ClassListBean> class_list;
    private CategoryRightAdapter radapter;




    public ShopCategoryFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View  view= inflater.inflate(R.layout.fragment_shop_category,null);
        listView= (ListView) view.findViewById(R.id.category_left);
        rightlistView= (ListView) view.findViewById(R.id.category_right);
        initData();
        return view;
    }

    private void initData() {
        context= getActivity();

        url = Contants.CATEGORY ;
        Log.e("url", url);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().
                get().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 s = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        process(s);
                        getForNetToRight(ids[0]);

                    }
                });

            }
        });

    }

    private void process(String data) {
//        good_list=prase(data).getDatas().getGoods_list();
////        showList();
//        showGrid();
        list = prase(data).getDatas().getClass_list();
        final CategoryLeftAdapter adapter=new CategoryLeftAdapter(context,list);
       listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(context, "点击了第"+i, Toast.LENGTH_SHORT).show();
                String id = ids[i];
              getForNetToRight(id);


            }
        });

    }

    private void getForNetToRight(String id) {
        right_url=Contants.CATEGORY+Contants.CATEGORY_RIGHT+id;
        Log.e("tag",right_url);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().
                get().url(right_url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        processData(data);

                    }
                });

            }
        });



    }

    private void processData(String data) {
           class_list= praseData(data).getDatas().getClass_list();
           radapter=new CategoryRightAdapter(context,class_list);
           rightlistView.setAdapter(radapter);



    }

    private CategoryRight praseData(String datas) {

        return new Gson().fromJson(datas,CategoryRight.class);

    }
    private CategoryLeft prase(String datas) {

        return new Gson().fromJson(datas,CategoryLeft.class);

    }



}
