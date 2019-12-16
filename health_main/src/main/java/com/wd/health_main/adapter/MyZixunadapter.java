package com.wd.health_main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.bean.ZixunBean;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

public class MyZixunadapter extends RecyclerView.Adapter<MyZixunadapter.myViewHolder> {

      private ArrayList<ZixunBean> list;
      private Context context;
      private View view;
      public static final int HOT_TYPE =0;
      public static final int FASHION_TYE =0;
      private  int type;
      int p;


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

            view = LayoutInflater.from(context).inflate(R.layout.zixun_layout, parent, false);
            return new myViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull MyZixunadapter.myViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getName());
        holder.itemView.setTag(position);

        if (p ==position){
            holder.bing_zheng_view.setVisibility(View.VISIBLE);
            holder.textView.setTextColor(Color.parseColor("#03A9F4"));

        }else {

            holder.bing_zheng_view.setVisibility(View.GONE);
            holder.textView.setTextColor(Color.parseColor("#333333"));

        }



      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = (int) v.getTag();

                onActu.onActi(list.get(position).getId(),list.get(position).getName());
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
        private final LinearLayout lin_lin;
        private final View bing_zheng_view;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            lin_lin = itemView.findViewById(R.id.lin_lin);
            bing_zheng_view = itemView.findViewById(R.id.bing_zheng_view);


        }
    }
    private OnActu onActu;

    public void setOnActu(OnActu onActu) {
        this.onActu = onActu;
    }

    public interface  OnActu{
        void  onActi(int Id,String name);
     }



}
