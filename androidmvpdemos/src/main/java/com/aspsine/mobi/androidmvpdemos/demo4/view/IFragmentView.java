package com.aspsine.mobi.androidmvpdemos.demo4.view;

import android.app.Activity;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public interface IFragmentView {
    Activity getActivity();
    void onItemClick(int position);
}
