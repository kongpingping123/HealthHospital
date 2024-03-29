package com.wd.health_main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.wd.common.bean.DiseBase;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Mydiseaseadapter extends RecyclerView.Adapter<Mydiseaseadapter.myViewHolder> {
    private ArrayList<DiseBase> list;
    private Context context;
    private View view;
    int p;

    public Mydiseaseadapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void AddAll(List<DiseBase> diseBases) {
        if (diseBases != null) {
            list.addAll(diseBases);
        }
    }


    @NonNull
    @Override
    public Mydiseaseadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.disease_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mydiseaseadapter.myViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).departmentName);
        holder.itemView.setTag(position);

        if (p == position) {
            holder.lin_lin.setBackgroundColor(Color.WHITE);
            holder.bing_zheng_view.setVisibility(View.VISIBLE);
            holder.textView.setTextColor(Color.parseColor("#03A9F4"));
        } else {
            holder.lin_lin.setBackgroundColor(Color.parseColor("#f2f2f2"));
            holder.bing_zheng_view.setVisibility(View.GONE);
            holder.textView.setTextColor(Color.parseColor("#333333"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p = (int) v.getTag();
                onActu.onActi(list.get(p).getId());
                notifyDataSetChanged();
            }
        });
    }

    private OnActu onActu;

    public void setOnActu(OnActu onActu) {
        this.onActu = onActu;
    }

    public interface OnActu {
        void onActi(int Id);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final LinearLayout lin_lin;
        private final View bing_zheng_view;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view5);
            lin_lin = itemView.findViewById(R.id.lin_lin);
            bing_zheng_view = itemView.findViewById(R.id.bing_zheng_view);
        }
    }





//    //接口回调
//    private Onkong onkong;
//
//    public void setOnkong(Onkong onkong) {
//
//        this.onkong = onkong;
//    }
//
//    public interface Onkong {
//
//        void onkong(int Id);
//
//    }

}
