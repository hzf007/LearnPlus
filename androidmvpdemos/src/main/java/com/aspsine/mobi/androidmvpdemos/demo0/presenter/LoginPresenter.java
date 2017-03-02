package com.aspsine.mobi.androidmvpdemos.demo0.presenter;

import com.aspsine.mobi.androidmvpdemos.demo0.model.LoginModel;
import com.aspsine.mobi.androidmvpdemos.demo0.model.LoginModelImpl;
import com.aspsine.mobi.androidmvpdemos.demo0.model.OnLoginListener;
import com.aspsine.mobi.androidmvpdemos.demo0.view.LoginView;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class LoginPresenter implements OnLoginListener,IPresenter {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
    }

    @Override
    public void login() {
        String name = loginView.getName();
        String password = loginView.getPassword();
        loginModel.doLogin(name, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }


    @Override
    public void onUsernameError() {
        loginView.showToast("用户名错误");
    }

    @Override
    public void onPasswordError() {
        loginView.showToast("密码错误");
    }

    @Override
    public void onSuccess() {
        loginView.moveToIndex();
    }

    @Override
    public void onFailure() {
        loginView.showToast("请求失败");
    }
}
