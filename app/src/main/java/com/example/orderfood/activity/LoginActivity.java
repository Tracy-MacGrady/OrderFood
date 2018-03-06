package com.example.orderfood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baseutillibrary.base.BaseActivity;
import com.baseutillibrary.basetools.AppUtil;
import com.example.orderfood.R;
import com.example.orderfood.application.MyApplication;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText userNameView, passWordView;
    private Button loginButton;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        userNameView = (EditText) findViewById(R.id.username_view);
        passWordView = (EditText) findViewById(R.id.password_view);
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
        findViewById(R.id.login_layout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_layout:
                AppUtil.hiddenKeyboard(this);
                break;
            case R.id.login_button:
                if (checkEditVal()) {
                    if (username.equals(MyApplication.getInstance().getUserInfo().getUsername())
                            && password.equals(MyApplication.getInstance().getUserInfo().getPassword())) {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "您输入的账号或者密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    private boolean checkEditVal() {
        username = userNameView.getText().toString().trim();
        password = passWordView.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, getString(R.string.username_hint), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, getString(R.string.password_hint), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
    }
}
