package com.aspsine.mobi.androidmvpdemos.view;

/**
 * Created by hzf on 2017/3/1 0001.
 * Class Note:登陆View的接口，实现类也就是登陆的activity
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
