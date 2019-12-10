package com.wd.health_main.adapter;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.DepartmentBean;
import com.wd.health_main.R;

import java.util.List;

/**
 * @Description: 作用描述 问诊咨询
 * @CreateDate: 2019/12/5 19:03
 * @Author: 作者名
 * @Version: 1.0
 */
public class DepartmentAdapter extends BaseQuickAdapter<DepartmentBean, BaseViewHolder> {
    public DepartmentAdapter(int layoutResId, @Nullable List<DepartmentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, DepartmentBean item) {
        helper.setText(R.id.show_inner_name,item.departmentName);
        ImageView imageView = helper.getView(R.id.show_inner);
        Uri uri = Uri.parse(item.pic);
        imageView.setImageURI(uri);
        final int  idd=  item.id;
        final String name = item.departmentName;
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work.sad(idd,name);
            }
        });

    }
    private Work work;

    public void setWork(Work work) {
        this.work = work;
    }

    public interface Work{
        void sad(int id, String name);
    }
}
