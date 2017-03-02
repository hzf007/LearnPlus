package com.aspsine.mobi.androidmvpdemos.demo3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo3.presenter.IAdapterPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public class CustomAdapter extends BaseAdapter {
    IAdapterPresenter adapterPresenter;
    List<String> datas;

    public CustomAdapter(IAdapterPresenter adapterPresenter) {
        this.adapterPresenter = adapterPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<String> datas) {
        if(datas != null && datas.size() > 0){
             this.datas.clear();
             this.datas.addAll(datas);
             notifyDataSetChanged();
        }
    }

    public  void  addItem(String item){
        datas.add(item);
        notifyDataSetChanged();
    }
    public  void  removeItem(int position){
        if(position >= 0 && position <= datas.size()){
            datas.remove(position);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
             convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outteradapter,null);
        }
        final String text = getItem(position);
        ((TextView)convertView.findViewById(R.id.tv_outter_adapter_text)).setText(text);
        convertView.findViewById(R.id.tv_outter_adapter_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterPresenter.loadMoreData("new " + text);
            }
        });
        convertView.findViewById(R.id.tv_outter_adapter_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
        return convertView;
    }
}
