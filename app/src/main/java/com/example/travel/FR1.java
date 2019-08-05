package com.example.travel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FR1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.place, container, false);
    }
    public void onActivityCreated(Bundle savedInstancestated) {
        super.onActivityCreated(savedInstancestated);
        LinearLayout More = (LinearLayout) getActivity().findViewById(R.id.more);
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
                Intent intent18 = new Intent(getActivity(), Navigation.class);
                startActivity(intent18);
            }
        });
    }
}