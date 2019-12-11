package com.example.health_write.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import com.example.health_write.R;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter {

    private List<String> list;
    private Context context;

    public ImageAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void addItem(String uri){
        if (!TextUtils.isEmpty(uri))
             list.add(0,uri);
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.circle_image_item, null);
        ImageHolder imageHolder = new ImageHolder(inflate);

       return imageHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ImageHolder imageHolder = new ImageHolder(holder.itemView);


        if (Util.isOnMainThread()) {
            Glide.with(context).load(list.get(position)).into(imageHolder.images);
        }
        imageHolder.images.setImageURI(Uri.parse(list.get(position)));
        if (position==list.size()-1){
            imageHolder.images.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.onItemClick(position);
                    notifyDataSetChanged();
                }
            });
        }else{
            imageHolder.images.setOnClickListener(null);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder{
        ImageView images;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
        }
    }

    private OnItemClickListenerx mOnItemClickListener;

    public void onItemClickListenerx(OnItemClickListenerx onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListenerx{
        void onItemClick(int position);
    }
}
