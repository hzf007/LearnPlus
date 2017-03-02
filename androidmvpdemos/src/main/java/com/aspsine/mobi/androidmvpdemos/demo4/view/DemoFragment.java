package com.aspsine.mobi.androidmvpdemos.demo4.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo4.adapter.MyAdapter;
import com.aspsine.mobi.androidmvpdemos.demo4.event.FragmentGetDatasEvent;
import com.aspsine.mobi.androidmvpdemos.demo4.presenter.FragmentPresenterCompl;
import com.aspsine.mobi.androidmvpdemos.demo4.presenter.IFragmentPresenter;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class DemoFragment extends Fragment implements  IFragmentView {
    private static final String BUNDLE_INDEX = "BUNDLE_INDEX";

    private int index;

    private MyAdapter adapter;
    private IFragmentPresenter iFragmentPresenter;

    public  static  DemoFragment newInstance(int index){
        DemoFragment demoFragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_INDEX,index);
        demoFragment.setArguments(bundle);
        return  demoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            index = getArguments().getInt(BUNDLE_INDEX);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo,container,false);
        //
        EventBus.getDefault().register(this);
        //
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_home);
        //
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        iFragmentPresenter = new FragmentPresenterCompl(this);
        adapter = new MyAdapter(iFragmentPresenter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(),"Tab "+index+" : "+(String)adapter.getItem(position),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    // EventBus Subscribe
    public void onEvent(FragmentGetDatasEvent getDatasEvent){
        if (getDatasEvent!=null && getDatasEvent.getDatas()!=null && getDatasEvent.getDatas().size()>0){
            adapter.setDatas(getDatasEvent.getDatas());
        }
    }
}
