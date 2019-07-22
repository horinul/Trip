package com.example.travel;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.ViewHolder>{
    private Context mcontext;
    private List<Card> mcardList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            imageView=(ImageView) view.findViewById(R.id.picture);
            textView=(TextView) view.findViewById(R.id.introduce);
        }
    }
    public mainAdapter(List<Card> cardList){
        this.mcardList=cardList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mcontext==null){
            mcontext=parent.getContext();
        }
        View view= LayoutInflater.from(mcontext).inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(ViewHolder holder,int position){
        Card card=mcardList.get(position);
        holder.textView.setText(card.getIntroduce());
        Glide.with(mcontext).load(card.getImageID()).into(holder.imageView);
    }
    public int getItemCount(){
        return mcardList.size();
    }
}
