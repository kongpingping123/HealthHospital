package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.presenter.ViennaPresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.Vienna;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.DateUtils;

import java.text.ParseException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViennaActivity extends WDActivity {


    @BindView(R2.id.rlv_vienna)
    RelativeLayout rlvVienna;
    @BindView(R2.id.rlv_viennas)
    RelativeLayout rlvViennas;
    @BindView(R2.id.sdvimager)
    SimpleDraweeView sdvimager;
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.text_doctor)
    TextView textDoctor;
    @BindView(R2.id.text_Department)
    TextView textDepartment;
    @BindView(R2.id.text_time)
    TextView textTime;
    @BindView(R2.id.but_vienna)
    Button butVienna;
    @BindView(R2.id.but_viennas)
    Button butViennas;
    @BindView(R2.id.text_tv)
    TextView textTv;
    private ViennaPresenter viennaPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vienna;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        viennaPresenter = new ViennaPresenter(new ViennaPresen());
        viennaPresenter.reqeust(id, sessionId);
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

    private class ViennaPresen implements DataCall<Vienna> {
        @Override
        public void success(Vienna data, Object... args) {
            if (data.doctorName != null) {
                rlvVienna.setVisibility(View.GONE);
                rlvViennas.setVisibility(View.VISIBLE);


                sdvimager.setImageURI(data.imagePic);
                textName.setText(data.doctorName);
                textDoctor.setText(data.jobTitle);
                textDepartment.setText(data.department);
                try {
                    textTime.setText(DateUtils.dateFormat(new Date((data.inquiryTime)), DateUtils.MINUTE_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
