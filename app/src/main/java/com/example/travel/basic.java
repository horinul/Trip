package com.example.travel;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Build;
import android.widget.ImageView;

public class basic extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic);
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        android.support.v7.app.ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(basic.this,Message.class);
                startActivity(intent);
            }
        });
        ImageView imageView1=(ImageView) findViewById(R.id.imageView);
        imageView1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent1=new Intent(basic.this,Set.class);
                startActivity(intent1);
            }
        });
        ImageView imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent1=new Intent(basic.this,main.class);
                startActivity(intent1);
            }
        });
    }
}
