package com.example.health_my.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.Querydoctor;

import java.util.ArrayList;
import java.util.List;

public class FollowAdpater extends RecyclerView.Adapter<FollowAdpater.MyHolderView> {

    private List<Querydoctor> list;
    private Context context;

    public FollowAdpater(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<Querydoctor> data){
        if (data != null) {
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_follow, null);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderView holder, int position) {
        holder.follow_iv.setImageURI(list.get(position).imagePic);
        holder.follow_name.setText(list.get(position).name);
        holder.follow_keshi.setText(list.get(position).jobTitle);
        holder.follow_ks.setText(list.get(position).departmentName);
        holder.follow_jl.setText("好评率"+list.get(position).praiseNum+"%");
        holder.follow_pj.setText("服务患者数"+list.get(position).number+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {

         SimpleDraweeView follow_iv;
         TextView follow_name;
         TextView follow_keshi;
         TextView follow_ks;
         TextView follow_jl;
         TextView follow_pj;

        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            follow_iv = itemView.findViewById(R.id.follow_iv);
            follow_name = itemView.findViewById(R.id.follow_name);
            follow_keshi = itemView.findViewById(R.id.follow_keshi);
            follow_ks = itemView.findViewById(R.id.follow_ks);
            follow_jl = itemView.findViewById(R.id.follow_jl);
            follow_pj = itemView.findViewById(R.id.follow_pj);
        }
    }
}
