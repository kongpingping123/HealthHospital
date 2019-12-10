package com.wd.health_patient.adapter;

import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.DoctorBean;
import com.wd.health_patient.R;

import java.util.List;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/10 20:23
 * @Author: 作者名
 * @Version: 1.0
 */
public class InquiryAdapter extends BaseQuickAdapter<DoctorBean, BaseViewHolder> {
    public InquiryAdapter(int layoutResId, @Nullable List<DoctorBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DoctorBean item) {
        helper.setText(R.id.inquiry_tv,item.doctorName);
        ImageView imageView = helper.getView(R.id.inquiry_sim);
        Uri uri = Uri.parse(item.imagePic);
        imageView.setImageURI(uri);
    }
}
