package com.example.travel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Center extends AppCompatActivity {
private List<number> listviews=new ArrayList<>();
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.center_main);
        init();
        ListAdapter listAdapter=new ListAdapter(Center.this,R.layout.center,listviews);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(listAdapter);
    }
    public void init(){
       number one=new number("one",R.drawable.image);
       listviews.add(one);
       number two=new number("two",R.drawable.image);
       listviews.add(two);
    }
}
