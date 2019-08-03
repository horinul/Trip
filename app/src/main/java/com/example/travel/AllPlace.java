package com.example.travel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//全部景点
public class AllPlace extends AppCompatActivity {
    private LinearLayout LL;
    private Card[] card = {new Card("111", R.drawable.card1), new Card("222", R.drawable.card2), new Card("333", R.drawable.card3)};
    private List<Card> cardList = new ArrayList<>();
    private mainAdapter adapter;

    public void onCreate(Bundle saveIntstancestate) {
        super.onCreate(saveIntstancestate);
        setContentView(R.layout.allplace);
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new mainAdapter(cardList);
        recyclerView.setAdapter(adapter);
        init();
        //返回
        ImageView image=(ImageView) findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        cardList.clear();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int index = random.nextInt(card.length);
            cardList.add(card[index]);
        }
    }

}
