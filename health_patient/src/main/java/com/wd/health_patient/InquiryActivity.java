package com.wd.health_patient;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.DoctorBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.adapter.FindDepartmentAdapter;
import com.wd.health_main.presenter.FindDepartmentPresenter;
import com.wd.health_patient.adapter.InquiryAdapter;
import com.wd.health_patient.presenter.FindDoctorListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wd.common.core.WDApplication.getContext;

@Route(path = Constant.ACTIVITY_URL_INQUIRY)
public class InquiryActivity extends WDActivity {


    @BindView(R2.id.inquiry_rv)
    RecyclerView inquiryRv;
    @BindView(R2.id.tv_zh)
    TextView tvZh;
    @BindView(R2.id.tv_hp)
    TextView tvHp;
    @BindView(R2.id.tv_zxs)
    TextView tvZxs;
    @BindView(R2.id.tv_price)
    TextView tvPrice;
    @BindView(R2.id.sdv_pic)
    SimpleDraweeView sdvPic;
    @BindView(R2.id.tv_name)
    TextView tvName;
    @BindView(R2.id.tv_jobTitle)
    TextView tvJobTitle;
    @BindView(R2.id.tv_inauguralHospital)
    TextView tvInauguralHospital;
    @BindView(R2.id.tv_praiseNum)
    TextView tvPraiseNum;
    @BindView(R2.id.tv_serverNum)
    TextView tvServerNum;
    @BindView(R2.id.tv_servicePrice)
    TextView tvServicePrice;
    @BindView(R2.id.tv_ask)
    TextView tvAsk;
    @BindView(R2.id.sdv_left)
    SimpleDraweeView sdvLeft;
    @BindView(R2.id.sdv_right)
    SimpleDraweeView sdvRight;
    @BindView(R2.id.rv_doctor)
    RecyclerView rvDoctor;
    private FindDoctorListPresenter findDoctorListPresenter;
    private int idddd;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_inquiry;
    }

    @Override
    protected void initView() {
        //科室列表
        FindDepartmentPresenter findDepartmentPresenter = new FindDepartmentPresenter(new Depart());
        findDepartmentPresenter.reqeust();
        //医生列表
        findDoctorListPresenter = new FindDoctorListPresenter(new Doctor());
        findDoctorListPresenter.reqeust(2, 4, 1, 1, 5);
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

    @OnClick({R2.id.tv_zh, R2.id.tv_hp, R2.id.tv_zxs, R2.id.tv_price})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.tv_zh) {
            findDoctorListPresenter.reqeust(idddd, 1, 1, 1, 5);
        } else if (id == R.id.tv_hp) {
            findDoctorListPresenter.reqeust(idddd, 2, 1, 1, 5);
        } else if (id == R.id.tv_zxs) {
            findDoctorListPresenter.reqeust(idddd, 3, 1, 1, 5);
        } else if (id == R.id.tv_price) {
            findDoctorListPresenter.reqeust(idddd, 4, 1, 1, 5);
        }
    }

    private class Depart implements DataCall<List<DepartmentBean>> {
        @Override
        public void success(List<DepartmentBean> data, Object... args) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            inquiryRv.setLayoutManager(linearLayoutManager);
            FindDepartmentAdapter wellreceived = new FindDepartmentAdapter(com.wd.health_main.R.layout.depart_item, data);
            wellreceived.setWork(new FindDepartmentAdapter.Work() {
                @Override
                public void sad(int id, String name) {
                    idddd = id;
                    findDoctorListPresenter.reqeust(idddd, 4, 1, 1, 5);
                }
            });
            inquiryRv.setAdapter(wellreceived);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class Doctor implements DataCall<List<DoctorBean>> {
        @Override
        public void success(List<DoctorBean> result, Object... args) {
            sdvPic.setImageURI(result.get(0).imagePic);
            tvName.setText(result.get(0).doctorName);
            tvInauguralHospital.setText(result.get(0).inauguralHospital);
            tvJobTitle.setText(result.get(0).jobTitle);
            tvPraiseNum.setText("好评率   " + result.get(0).praise);
            tvServerNum.setText("服务患者数   " + result.get(0).serverNum);
            tvServicePrice.setText(result.get(0).servicePrice + "H币/次");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(InquiryActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvDoctor.setLayoutManager(linearLayoutManager);
            InquiryAdapter inquiryAdapter = new InquiryAdapter(R.layout.inquiry_item, result);
            rvDoctor.setAdapter(inquiryAdapter);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
