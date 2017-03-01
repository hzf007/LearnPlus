package com.aspsine.mobi.androidmvpdemos.demo2.model;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public interface LoginModel {
    String getName();

    String getPassword();

    int  checkUserValidity(String username,String password);
}
