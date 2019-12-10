package com.wd.health_main.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.util.DateUtils;
import com.wd.health_main.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyXiangqingadapter extends RecyclerView.Adapter<MyXiangqingadapter.myViewHolder> {
     private ArrayList<XiangqingBase> list;
     private Context context;
    private View view;
    private Uri parse;

    public MyXiangqingadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
     public void AddAll(List<XiangqingBase> xiangqingBases){
         if (xiangqingBases!=null){
             list.addAll(xiangqingBases);
         }
     }
    @NonNull
    @Override
    public MyXiangqingadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.xiangqing_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyXiangqingadapter.myViewHolder holder, int position) {

                  parse = Uri.parse(list.get(position).thumbnail);
            holder.simpleDraweeView.setImageURI(parse);
        holder.textView.setText(list.get(position).title);
       holder.textView3.setText(list.get(position).source);

        try {
            holder.textView4.setText(DateUtils.dateFormat(new Date(list.get(position).releaseTime),DateUtils.MINUTE_PATTERN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView3;
        private final TextView textView4;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view2);
            simpleDraweeView = itemView.findViewById(R.id.imager2);
            textView3 = itemView.findViewById(R.id.text_view3);
            textView4 = itemView.findViewById(R.id.text_view4);
        }
    }


}
