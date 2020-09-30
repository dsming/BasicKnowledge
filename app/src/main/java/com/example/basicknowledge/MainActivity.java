package com.example.basicknowledge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.basicknowledge.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private  final String TAG =getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_dialog);
        Log.d(TAG, "onCreate: ");
        initData();
    }

    private void initData() {
        final CommonDialog dialog = new CommonDialog(MainActivity.this);
        dialog.setMessage("这是一个自定义Dialog。")
                .setImageResId(R.mipmap.ic_launcher)
//                .setTitle("系统提示")
                .setSingle(true).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"xxxx",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"ssss",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}