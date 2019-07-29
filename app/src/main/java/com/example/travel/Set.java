package com.example.travel;

import android.app.Activity;
import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.zip.Inflater;

public class Set extends AppCompatActivity {
  public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.set);
      setStatusBarUpperAPI21();
      /**
       *
      if(Build.VERSION.SDK_INT>=21){
        View decorview=getWindow().getDecorView();
        int option=View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorview.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);}
       **/
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ImageView imageView=(ImageView) findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(Set.this,basic.class);
              startActivity(intent);
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


