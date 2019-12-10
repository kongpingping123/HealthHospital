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
    public static final int HOT_TYPE = 0;
    public static final int FASHION_TYPE = 1;
    private int type;
    private View view1;
     private int count;

    public MyXiangqingadapter( Context context,int type) {
        list = new ArrayList<>();
        this.context = context;
        this.type = type;
    }
     public void AddAll(List<XiangqingBase> xiangqingBases){
         if (xiangqingBases!=null){
             list.addAll(xiangqingBases);
         }



     }



    @NonNull
    @Override
    public MyXiangqingadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (type == HOT_TYPE){

            view = LayoutInflater.from(context).inflate(R.layout.xiangqing_layout,parent,false);
            return new myViewHolder(view);
        }else {
            view1 = LayoutInflater.from(context).inflate(R.layout.hot_item_layout,parent,false);
            return new myViewHolder(view1);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull MyXiangqingadapter.myViewHolder holder, final int position) {

        parse = Uri.parse(list.get(position).thumbnail);
            holder.simpleDraweeView.setImageURI(parse);
        holder.textView.setText(list.get(position).title);
       holder.textView3.setText(list.get(position).source);

       /* holder.image.setImageURI(parse);

       holder.price.setText(list.get(position).thumbnail);*/
///        holder.text.setText(list.get(position).thumbnail);
        try {
            holder.textView4.setText(DateUtils.dateFormat(new Date(list.get(position).releaseTime),DateUtils.MINUTE_PATTERN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  jing.gg(position);

            }
        });*/

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
        SimpleDraweeView image;
        TextView text;
        TextView price;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view2);
            simpleDraweeView = itemView.findViewById(R.id.imager2);
            textView3 = itemView.findViewById(R.id.text_view3);
            textView4 = itemView.findViewById(R.id.text_view4);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.price);


        }

    }

   /* public Jing jing;

    public void setJing(Jing jing) {
        this.jing = jing;
    }

    public interface  Jing{
        void gg(int id);
    }
*/


}
