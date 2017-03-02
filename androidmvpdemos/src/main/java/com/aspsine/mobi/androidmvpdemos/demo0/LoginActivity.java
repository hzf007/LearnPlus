package com.aspsine.mobi.androidmvpdemos.demo0;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aspsine.mobi.androidmvpdemos.R;
import com.aspsine.mobi.androidmvpdemos.demo0.presenter.LoginPresenter;
import com.aspsine.mobi.androidmvpdemos.demo0.view.LoginView;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener, LoginView {
    private EditText et_name;
    private EditText et_password;
    private Button btn_login;

    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        loginPresenter = new LoginPresenter(this);
    }
    private void initViews() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.btn_login:
                loginPresenter.login();
                break;
            default:
                break;

        }
    }

    @Override
    public void moveToIndex() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}
