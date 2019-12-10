package com.example.health_my.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.LVienna;
import com.wd.common.util.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LViennaAdpater extends RecyclerView.Adapter<LViennaAdpater.MyViewHolder> {

    private List<LVienna> list;
    private Context context;

    public LViennaAdpater(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<LVienna> data){
        if (data != null) {
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LinearLayout.inflate(context, R.layout.item_vienna , null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.vienna_iv.setImageURI(list.get(position).imagePic);
        holder.vienna_name.setText(list.get(position).doctorName);
        holder.vienna_keshi.setText(list.get(position).jobTitle);
        try {
            holder.vienna_times.setText(DateUtils.dateFormat(new Date(list.get(position).inquiryTime),DateUtils.MINUTE_PATTERN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView vienna_iv;
        TextView vienna_name;
        TextView vienna_keshi;
        TextView vienna_time;
        TextView vienna_times;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vienna_iv = itemView.findViewById(R.id.vienna_iv);
            vienna_name = itemView.findViewById(R.id.vienna_name);
            vienna_keshi = itemView.findViewById(R.id.vienna_keshi);
            vienna_time = itemView.findViewById(R.id.vienna_time);
            vienna_times = itemView.findViewById(R.id.vienna_times);
        }
    }
}
