package com.wd.health_main.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.YaoBase;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyYaoadapter extends RecyclerView.Adapter<MyYaoadapter.myViewHolder> {
    private ArrayList<YaoBase> list;
    private Context context;
    private View view;
    private Uri parse;

    public MyYaoadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void AddAll(List<YaoBase>yaoBases){
        if (yaoBases!=null){
            list.addAll(yaoBases);
        }
    }

    @NonNull
    @Override
    public MyYaoadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.yao_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyYaoadapter.myViewHolder holder, final int position) {
        parse = Uri.parse(list.get(position).picture);
        holder.simpleDraweeView.setImageURI(parse);
        holder.textView.setText(list.get(position).name);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  jing.gg(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simple_draweeview9);
            textView = itemView.findViewById(R.id.text_view9);
        }
    }

    public Jing jing;

    public void setJing(Jing jing) {
        this.jing = jing;
    }

    public interface  Jing{
        void gg(int id);
    }

}
