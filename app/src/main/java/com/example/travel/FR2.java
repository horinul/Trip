package com.example.travel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FR2 extends Fragment {
    public static final int UDPATE_SCENERY=1;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Card[] card = {new Card("111", R.drawable.card1), new Card("222", R.drawable.card2), new Card("333", R.drawable.card3)};
    private List<Card> cardList = new ArrayList<>();
    private mainAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.find, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler);
        swipeRefreshLayout=(SwipeRefreshLayout) getActivity().findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.cyan));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshScenery();
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new mainAdapter(cardList);
        recyclerView.setAdapter(adapter);
        init();
        spinner();
        FloatingActionButton floatingActionButton=(FloatingActionButton) getActivity().findViewById(R.id.button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                   ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},1);
               }else {
                   startActivity(new Intent(getActivity(),CustomCamera.class));
               }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    startActivity(new Intent(getActivity(),CustomCamera.class));
                }else{
                    Toast.makeText(getContext(),"你否定了权限",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }

    /**
     * 异步线程加载UI
     */
    private Handler handler=new Handler(){
        public void handleMessage(Message asg) {
            switch (asg.what) {
                case UDPATE_SCENERY:
                    init();
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
            }
        }
    };

    /**
     *
     * 开启子线程加载UI，防止主线程堵塞
     */
    private void refreshScenery(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message message=new Message();
                    message.what=UDPATE_SCENERY;
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void spinner() {
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("成都理工大学");
        arrayList.add("SM广场");
        arrayList.add("博物馆");
        arrayList.add("东郊记忆");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // textView.setText(adapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //textView.setText("成都理工大学");
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
