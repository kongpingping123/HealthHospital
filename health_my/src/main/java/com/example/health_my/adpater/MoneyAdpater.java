package com.example.health_my.adpater;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.wd.common.bean.Money;
import com.wd.common.util.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoneyAdpater extends RecyclerView.Adapter<MoneyAdpater.MyViewHolder> {

    private List<Money> list;
    private Context context;

    public MoneyAdpater(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Money> data){
        if (data != null) {
             list.addAll(data);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_money, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int direction = list.get(position).direction;
        int changeNum = list.get(position).changeNum;
        int type = list.get(position).type;
        if (direction == 1) {
            holder.money_mone.setText("+"+changeNum+"H币");
            holder.money_mone.setTextColor(Color.RED);
            try {
                holder.money_time.setText(DateUtils.dateFormat(new Date(list.get(position).createTime),DateUtils.MINUTE_PATTERN));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (type == 1) {
                holder.money_tv.setText(list.get(position).remark);
            }
            if (type == 2) {
                holder.money_tv.setText(list.get(position).remark);
            }
            if (type == 3) {
                holder.money_tv.setText(list.get(position).remark);
            }
            if (type == 4) {
                holder.money_tv.setText(list.get(position).remark);
            }
            if (type == 9) {
                holder.money_tv.setText(list.get(position).remark);
            }
        }else if (direction == 2) {
            holder.money_mone.setText(changeNum+"H币");
            holder.money_mone.setTextColor(Color.BLUE);
            try {
                holder.money_time.setText(DateUtils.dateFormat(new Date(list.get(position).createTime),DateUtils.MINUTE_PATTERN));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (type == 1) {
            holder.money_tv.setText(list.get(position).remark);
        }
        if (type == 2) {
            holder.money_tv.setText(list.get(position).remark);
        }
        if (type == 3) {
            holder.money_tv.setText(list.get(position).remark);
        }
        if (type == 4) {
            holder.money_tv.setText(list.get(position).remark);
        }
        if (type == 9) {
            holder.money_tv.setText(list.get(position).remark);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

       TextView money_tv,money_time,money_mone;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            money_tv = itemView.findViewById(R.id.money_tv);
            money_time = itemView.findViewById(R.id.money_time);
            money_mone = itemView.findViewById(R.id.money_mone);
        }
    }
}
