package com.wd.health_main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.common.bean.BingBase;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Mybingadapter extends RecyclerView.Adapter<Mybingadapter.myViewHolder> {

     private ArrayList<BingBase> list;
      private Context context;
    private View view;

    public Mybingadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void AddAll(List<BingBase> bingBases){
        if (bingBases!=null){
            list.addAll(bingBases);
        }
    }


    @NonNull
    @Override
    public Mybingadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.text_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mybingadapter.myViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).name);

          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                    work.sad();
              }
          });
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   jing.gg(position,list.get(position).name);



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

   /* public void clear() {
       list.clear();
    }*/

    class myViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view6);
        }
    }
    private Work work;

    public void setWork(Work work) {
        this.work = work;
    }

    public  interface  Work{
        void sad();
    }


    public Jing jing;

    public void setJing(Jing jing) {
        this.jing = jing;
    }

    public interface  Jing{
        void gg(int id,String name);

     }




}
