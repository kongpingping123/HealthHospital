package com.wd.health_main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.common.bean.ZixunBean;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyZixunadapter extends RecyclerView.Adapter<MyZixunadapter.myViewHolder> {

     private ArrayList<ZixunBean> list;
     private Context context;
    private View view;

    public MyZixunadapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void AllAdd(List<ZixunBean> zixunBeans){
        if (zixunBeans!=null){
            list.addAll(zixunBeans);
        }
    }

    @NonNull
    @Override
    public MyZixunadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.zixun_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyZixunadapter.myViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getName());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onActu.onActi(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);

        }
    }
    private OnActu onActu;

    public void setOnActu(OnActu onActu) {
        this.onActu = onActu;
    }

    public interface  OnActu{
        void  onActi(int Id);
     }
}
