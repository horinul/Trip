package com.example.travel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<number> {
    private int resourcedID;
    public ListAdapter(Context context, int TextViewID, List<number> objects){
        super(context,TextViewID,objects);
        resourcedID=TextViewID;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        number listview=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourcedID,parent,false);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        TextView textView=(TextView) view.findViewById(R.id.text);
        imageView.setImageResource(listview.getImageID());
        textView.setText(listview.getIntro());
        return view;
    }
}
