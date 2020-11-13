package com.example.basicknowledge.custom;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.basicknowledge.R;
import com.example.basicknowledge.base.BaseActivity;
import com.example.basicknowledge.custom.DrawView;
import com.example.basicknowledge.custom.RadarView;

public class CanvasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        init();
    }

    private void init() {
        LinearLayout layout=(LinearLayout) findViewById(R.id.root);
        final DrawView view=new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        //雷达扫描图
        LinearLayout radarView=(LinearLayout) findViewById(R.id.radarView);
        RadarView mRadarView = new RadarView(this,5,4);
        //通知view组件重绘
        view.invalidate();
        mRadarView.invalidate();
        radarView.addView(mRadarView);
        layout.addView(view);

    }
}