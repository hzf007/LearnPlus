package com.aspsine.mobi.androidmvpdemos.demo2.model;

/**
 * Created by hzf on 2017/3/1 0001.
 */

public class LoginModelImpl implements  LoginModel{

    String username;
    String password;

    public LoginModelImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int  checkUserValidity(String username, String password) {
        if(username == null || password == null || !username.equals(getName()) || !password.equals(getPassword())){
           return  -1;
        }
        return  0;
    }
}
