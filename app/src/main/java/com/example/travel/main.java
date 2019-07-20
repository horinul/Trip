package com.example.travel;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;

public class main  extends AppCompatActivity  implements OnClickListener,OnPageChangeListener {
    private List<View> list;


    private LinearLayout LL1;
    private LinearLayout LL2;
    private LinearLayout LL3;

    private TextView TV1;
    private TextView TV2;
    private TextView TV3;

    private ContentAdapter contentAdapter;

    private List<View> views;

    private ViewPager viewPager;

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.main);
    }
    private void initEvent(){
        LL1.setOnClickListener(this);
        LL2.setOnClickListener(this);
        LL3.setOnClickListener(this);

        viewPager.setOnPageChangeListener(this);
    }
    private void initView(){
        LL1=(LinearLayout) findViewById(R.id.LL1);
        LL2=(LinearLayout) findViewById(R.id.LL2);
        LL3=(LinearLayout) findViewById(R.id.LL3);

        TV1=(TextView) findViewById(R.id.TV1);
        TV2=(TextView) findViewById(R.id.TV2);
        TV3=(TextView) findViewById(R.id.TV3);

        viewPager=(ViewPager) findViewById(R.id.viewpager);

        View place=View.inflate(main.this,R.layout.place,null);
        View main=View.inflate(main.this,R.layout.center_main,null);
        View message=View.inflate(main.this,R.layout.message,null);

        views=new ArrayList<View>();
        views.add(place);
        views.add(main);
        views.add(message);

        contentAdapter=new ContentAdapter(views);
        viewPager.setAdapter(contentAdapter);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.LL1:
                viewPager.setCurrentItem(0);
            case R.id.LL2:
                viewPager.setCurrentItem(1);
            case  R.id.LL3:
                viewPager.setCurrentItem(2);
                default:
                    break;
        }
    }

    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }
    public void onPageSelected(int arg0) {

        }
    }

