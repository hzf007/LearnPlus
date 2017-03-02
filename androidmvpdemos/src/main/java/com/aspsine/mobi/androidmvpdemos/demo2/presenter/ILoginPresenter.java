package com.aspsine.mobi.androidmvpdemos.demo2.presenter;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public interface ILoginPresenter {
    void  clear();
    void  doLogin(String name,String password);
    void setProgressBarVisiblity(int visiblity);
    void onDestroy();
}
