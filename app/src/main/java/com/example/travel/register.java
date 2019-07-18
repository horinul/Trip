package com.example.travel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        Button button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            EditText editText3=(EditText) findViewById(R.id.edittext3);
            EditText editText4=(EditText) findViewById(R.id.edittext4);
            public void onClick(View v) {
                String phone=editText3.getText().toString();
                String password=editText4.getText().toString();
       if(phone.length()<11){
            Toast.makeText(register.this,"您输入的手机号不足11位",Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty()){
         Toast.makeText(register.this,"您还未设置密码",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(register.this,"注册成功",Toast.LENGTH_SHORT).show();
            Intent intent2=new Intent(register.this,land.class);
            startActivity(intent2);
        }
            }
        }
    );
    }
}