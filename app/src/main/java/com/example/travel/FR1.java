package com.example.travel;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FR1 extends Fragment {
    private double latx = 104.153661;
    private double laty = 30.681403;
    public static String mAddress="" ;
    private EditText editText;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.place, container, false);
    }
    public void onActivityCreated(Bundle savedInstancestated) {
        super.onActivityCreated(savedInstancestated);
        LinearLayout More = (LinearLayout) getActivity().findViewById(R.id.more);
        editText=getActivity().findViewById(R.id.editText_1);
        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AllPlace.class));
            }
        });


        TextView textView18 = (TextView) getActivity().findViewById(R.id.textView18);
        textView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddress=editText.getText().toString();
                showBottomDialog();
            }
        });
    }
    private void showBottomDialog(){
        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog(getContext(),R.style.DialogTheme);
        //2、设置布局
        View view = View.inflate(getContext(),R.layout.dialog_custom_layout,null);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.gaode ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MapUtil.isGdMapInstalled()) {
                    MapUtil.openGaoDeNavi(getContext(), 0, 0, null, latx, laty, mAddress);
                } else {
                    //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                    Toast.makeText(getContext(), "尚未安装高德地图", Toast.LENGTH_SHORT).show();
                }

            }
        });

        dialog.findViewById(R.id.baidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MapUtil.isBaiduMapInstalled()){
                    MapUtil.openBaiDuNavi(getContext(), 0, 0, null, latx, laty, mAddress);
                } else {
                    Toast.makeText(getContext(), "尚未安装百度地图", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.findViewById(R.id.tencent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MapUtil.isTencentMapInstalled()){
                    MapUtil.openTencentMap(getContext(), 0, 0, null, latx, laty, mAddress);
                } else {
                    Toast.makeText(getContext(), "尚未安装腾讯地图", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}