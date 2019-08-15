package com.example.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class start extends Activity {
    private ImageView image1;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what!=0){}
            else{
                Intent intent=new Intent(start.this, Open.class);
                startActivity(intent);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        init();
    }
    private void init(){
        //全屏显示
        View decorView=getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //image1=(ImageView)findViewById(R.id.image1);
        new Countdown().start();
       /* ObjectAnimator animator=ObjectAnimator.ofFloat(image1,"alpha",0f,1f);
        animator.setDuration(2000);
        animator.start();
        */
    }
    //定时函数
    class Countdown extends Thread{
        int count=1;
        public void run(){
            try{
                while(count>=0)
                {
                    sleep(1000);
                    Message message=new Message();
                    message.what=count;
                    handler.sendMessage(message);
                    count--;
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
