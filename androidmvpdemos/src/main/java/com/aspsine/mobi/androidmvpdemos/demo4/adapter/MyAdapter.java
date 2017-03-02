package com.aspsine.mobi.androidmvpdemos.demo4.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo4.presenter.IFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    IFragmentPresenter iFragmentPresenter;
    List<String> datas;


    public MyAdapter(IFragmentPresenter iFragmentPresenter) {
        this.iFragmentPresenter = iFragmentPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<String> datas){
        if (datas != null && datas.size() > 0){
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }

    public String getItem( int position){
        return datas.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview,null,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
        holder.mTextView.setText(datas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFragmentPresenter.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_recyclerview_item);
        }
    }
}
