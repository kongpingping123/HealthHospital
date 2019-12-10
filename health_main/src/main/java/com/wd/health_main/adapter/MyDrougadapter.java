package com.wd.health_main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.common.bean.DrugBase;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDrougadapter extends RecyclerView.Adapter<MyDrougadapter.myViewHolder> {
     private ArrayList<DrugBase> list;
     private Context context;
    private View view;
     int p;
    public MyDrougadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void AllAdd(List<DrugBase>drugBases){
        if (drugBases!=null){
            list.addAll(drugBases);
        }
    }


    @NonNull
    @Override
    public MyDrougadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.guanman_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDrougadapter.myViewHolder holder, final int position) {
                   holder.textView.setText(list.get(position).name);
                    holder.itemView.setTag(position);

  if (p==position){
       holder.lin_lin.setBackgroundColor(Color.WHITE);
       holder.bing_zheng_view1.setVisibility(View.VISIBLE);
       holder.textView.setTextColor(Color.parseColor("#03A9F4"));
  }else {
      holder.lin_lin.setBackgroundColor(Color.parseColor("#f2f2f2"));
      holder.bing_zheng_view1.setVisibility(View.GONE);
      holder.textView.setTextColor(Color.parseColor("#333333"));



  }

                   holder.itemView.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                            p = (int) v.getTag();

                             onActu.onActi(list.get(position).getId());
                              notifyDataSetChanged();
                       }
                   });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{


        private final TextView textView;
        private final View bing_zheng_view1;
        private final LinearLayout lin_lin;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view8);
            lin_lin = itemView.findViewById(R.id.lin_lin1);
            bing_zheng_view1 = itemView.findViewById(R.id.bing_zheng_view1);


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
