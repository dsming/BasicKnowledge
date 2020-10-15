package com.example.basicknowledge.mvp_login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.basicknowledge.MainActivity;
import com.example.basicknowledge.R;
import com.example.basicknowledge.base.BaseActivity;
import com.example.basicknowledge.mvp_login.presenter.UserLoginPresenter;
import com.example.basicknowledge.mvp_login.view.UserLoginView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, UserLoginView {

    private EditText mUsername;
    private EditText mUserpassword;
    private Button mLogin;
    private Button mClear;
    private ProgressBar mProgress;
    private UserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();//初始化视图

    }

    private void initView() {
        mUsername = (EditText) findViewById(R.id.username);
        mUserpassword = (EditText) findViewById(R.id.userpassword);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mClear = (Button) findViewById(R.id.clear);
        mClear.setOnClickListener(this);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        //获取P层的实例
        userLoginPresenter = new UserLoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //登录操作
            case R.id.login:
                // TODO 调用P层的登录方法
                userLoginPresenter.login();
                break;
            case R.id.clear:
                // TODO 调用P层的重置方法
                userLoginPresenter.clear();
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoadding() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgress.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideLoadding() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgress.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public String getUserName() {
        return mUsername.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return mUserpassword.getText().toString();
    }

    @Override
    public void toActivity() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    public void loadFailed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void clearUserMessage() {
        mUsername.setText("");
        mUserpassword.setText("");
    }

}