package com.aspsine.mobi.androidmvpdemos.demo5.view;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo5.event.GetDatasEvent;
import com.aspsine.mobi.androidmvpdemos.demo5.event.ToastEvent;
import com.aspsine.mobi.androidmvpdemos.demo5.presenter.EventBusPresenterCompl;
import com.aspsine.mobi.androidmvpdemos.demo5.presenter.IEventBusPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class EventBusActivity extends ActionBarActivity implements AdapterView.OnItemClickListener,IEventBusView {
    private IEventBusPresenter iEventBusPresenter;
    List<String> datas = new ArrayList<>();
    private BaseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        //register
        EventBus.getDefault().register(this);

        //find view
        ListView listView = (ListView) this.findViewById(R.id.list_home);

        //set listener
        listView.setOnItemClickListener(this);


        //init
        View loadingView = LayoutInflater.from(this).inflate(R.layout.item_empty_view, null);
        ViewGroup viewGroup = (ViewGroup) this.findViewById(R.id.layout_home);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        viewGroup.addView(loadingView, layoutParams);
        listView.setEmptyView(loadingView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
        iEventBusPresenter = new EventBusPresenterCompl(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        iEventBusPresenter.loadDatas();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        iEventBusPresenter.onItemClick(position);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
    // EventBus Subscribe
    public void onEvent(ToastEvent toastEvent){
        if (toastEvent!=null&&toastEvent.getMsg()!=null){
            Toast.makeText(this,toastEvent.getMsg(),Toast.LENGTH_SHORT).show();
        }
    }

    // EventBus Subscribe
    public void onEvent(GetDatasEvent getDatasEvent){
        if (getDatasEvent!=null && getDatasEvent.getDatas()!=null && getDatasEvent.getDatas().size()>0){
            this.datas.clear();
            this.datas.addAll(getDatasEvent.getDatas());
            adapter.notifyDataSetChanged();
        }
    }
}
