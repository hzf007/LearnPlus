package com.aspsine.mobi.androidmvpdemos.demo4.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo4.event.FragmentGetDatasEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class ActivityPresenterCompl implements IActivityPresenter {

    Context context;

    public ActivityPresenterCompl(Context context) {
        this.context = context;
    }

    @Override
    public void loadDatas() {
        String[] contries = context.getResources().getStringArray(R.array.countries);
        final List<String> datas = new ArrayList<>();
        Collections.addAll(datas,contries);

        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentGetDatasEvent event = new FragmentGetDatasEvent(datas);
                EventBus.getDefault().post(event);
            }
        },2000);
    }
}
