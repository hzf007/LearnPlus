package com.aspsine.mobi.androidmvpdemos.demo0.model;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public interface LoginModel {
    void  doLogin(String name,String password,OnLoginListener listener);
}
