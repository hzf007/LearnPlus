package com.aspsine.mobi.androidmvpdemos.demo0.view;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public interface LoginView {
    //登录成功后跳转到首页
    void moveToIndex();

    //Toast
    void showToast(String msg);

    //获取界面的姓名
    String getName();

    //获取界面的密码
    String getPassword();
}
