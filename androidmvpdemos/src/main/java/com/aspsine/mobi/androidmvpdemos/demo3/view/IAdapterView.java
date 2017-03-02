package com.aspsine.mobi.androidmvpdemos.demo3.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public interface IAdapterView {
    void  getDataList(List<String> datas);
    void  loadMoreData(String item);
    void  toast(String msg);
    Activity getActivity();
    void showFooterView(Boolean isShow);
}
