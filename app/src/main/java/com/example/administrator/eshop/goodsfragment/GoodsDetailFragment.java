package com.example.administrator.eshop.goodsfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.utils.Contants;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsDetailFragment extends Fragment {
    private WebView webView;


    public GoodsDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_goods_detail,null);
       webView= (WebView) view.findViewById(R.id.webview_detial);
        String good_id = getActivity().getIntent().getStringExtra("good_id");
        webView.loadUrl(Contants.GOOD_DETAIL_DETSIL_URL+good_id);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//把html中的内容放大webview等宽的一列中
        settings.setJavaScriptEnabled(true);//支持js
        settings.setBuiltInZoomControls(true); // 显示放大缩小
        settings.setSupportZoom(true); // 可以缩放
        webView.setWebViewClient(new MyWebClient());
        settings.setCacheMode(settings.LOAD_CACHE_ELSE_NETWORK);
        return view;
    }
    class MyWebClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
            // html加载完成之后，添加监听图片的点击js函数
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



    private void imgReset() {
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");

    }

}

