package com.example.travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SceneryActivity extends AppCompatActivity {

    public static final String SCENERY_NAME="scenery_name";
    public static final String SCENERY_IMAGE_ID="scenery_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);
        Intent intent=getIntent();
        String sceneryName=intent.getStringExtra(SCENERY_NAME);
        int sceneryImageid=intent.getIntExtra(SCENERY_IMAGE_ID,0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView sceneryView=(ImageView)findViewById(R.id.scenery_image_view);
        TextView sceneryContentText=(TextView)findViewById(R.id.scenery_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(sceneryName);
        Glide.with(this).load(sceneryImageid).into(sceneryView);
        String sceneryContent=generateFruitContent(sceneryName);
        sceneryContentText.setText(sceneryContent);
    }
    private String generateFruitContent(String sceneryName){
        StringBuilder sceneryContent=new StringBuilder();
        for(int i=0;i<500;i++){
            sceneryContent.append(sceneryName);
        }
        return sceneryContent.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
