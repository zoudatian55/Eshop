package com.example.administrator.eshop;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.eshop.core.AccessTokenKeeper;
import com.example.administrator.eshop.core.Constants;
import com.example.administrator.eshop.utils.PreferencesUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.UsersAPI;
import com.sina.weibo.sdk.openapi.models.ErrorInfo;
import com.sina.weibo.sdk.openapi.models.User;
import com.sina.weibo.sdk.utils.LogUtil;


public class LoginActivity extends Activity{
    private ImageButton ib_weibo;
    /** 注意：SsoHandler 仅当 SDK 支持 SSO 时有效 */
    private SsoHandler mSsoHandler;
    /** 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能  */
    private Oauth2AccessToken mAccessToken;
    private AuthInfo mAuthInfo;
    private UsersAPI mUsersAPI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuthInfo = new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
        mSsoHandler = new SsoHandler(LoginActivity.this, mAuthInfo);

        ib_weibo = (ImageButton) findViewById(R.id.ib_weibo);
        ib_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSsoHandler.authorize(new AuthListener());
            }
        });
    }

    private   class AuthListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle values) {
            // 从 Bundle 中解析 Token
            mAccessToken = Oauth2AccessToken.parseAccessToken(values);
            //从这里获取用户输入的 电话号码信息
            if (mAccessToken.isSessionValid()) {
                // 显示 Token
                // 保存 Token 到 SharedPreferences
                AccessTokenKeeper.writeAccessToken(LoginActivity.this, mAccessToken);
                Toast.makeText(LoginActivity.this,
                        R.string.weibosdk_demo_toast_auth_success, Toast.LENGTH_SHORT).show();
//
                getUserInfo();
                finish();
            } else {
                // 以下几种情况，您会收到 Code：
                // 1. 当您未在平台上注册的应用程序的包名与签名时；
                // 2. 当您注册的应用程序包名与签名不正确时；
                // 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
                String code = values.getString("code");
                String message = getString(R.string.weibosdk_demo_toast_auth_failed);
                if (!TextUtils.isEmpty(code)) {
                    message = message + "\nObtained the code: " + code;
                }
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {
            Toast.makeText(LoginActivity.this,
                    "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(LoginActivity.this,
                    R.string.weibosdk_demo_toast_auth_canceled, Toast.LENGTH_LONG).show();
        }
    }

    private void getUserInfo() {
        //获取用户信息接口
        mUsersAPI=new UsersAPI(LoginActivity.this,Constants.APP_KEY,mAccessToken);
        //调用接口
        long uid = Long.parseLong(mAccessToken.getUid());
        mUsersAPI.show(uid, mListener);
    }


    private RequestListener mListener = new RequestListener() {
        @Override
        public void onComplete(String response) {
            if (!TextUtils.isEmpty(response)) {
                // 调用 User#parse 将JSON串解析成User对象
                User user = User.parse(response);
                if (user != null) {
                    Toast.makeText(getApplicationContext(),user.avatar_large,Toast.LENGTH_SHORT).show();
//                   PreferencesUtils.putString(getApplicationContext(),"user_name",user.screen_name);
//                    PreferencesUtils.putString(getApplicationContext(),"user_photo",user.avatar_large);
                    MyAppliction appliction = MyAppliction.getInstance();
                    appliction.putUser(user,mAccessToken.getToken());



                } else {
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
                }
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {
            ErrorInfo info = ErrorInfo.parse(e.getMessage());
            Toast.makeText(LoginActivity.this, info.toString(), Toast.LENGTH_LONG).show();
        }
    };
//


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }
}
