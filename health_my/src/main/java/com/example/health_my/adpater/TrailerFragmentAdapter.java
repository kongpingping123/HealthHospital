package com.example.health_my.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.wd.common.bean.Video;
import com.wd.common.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 *  * <p>文件描述：视频<p>
 *  * <p>作者：zheng<p>
 *  * <p>创建时间：2019/10/16<p>
 *  * <p>更改时间：2019/10/16<p>
 *  * <p>版本号：1<p>
 *  *
 *  
 */
public class TrailerFragmentAdapter extends RecyclerView.Adapter<TrailerFragmentAdapter.MyViewHolder>{

    private List<Video> list;
    private Context context;

    public TrailerFragmentAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Video> data){
        if (data!=null){
            list.addAll(data);
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trailer_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tr.setUp(list.get(position).shearUrl,null);
        holder.text_num.setText(list.get(position).buyNum+"");
        Date date = new Date(list.get(position).createTime);
        SimpleDateFormat format = new SimpleDateFormat("mm");
        holder.text_time.setText(format.format(date));
        Date date1 = new Date(list.get(position).duration);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        holder.text_times.setText(simpleDateFormat.format(date1));
    }




    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

         TextView text_num;
         TextView text_time;
         TextView text_times;
        JCVideoPlayer tr;

        public MyViewHolder(View view) {
            super(view);
            tr = itemView.findViewById(R.id.trailer_movie);
            text_num = itemView.findViewById(R.id.text_num);
            text_time = itemView.findViewById(R.id.text_time);
            text_times = itemView.findViewById(R.id.text_times);
        }
    }
}
