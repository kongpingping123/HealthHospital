package com.wd.health_main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.CommBase;

import com.wd.common.bean.Result;
import com.wd.health_main.R;

import java.util.ArrayList;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MyCommadapter extends BaseQuickAdapter<CommBase, BaseViewHolder> {

    public MyCommadapter(int layoutResId, @Nullable List<CommBase> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommBase item) {
        helper.setText(R.id.coom_view1,item.diseaseCategoryId);
    }
}
