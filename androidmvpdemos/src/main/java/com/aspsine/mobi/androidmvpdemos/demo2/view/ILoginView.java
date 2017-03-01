package com.aspsine.mobi.androidmvpdemos.demo2.view;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public interface ILoginView {
    public void onClearText();
    public void onLoginResult(Boolean result, int code);
    public void onSetProgressBarVisibility(int visibility);
}
