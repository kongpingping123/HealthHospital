package com.wd.health_main.adapter;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.DepartmentBean;
import com.wd.health_main.R;

import java.util.List;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/5 19:03
 * @Author: 作者名
 * @Version: 1.0
 */
public class FindDepartmentAdapter extends BaseQuickAdapter<DepartmentBean, BaseViewHolder> {
    public FindDepartmentAdapter(int layoutResId, @Nullable List<DepartmentBean> data) {
        super(layoutResId, data);
    }
    private int myposition;
    public void getIndex(int myposition){
        this.myposition= myposition;
    }
    @Override
    protected void convert(final BaseViewHolder helper, DepartmentBean item) {
        helper.setText(R.id.depart_tv," "+item.departmentName+"      ");
        final int position = helper.getLayoutPosition();
        if (position==myposition){
            helper.setTextColor(R.id.depart_tv, Color.BLUE);
        }else {
            helper.setTextColor(R.id.depart_tv,Color.GRAY);
        }
        final int  idd=  item.id;
        final String name = item.departmentName;
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.setTextColor(R.id.depart_tv, Color.BLUE);
                work.sad(idd,name,position);
            }
        });

    }
    private Work work;

    public void setWork(Work work) {
        this.work = work;
    }

    public interface Work{
        void sad(int id,String name,int myposition);
    }
}
