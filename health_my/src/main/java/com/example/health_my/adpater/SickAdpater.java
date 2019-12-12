package com.example.health_my.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.wd.common.bean.Collection;
import com.wd.common.util.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SickAdpater extends RecyclerView.Adapter<SickAdpater.MyHolderView> {
    private List<Collection> list;
    private Context context;

    public SickAdpater(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<Collection> data){
        if (data != null) {
             list.addAll(data);
        }
    }
    @NonNull
    @Override
    public MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sick, null);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderView holder, int position) {
        holder.text_disease.setText(list.get(position).title);
        holder.text_message.setText(list.get(position).disease);
        holder.text_sick.setText(list.get(position).collectionNum+"收藏");
        holder.text_proposal.setText(list.get(position).commentNum+"建议");
        try {
            holder.text_timess.setText(DateUtils.dateFormat(new Date(list.get(position).createTime),DateUtils.MINUTE_PATTERN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {

         TextView text_disease;
         TextView text_message;
         TextView text_sick;
         TextView text_proposal;
         TextView text_timess;

        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            text_disease = itemView.findViewById(R.id.text_disease);
            text_message = itemView.findViewById(R.id.text_message);
            text_sick = itemView.findViewById(R.id.text_sick);
            text_proposal = itemView.findViewById(R.id.text_proposal);
            text_timess = itemView.findViewById(R.id.text_timess);
        }
    }
}
