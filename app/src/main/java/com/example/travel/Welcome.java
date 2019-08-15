package com.example.travel;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;




public class Welcome extends Activity implements OnPageChangeListener {
    private ViewPager viewPager;
    private ViewPagerAdapter vpAdapter;
    private ArrayList<View> views;
    private View view1, view2, view3, view4;
    private ImageView[] points;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        initView();
        initData();
    }

    private void initView() {
        LayoutInflater mLi = LayoutInflater.from(this);
        view1 = mLi.inflate(R.layout.welcome_item1, null);
        view2 = mLi.inflate(R.layout.welcome_item2, null);
        view3 = mLi.inflate(R.layout.welcome_item3, null);
        view4 = mLi.inflate(R.layout.welcome_item4, null);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        views = new ArrayList<View>();
        vpAdapter = new ViewPagerAdapter(views);
    //    initPoint();
    }

    private void initData() {
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(vpAdapter);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

    }

  /*  private void initPoint() {
      //  LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
        points = new ImageView[views.size()];
        for (int i = 0; i < views.size(); i++) {
         //   points[i] = (ImageView) linearLayout.getChildAt(i);
            //points[i].setEnabled(true);
            //points[i].setOnClickListener(this);
            points[i].setTag(i);
        }
        currentIndex = 0;
       // points[currentIndex].setEnabled(false);
    }*/

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        //设置底部小点选中状态
      //  setCurDot(position);
    }

 /*   public void onClick(View v) {
        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }*/

    private void setCurView(int position) {
        if (position < 0 || position >= 4) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

  private void setCurDot(int positon) {
        if (positon < 0 || positon > 3 || currentIndex == positon) {
            return;
        }
        points[positon].setEnabled(false);
        points[currentIndex].setEnabled(true);
        currentIndex = positon;
    }
}
