package com.aspsine.mobi.androidmvpdemos.demo3.presenter;

import android.app.Activity;

/**
 * Created by hzf on 2017/3/1 0001.
 * 适配器中的MVP使用
 */

public interface IAdapterPresenter {
    void  loadDatas();
    void  loadMoreData(String item);
    Activity getActivity();
    void  showFotterView(Boolean isShow);
}
