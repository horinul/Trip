package com.example.travel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class FR3 extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.basic, container, false);
}
    private void setStatusBarUpperAPI21(){
        Window window = getActivity().getWindow();
        //取消设置悬浮透明状态栏,ContentView便不会进入状态栏的下方了
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //设置状态栏颜色
        window.setStatusBarColor(getResources().getColor(R.color.view));
    }
    public void onActivityCreated(Bundle savedInstaceStated){
        super.onActivityCreated(savedInstaceStated);

        Button button=(Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Message.class);
                startActivity(intent);
            }
        });
       Button button4=(Button) getActivity().findViewById(R.id.button4);
       button4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),Set.class);
               startActivity(intent);
           }
       });

        Button button3=(Button) getActivity().findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),History.class);
                startActivity(intent);
            }
        });
    }
}
