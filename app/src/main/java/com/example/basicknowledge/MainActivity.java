package com.example.basicknowledge;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.basicknowledge.base.BaseActivity;
import com.example.basicknowledge.custom.CanvasActivity;
import com.example.basicknowledge.mvp_login.ui.LoginActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private  final String TAG =getClass().getSimpleName();
    private RecyclerView rvAddNewView;
    private AddDataAdapter addDataAdapter;
    private List<String> addViewed = new ArrayList<>(16);
    private List<String> data = new ArrayList<>(16);
    int itemIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        initView();
        initData();
        setView();
        bindEvent();
    }

    private void bindEvent() {
        addDataAdapter.setAddDataListener(new AddDataAdapter.addDataListener() {
            @Override
            public void onAddDataListener(int position) {
                if(itemIndex < data.size()){
                    addViewed.add(data.get(itemIndex));
                }else {
                    addViewed.add("【下一页5】" + itemIndex);
                }
                addDataAdapter.notifyDataSetChanged();
                itemIndex++;
            }
        });
        addDataAdapter.setLongClickListenerRemove(new AddDataAdapter.longClickListenerRemove() {
            @Override
            public void setLongClickListener(View view) {
                addViewed.remove(rvAddNewView.getChildLayoutPosition(view));
                if(addViewed.size()==0){
                    itemIndex=0;
                }
                addDataAdapter.notifyDataSetChanged();
            }
        });
        addDataAdapter.setOnItemClickListener(new AddDataAdapter.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(View view, String str) {
                switch (str){
                    case "CanvasActivity":
                        startActivity(new Intent(MainActivity.this, CanvasActivity.class));
                        break;
                    case "LoginActivity":
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"item 未实现",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void setView() {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 4);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvAddNewView.setLayoutManager(linearLayoutManager);
        addDataAdapter = new AddDataAdapter(addViewed);
        //设置item间隔
        rvAddNewView.addItemDecoration(new RecyclerItemDecoration(20,4));
        rvAddNewView.setAdapter(addDataAdapter);
    }

    private void initView() {
        rvAddNewView = findViewById(R.id.rv_main);
    }

    private void initData() {
        data.add("LoginActivity");
        data.add("CanvasActivity");
    }

   /* private void showDialog() {
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
    }*/
}