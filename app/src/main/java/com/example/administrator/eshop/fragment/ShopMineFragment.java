package com.example.administrator.eshop.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.LoginActivity;
import com.example.administrator.eshop.MyAppliction;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.utils.PreferencesUtils;
import com.sina.weibo.sdk.openapi.models.User;



/**
 * A simple {@link Fragment} subclass.
 */
public class ShopMineFragment extends Fragment {
    private ImageButton ib_touxiang;
    private TextView tv_mine_name;


    public ShopMineFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_shop_mine,null);
        ib_touxiang= (ImageButton) view.findViewById(R.id.ib_touxiang);
        tv_mine_name= (TextView) view.findViewById(R.id.tv_mine_name);
         showUser();
        return view;
    }

    private void showUser() {
        User user= MyAppliction.getInstance().getUser();
        if(user==null){
            ib_touxiang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(),LoginActivity.class));
                }
            });
        }else{
            if(!TextUtils.isEmpty(user.avatar_large))
                Glide.with(getContext()).load(user.avatar_large).into(ib_touxiang);
               tv_mine_name.setText(user.screen_name);

        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        showUser();
    }
}
