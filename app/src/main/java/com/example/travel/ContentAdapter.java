package com.example.travel;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

public class ContentAdapter extends PagerAdapter {
    private List<View> views;
    public ContentAdapter(List<View> views){
        this.views=views;
    }
    public int getCount(){
        return views.size();
    }
    public boolean isViewFromObject(View arg0,Object arg1){
        return arg0==arg1;
    }
    public Object instantiateItem(ViewGroup container,int position){
        View view=views.get(position);
        container.addView(view);
        return view;
    }
    public void destoryItem(ViewGroup container,int position,Object object){
        container.removeView(views.get(position));
    }
}
