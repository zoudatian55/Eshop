package com.example.administrator.eshop.goodsfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.eshop.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsCommentFragment extends Fragment {


    public GoodsCommentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_goods_comment, container, false);
    }

}
