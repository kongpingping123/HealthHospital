package com.wd.health_main.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.wd.health_main.R;
import java.util.ArrayList;
import java.util.List;

public class ListAdpater extends BaseAdapter {
    private List<String> list = new ArrayList<>();

    public void addAll(List<String> data){
        if (data != null) {
             list.addAll(data);
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHoder holder;
        if (convertView == null) {
            holder = new ViewHoder();
            convertView = View.inflate(parent.getContext(), R.layout.item_sousuo,null);
            holder.text_tv = convertView.findViewById(R.id.text_tv);
            holder.text_ivs = convertView.findViewById(R.id.text_ivs);
            convertView.setTag(holder);
        }else {
            holder = (ViewHoder) convertView.getTag();
        }
           holder.text_tv.setText(list.get(position));
           holder.text_ivs.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   list.remove(position);
               }
           });
        return convertView;
    }

    class ViewHoder{
         TextView text_tv;
         ImageView text_ivs;
    }
}
