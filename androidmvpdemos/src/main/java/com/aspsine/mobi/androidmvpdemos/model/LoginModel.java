package com.aspsine.mobi.androidmvpdemos.model;

import com.aspsine.mobi.androidmvpdemos.listener.OnLoginFinishedListener;

/**
 * Created by hzf on 2017/3/1 0001.
 * 模拟登陆的操作的接口，实现类为LoginModelImpl.相当于MVP模式中的Model层
 */

public interface LoginModel {
    void  login(String username, String password, OnLoginFinishedListener listener);
}
