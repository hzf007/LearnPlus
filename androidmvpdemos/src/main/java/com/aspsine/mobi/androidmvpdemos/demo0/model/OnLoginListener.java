package com.aspsine.mobi.androidmvpdemos.demo0.model;

/**
 * Created by hzf on 2017/3/2 0002.
 * 监听器用来处理Model实现后的操作
 */

public interface OnLoginListener{
    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();

    public void onFailure();
}
