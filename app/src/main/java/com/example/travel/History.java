package com.example.travel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//我的足迹界面的
public class History extends AppCompatActivity {
    private List<History_item> list = new ArrayList<>();
    private History_item[] place = {new History_item("111", "222", R.drawable.history)};

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.history);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        History_adapter adapter = new History_adapter(list);
        recyclerView.setAdapter(adapter);
        initData();
       setStatusBarUpperAPI21();
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ImageView imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(History.this,basic.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
            History_item item1 = new History_item("成都理工大学", "2019.8.1", R.drawable.history);
            list.add(item1);
            History_item item7 = new History_item("博物馆", "2019.8.1", R.drawable.history);
            list.add(item7);
            History_item item2 = new History_item("SM广场", "2019.8.2", R.drawable.history);
            list.add(item2);
            History_item item3 = new History_item("东郊记忆", "2019.8.2", R.drawable.history);
            list.add(item3);
            History_item item6 = new History_item("东郊记忆", "2019.8.3", R.drawable.history);
            list.add(item6);
            History_item item4 = new History_item("博物馆", "2019.8.4", R.drawable.history);
            list.add(item4);
    }
    private void setStatusBarUpperAPI21(){
        Window window = getWindow();
        //取消设置悬浮透明状态栏,ContentView便不会进入状态栏的下方了
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //设置状态栏颜色
        window.setStatusBarColor(getResources().getColor(R.color.view));
    }
}
