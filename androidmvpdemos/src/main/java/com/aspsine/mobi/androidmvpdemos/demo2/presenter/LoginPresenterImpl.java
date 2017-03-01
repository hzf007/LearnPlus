package com.aspsine.mobi.androidmvpdemos.demo2.presenter;

import android.os.Handler;
import android.os.Looper;

import com.aspsine.mobi.androidmvpdemos.demo2.model.LoginModel;
import com.aspsine.mobi.androidmvpdemos.demo2.model.LoginModelImpl;
import com.aspsine.mobi.androidmvpdemos.demo2.view.ILoginView;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    LoginModel loginModel;
    ILoginView loginView;
    Handler handler;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        loginModel = new LoginModelImpl("MVP","MVP");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(final String name, final String password) {
        boolean isLogin = true;
        final int code = loginModel.checkUserValidity(name,password);
        if(code != 0){
            isLogin = false;
        }
        final boolean result = isLogin;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.onLoginResult(result,code);
            }
        },2000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        loginView.onSetProgressBarVisibility(visiblity);
    }
}
