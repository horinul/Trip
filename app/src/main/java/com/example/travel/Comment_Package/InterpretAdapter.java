package com.example.travel.Comment_Package;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travel.R;

import java.util.List;

public class InterpretAdapter extends RecyclerView.Adapter<InterpretAdapter.ViewHolder> {
private List<Interpret> mInterpret;

static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView nickName;
    public TextView content;

    public ViewHolder(View view) {
        super(view);
        nickName = view.findViewById(R.id.interpret_nickname);
        content = view.findViewById(R.id.interpret_content);

    }

}

    public InterpretAdapter(List<Interpret> interpretList) {
        mInterpret = interpretList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interpret, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        Interpret interpret = mInterpret.get(position);
        holder.nickName.setText(interpret.getNickName());
        holder.content.setText(interpret.getContent());

    }

    @Override
    public int getItemCount() {
        return mInterpret.size();
    }
}
