package com.example.travel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main  extends AppCompatActivity {
    private LinearLayout LL;
    private Card[] card={new Card("111",R.drawable.card1),new Card("222",R.drawable.card2),new Card("333",R.drawable.card3)};
    private List<Card> cardList=new ArrayList<>();
    private mainAdapter adapter;
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.main);
        if(Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
        LinearLayout LL1=(LinearLayout) findViewById(R.id.LL1);
        LL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(main.this,Place.class);
                startActivity(intent1);
            }
        });
        LinearLayout LL2=(LinearLayout)findViewById(R.id.LL2);
        LL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(main.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(main.this,new String[]{Manifest.permission.CAMERA},1);
                }else {
                    camera();
                }
            }
        });
        LinearLayout LL3=(LinearLayout) findViewById(R.id.LL3);
        LL3.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Intent intent3=new Intent(main.this,basic.class);
            startActivity(intent3);
        }
    });

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new mainAdapter(cardList);
        recyclerView.setAdapter(adapter);
        init();
    }

    private void camera(){
        Intent intent= null;
        try {
            intent = new Intent(main.this, CustomCamera.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    camera();
                }else{
                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }

    private void init(){
        cardList.clear();
        for(int i=0;i<20;i++){
            Random random=new Random();
            int index=random.nextInt(card.length);
            cardList.add(card[index]);
        }
}


}

