package com.example.basicknowledge.base;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 *
 */

public class BaseActivity extends AppCompatActivity {
    private String TAG=" AppUtils.getAppName(getApplicationContext())+getClass().getSimpleName()";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyApplication.setInstanceRef(this);
        Log.d(TAG, "onCreate>>>");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart>>>");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart>>>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume>>>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause>>>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop>>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy>>>");
    }
}
