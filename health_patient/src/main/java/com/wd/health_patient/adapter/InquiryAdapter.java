package com.wd.health_patient.adapter;

import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private int myposition;
    public void getIndex(int myposition){
        this.myposition= myposition;
    }
    @Override
    protected void convert(final BaseViewHolder helper, DoctorBean item) {
        helper.setText(R.id.inquiry_tv,item.doctorName);
        helper.setText(R.id.inquiry_tv_bule,item.doctorName);
        final TextView textView =  helper.getView(R.id.inquiry_tv);
        final TextView bule =  helper.getView(R.id.inquiry_tv_bule);
        ImageView imageView = helper.getView(R.id.inquiry_sim);
        final Uri image = Uri.parse(item.imagePic);
        imageView.setImageURI(image);
        final int position = helper.getLayoutPosition();
        final String name = item.doctorName;
        final String inauguralHospital = item.inauguralHospital;
        final String jobTitle =   item.jobTitle;
        final String praise = item.praise;
        final int serverNum = item.serverNum;
        final int servicePrice = item.servicePrice;
        if (position==myposition){
            textView.setVisibility(View.GONE);
            bule.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.VISIBLE);
            bule.setVisibility(View.GONE);
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctor.sad(image,name,position,inauguralHospital,jobTitle,praise,serverNum,servicePrice);
            }
        });
    }
    private Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public interface Doctor{
        void sad(Uri image,String name,int myposition,String inauguralHospital,String jobTitle,String praise,int serverNum,int servicePrice);
    }
}
