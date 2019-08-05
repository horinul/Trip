package com.example.travel;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
/*因为用了BottomNavigationView替代底端布局，界面改成了包括上方碎片和下方导航栏布局。这个活动写的是碎片切换和按钮的情况（即点击底端按钮换界面），
原来的主三个界面中的活动现在放在了FR1，FR2，FR3中，布局则分别为place find basic*/
public class Main extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    List<Fragment> mfragments;
    private int lastIndex;

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.main);
        initBottom();
        initData();
        setStatusBarUpperAPI21();
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
    }
    public void initData(){
        mfragments=new ArrayList<>();
        mfragments.add(new FR1());
        mfragments.add(new FR2());
        mfragments.add(new FR3());
        setFragmentPosition(1);
    }

    private void initBottom(){
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.c1:
                        setFragmentPosition(0);
                        break;
                    case R.id.c2:
                        setFragmentPosition(1);
                        break;
                    case R.id.c3:
                        setFragmentPosition(2);
                        break;

                }return true;
            }
        });
    }
    //remove移除不显示的界面，add加上要显示的界面
    private void setFragmentPosition(int position){//切换
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();//获得事务管理类的实例
        Fragment current=mfragments.get(position);//将要加载的界面
        Fragment last=mfragments.get(lastIndex);//上一次加载的界面
        lastIndex=position;//即得到上一次加载的界面
        ft.remove(last);//收起上次加载的界面
        if(!current.isAdded()){//对象是否添加到了Activity
            getSupportFragmentManager().beginTransaction().remove(current).commit();
            ft.replace(R.id.frame,current);
        }
        ft.show(current);
        ft.commitAllowingStateLoss();
    }
    private void setStatusBarUpperAPI21(){
        Window window = getWindow();
        //取消设置悬浮透明状态栏,ContentView便不会进入状态栏的下方了
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //设置状态栏颜色
        window.setStatusBarColor(getResources().getColor(R.color.view));
    }
    }
