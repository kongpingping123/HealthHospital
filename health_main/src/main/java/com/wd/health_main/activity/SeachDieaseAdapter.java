package com.wd.health_main.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.common.bean.SousuoBase;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeachDieaseAdapter extends RecyclerView.Adapter<SeachDieaseAdapter.ViewHolder> {

    private List<SousuoBase.DiseaseSearchVoListBean> list;
    private Context context;

    public SeachDieaseAdapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void AddAll(List<SousuoBase.DiseaseSearchVoListBean>diseaseSearchVoListBeans){
        if (diseaseSearchVoListBeans!=null){
            list.addAll(diseaseSearchVoListBeans);
        }
    }

    @NonNull
    @Override
    public SeachDieaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(context).inflate(R.layout.t1_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeachDieaseAdapter.ViewHolder holder, int position) {
             holder.textView.setText(list.get(position).diseaseName);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text3);
        }
    }
}
