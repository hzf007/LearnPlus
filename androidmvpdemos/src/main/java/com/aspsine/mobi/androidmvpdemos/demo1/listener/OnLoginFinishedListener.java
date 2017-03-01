package com.aspsine.mobi.androidmvpdemos.demo1.listener;

/**
 * Created by hzf on 2017/3/1 0001.
 * 登陆事件监听
 */

public interface OnLoginFinishedListener {

    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
