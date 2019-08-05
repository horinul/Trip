package com.example.travel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Message extends AppCompatActivity {
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.message);
        setStatusBarUpperAPI21();
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ImageView imageView=(ImageView) findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setStatusBarUpperAPI21(){
        Window window = getWindow();
        //取消设置悬浮透明状态栏,ContentView便不会进入状态栏的下方了
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //设置状态栏颜色
        window.setStatusBarColor(getResources().getColor(R.color.view));
    }
}
