package com.example.travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class land extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land);
        Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nameinput = (EditText) findViewById(R.id.edittext1);
                EditText psinput = (EditText) findViewById(R.id.edittext2);
                String name = nameinput.getText().toString();
                String ps = psinput.getText().toString();
                if (name.equals("admin") && ps.equals("123456")) {
                    Intent intent = new Intent(land.this, basic.class);
                    Toast.makeText(land.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else Toast.makeText(land.this, "您的账号或密码有误，请重新输入", Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView1=(TextView) findViewById(R.id.text1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(land.this,register.class);
                startActivity(intent1);
            }
        });
       }
      }
