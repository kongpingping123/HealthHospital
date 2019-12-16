package com.wd.health_patient.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.core.WDActivity;
import com.wd.health_patient.R;
import com.wd.health_patient.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorDetailsActivity extends WDActivity {


    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.login_iv)
    TextView loginIv;
    @BindView(R2.id.doctor_sim)
    SimpleDraweeView doctorSim;
    @BindView(R2.id.details_name)
    TextView detailsName;
    @BindView(R2.id.doctor_yishi)
    TextView doctorYishi;
    @BindView(R2.id.doctor_yuan)
    TextView doctorYuan;
    @BindView(R2.id.doctor_lv)
    TextView doctorLv;
    @BindView(R2.id.doctor_shu)
    TextView doctorShu;
    @BindView(R2.id.doctor_view)
    View doctorView;
    @BindView(R2.id.doctor_flower)
    ImageView doctorFlower;
    @BindView(R2.id.hua)
    TextView hua;
    @BindView(R2.id.doctor_flowe)
    ImageView doctorFlowe;
    @BindView(R2.id.shuben)
    TextView shuben;
    @BindView(R2.id.doctor_flow)
    ImageView doctorFlow;
    @BindView(R2.id.jiangbei)
    TextView jiangbei;
    @BindView(R2.id.doctor_v)
    View doctorV;
    @BindView(R2.id.jianli)
    TextView jianli;
    @BindView(R2.id.doctor_vt)
    View doctorVt;
    @BindView(R2.id.jianl)
    TextView jianl;
    @BindView(R2.id.doctor_vtt)
    View doctorVtt;
    @BindView(R2.id.rv_doctor)
    RecyclerView rvDoctor;
    @BindView(R2.id.hbi)
    TextView hbi;
    @BindView(R2.id.tiaozhuan)
    TextView tiaozhuan;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doctor_details;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void destoryData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
