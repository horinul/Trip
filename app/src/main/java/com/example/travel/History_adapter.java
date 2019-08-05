
package com.example.travel;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.text.Layout;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.List;


//我的足迹界面的适配器
public class History_adapter extends RecyclerView.Adapter<History_adapter.ViewHolder>{
    private Context context;
    private List<History_item> mlist;

    public History_adapter(List<History_item> list) {
        this.mlist = list;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout LL;
        private ImageView pic;
        private TextView time;
        private TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            LL=itemView.findViewById(R.id.LL);
            pic=itemView.findViewById(R.id.pic);
            time=itemView.findViewById(R.id.time);
            name=itemView.findViewById(R.id.name);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if(context==null){
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);
        final History_adapter.ViewHolder holder=new History_adapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pic.setImageResource(mlist.get(position).getPic_id());
        holder.name.setText(mlist.get(position).getName());
        holder.time.setText(mlist.get(position).getTime());
        if (position== 0){//判断日期，并把相同日期的放在一起以隐去部分布局的形式
            holder.LL.setVisibility(View.VISIBLE);
        }
        else if (mlist.get(position).getTime().equals(mlist.get(position- 1).getTime())){
            holder.LL.setVisibility(View.GONE);
        }else {
            holder.LL.setVisibility(View.VISIBLE);
        }
    }

}

