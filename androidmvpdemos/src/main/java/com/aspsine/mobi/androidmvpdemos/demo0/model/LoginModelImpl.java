package com.aspsine.mobi.androidmvpdemos.demo0.model;

import com.aspsine.mobi.androidmvpdemos.demo0.http.HttpUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hzf on 2017/3/2 0002.
 */

public class LoginModelImpl implements  LoginModel {

    @Override
    public void doLogin(String name, String password, final OnLoginListener listener) {
        String url = "";
        RequestParams requestParams = new RequestParams();
        requestParams.put("name", name);
        requestParams.put("password", password);
        HttpUtil.post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, org.apache.http.Header[] headers, byte[] responseBody) {
                //登录成功
                String json = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    int code = 0;
                    code = jsonObject.getJSONObject("data").getInt("code");
                    //code=0 表示登录成功，code=1表示用户名错误，code=2表示密码错误
                    if (code == 0) {
                        listener.onSuccess();
                    } else if (code == 1) {
                        listener.onUsernameError();
                    } else if (code == 2) {
                        listener.onPasswordError();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                     listener.onFailure();
            }
        });
    }
}
