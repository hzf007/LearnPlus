package com.aspsine.mobi.androidmvpdemos.demo4.presenter;

import com.aspsine.mobi.androidmvpdemos.demo4.view.IFragmentView;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class FragmentPresenterCompl implements IFragmentPresenter {
    IFragmentView iFragmentView;

    public FragmentPresenterCompl(IFragmentView iFragmentView) {
        this.iFragmentView = iFragmentView;
    }

    @Override
    public void onItemClick(int position) {
         iFragmentView.onItemClick(position);
    }
}
