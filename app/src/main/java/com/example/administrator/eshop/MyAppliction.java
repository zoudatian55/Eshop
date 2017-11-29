package com.example.administrator.eshop;

import android.app.Application;
import android.content.Context;

import com.example.administrator.eshop.utils.UserLocalData;
import com.sina.weibo.sdk.openapi.models.User;

import cn.sharesdk.framework.ShareSDK;


public class MyAppliction extends Application {
    private User user;
    private static  MyAppliction mInstance;


    public static  MyAppliction getInstance(){

        return  mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initUser();


    }

    private void initUser(){

        this.user = UserLocalData.getUser(this);
    }


    public User getUser(){

        return user;
    }


    public void putUser(User user,String token){
        this.user = user;
        UserLocalData.putUser(this,user);
        UserLocalData.putToken(this,token);
    }

    public void clearUser(){
        this.user =null;
        UserLocalData.clearUser(this);
        UserLocalData.clearToken(this);


    }


    public String getToken(){

        return  UserLocalData.getToken(this);
    }


}
