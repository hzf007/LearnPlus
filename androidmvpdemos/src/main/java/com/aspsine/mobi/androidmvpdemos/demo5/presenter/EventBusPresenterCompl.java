package com.aspsine.mobi.androidmvpdemos.demo5.presenter;

import android.os.Handler;
import android.os.Looper;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo5.event.GetDatasEvent;
import com.aspsine.mobi.androidmvpdemos.demo5.event.ToastEvent;
import com.aspsine.mobi.androidmvpdemos.demo5.view.IEventBusView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class EventBusPresenterCompl implements  IEventBusPresenter {

    List<String> datas;
    IEventBusView iEventBusView;

    public EventBusPresenterCompl(IEventBusView iEventBusView) {
        this.iEventBusView = iEventBusView;
    }

    @Override
    public void loadDatas() {

        String[] countries = iEventBusView.getActivity().getResources().getStringArray(R.array.countries);
        datas = new ArrayList<>();
        for (String item:countries){
            datas.add(item);
        }

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                GetDatasEvent getDatasEvent = new GetDatasEvent(datas);
                EventBus.getDefault().post(getDatasEvent);
            }
        },2000);
    }

    @Override
    public void onItemClick(int position) {
        ToastEvent toastEvent = new ToastEvent(datas.get(position));
        EventBus.getDefault().post(toastEvent);
    }
}
