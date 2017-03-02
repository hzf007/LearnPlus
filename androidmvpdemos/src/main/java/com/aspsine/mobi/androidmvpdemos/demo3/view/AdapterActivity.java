package com.aspsine.mobi.androidmvpdemos.demo3.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo3.adapter.CustomAdapter;
import com.aspsine.mobi.androidmvpdemos.demo3.presenter.AdapterPresenterImpl;
import com.aspsine.mobi.androidmvpdemos.demo3.presenter.IAdapterPresenter;

import java.util.List;

public class AdapterActivity extends Activity implements IAdapterView,AdapterView.OnItemClickListener {
    private ListView listView;
    private View footerViewVisiable;
    private IAdapterPresenter adapterPresenter;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        listView = (ListView) findViewById(R.id.list_home);
        listView.setOnItemClickListener(this);
        //init
        listView.setDivider(null);
        View loadView = LayoutInflater.from(this).inflate(R.layout.item_empty_view,null);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_adapter);
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        viewGroup.addView(loadView,layoutParams);
        listView.setEmptyView(loadView);
        View footerView = LayoutInflater.from(this).inflate(R.layout.item_footer,null);
        listView.addFooterView(footerView);
        footerViewVisiable = findViewById(R.id.layout_visible);
        adapterPresenter = new AdapterPresenterImpl(this);
        adapterPresenter.showFotterView(false);

        //
        adapter = new CustomAdapter(adapterPresenter);
        listView.setAdapter(adapter);
        adapterPresenter.loadDatas();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        toast(adapter.getItem(position));
    }

    @Override
    public void getDataList(List<String> datas) {
        adapter.setDatas(datas);
    }

    @Override
    public void loadMoreData(String item) {
        adapter.addItem(item);
        adapterPresenter.showFotterView(false);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, "AdapterActivityA : "+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showFooterView(Boolean isShow) {
        if (isShow) {
            footerViewVisiable.setVisibility(View.VISIBLE);
        } else {
            footerViewVisiable.setVisibility(View.GONE);
        }
    }
}
