package com.example.travel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.SpecialDanmaku;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class CustomCamera extends AppCompatActivity implements SurfaceHolder.Callback{
    private Camera mCamera;
    private boolean showDanmaku;
    private SurfaceView mPreview;
    private SurfaceHolder mHolder;
    private DanmakuView danmakuView;
    private DanmakuContext danmakuContext;
    private EditText editText;
    private Button button;
    private Button button1;
    private SimpleTextCacheStuffer simpleTextCacheStuffer;
    private Canvas canvas;
    private TextPaint textPaint;
    private IDanmakuView iDanmakuView;
    private LinearLayout LL;
    //弹幕解析器
    private BaseDanmakuParser parser=new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();


        setContentView(R.layout.custom_camera);
        mPreview=findViewById(R.id.preview);



        //发送弹幕
        FloatingActionButton floatingActionButton1 =(FloatingActionButton) findViewById(R.id.send);
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=editText.getText().toString();
                addDanmaku(text,true);
                editText.setText("");

            }
        });


        //清空弹幕
        FloatingActionButton floatingActionButton2 =(FloatingActionButton) findViewById(R.id.clear);
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllDanmaku(true);
            }
        });
        editText=(EditText) findViewById(R.id.edittext);


        mHolder=mPreview.getHolder();
        mHolder.addCallback(this);


        danmakuView=(DanmakuView) findViewById(R.id.danmaku);
        //提升弹幕绘制效率
        danmakuView.enableDanmakuDrawingCache(true);
        LL=(LinearLayout) findViewById(R.id.LL);
        danmakuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL.setVisibility(LL.getVisibility() == LL.INVISIBLE ? LL.VISIBLE : LL.INVISIBLE);
                //Toast.makeText(CustomCamera.this,"000",Toast.LENGTH_SHORT).show();
            }
        });
      /*  iDanmakuView.setOnDanmakuClickListener(new IDanmakuView.OnDanmakuClickListener() {
            @Override
            public boolean onDanmakuClick(IDanmakus danmakus) {

                return false;
            }

            @Override
            public boolean onViewClick(IDanmakuView view) {

                return false;
            }
        });*/
        danmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                showDanmaku = true;
                danmakuView.start();
              //  generateSomeDanmaku();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
 /*       iDanmakuView.setOnDanmakuClickListener(new IDanmakuView.OnDanmakuClickListener() {
            @Override
            public boolean onDanmakuClick(IDanmakus danmakus) {
                Toast.makeText(CustomCamera.this,"00",Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onViewClick(IDanmakuView view) {
                return false;
            }
        });*/


        danmakuContext=DanmakuContext.create();
        //控制速度
        danmakuContext.setScrollSpeedFactor(5);
        danmakuView.prepare(parser,danmakuContext);
        //控制行数
        HashMap<Integer,Integer> maxLines=new HashMap<>();
        maxLines.put(BaseDanmaku.TYPE_SCROLL_RL,5);


    }

    //增加一条弹幕
private void addDanmaku(String content,Boolean withBorder){
        BaseDanmaku danmaku=danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        danmaku.text=content;
        danmaku.padding=5;
        danmaku.textSize=50;
        danmaku.setTime(danmakuView.getCurrentTime());
   /*     AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation1.setDuration(3000);//多长时间完成这个动作
        danmakuView.startAnimation(alphaAnimation1);*/

//控制输入弹幕框的颜色
    if(withBorder){
            danmaku.borderColor=Color.BLUE;
        }
        danmakuView.addDanmaku(danmaku);
}
//一键清空弹幕
    private void removeAllDanmaku(boolean isClearAllDanmakuOnScreen){
        if(danmakuView!=null){
            danmakuView.removeAllDanmakus(true);
        }
    }

//随机生成弹幕
 /*   private void generateSomeDanmaku(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (showDanmaku){
                    int time=new Random().nextInt(300);
                    String content=""+time+time;
                    addDanmaku(content,false);
                    try{
                        Thread.sleep(time);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }*/

    /**
     * 获取Camera对象
     * @return
     */
    private Camera getCamera(){
        Camera camera;
        try {
             camera=Camera.open();
        } catch (Exception e) {
            camera=null;
            e.printStackTrace();
        }
        return camera;
    }

    /**
     * 开始预览相机内容
     */
    private void setStartPreview(Camera camera,SurfaceHolder holder){
        try {
            camera.setPreviewDisplay(holder);
            //将系统Camera预览角度进行调整
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放相机资源
     */
    private void releaseCamera(){
        if(mCamera!=null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.release();
            mCamera=null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();
        if (danmakuView!=null&&danmakuView.isPrepared()){
            danmakuView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mCamera==null) {
            mCamera = getCamera();
            if(mHolder==null){
                setStartPreview(mCamera,mHolder);
            }
        }
        if(danmakuView!=null&&danmakuView.isPrepared()&&danmakuView.isPaused()){
            danmakuView.resume();
        }
    }

    protected void onDestory(){
        super.onDestroy();
        showDanmaku=false;
        if(danmakuView!=null){
            danmakuView.release();
            danmakuView=null;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        setStartPreview(mCamera,mHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            mCamera.stopPreview();
            setStartPreview(mCamera,mHolder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            releaseCamera();
    }
}
