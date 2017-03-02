package com.aspsine.mobi.androidmvpdemos.demo3.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.aspsine.mobi.androidmvpdemos.demo3.view.IAdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public class AdapterPresenterImpl implements IAdapterPresenter {
    List<String> datas;
    IAdapterView adapterView;

    public AdapterPresenterImpl(IAdapterView adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void loadDatas() {
        String[] countries = new String[]{"Kaede Akatsuki", "Loves", "Neko Tattsun", "Deeply"};
        datas = new ArrayList<>();
        for (String country : countries) {
            datas.add(country);
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapterView.getDataList(datas);
            }
        }, 2000);
    }

    @Override
    public void loadMoreData(final String item) {
        adapterView.showFooterView(true);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapterView.loadMoreData(item);
            }
        }, 2000);
    }

    @Override
    public Activity getActivity() {
        return adapterView.getActivity();
    }

    @Override
    public void showFotterView(Boolean isShow) {
        adapterView.showFooterView(isShow);
    }
}
