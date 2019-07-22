package com.example.travel;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Place extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place);
    }
}
