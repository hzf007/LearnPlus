package com.aspsine.mobi.androidmvpdemos.demo1.model;

import android.os.Handler;
import android.text.TextUtils;

import com.aspsine.mobi.androidmvpdemos.demo1.listener.OnLoginFinishedListener;

/**
 * Created by hzf on 2017/3/1 0001.
 * Class Note:延时模拟登陆（2s），如果名字或者密码为空则登陆失败，否则登陆成功
 * 具体的登录操作
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean error = false;
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();//model层里面回调listener
                    error = true;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if(!error){
                    listener.onSuccess();
                }

            }
        },2000);
    }
}
