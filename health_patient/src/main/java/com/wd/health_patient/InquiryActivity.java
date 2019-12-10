package com.wd.health_patient;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.DoctorBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.adapter.FindDepartmentAdapter;
import com.wd.health_main.presenter.FindDepartmentPresenter;
import com.wd.health_patient.presenter.FindDoctorListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wd.common.core.WDApplication.getContext;

@Route(path = Constant.ACTIVITY_URL_INQUIRY)
public class InquiryActivity extends WDActivity {


    @BindView(R2.id.inquiry_rv)
    RecyclerView inquiryRv;

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
        FindDoctorListPresenter findDoctorListPresenter = new FindDoctorListPresenter(new Doctor());
        findDoctorListPresenter.reqeust(2,4,1,1,5);
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

                }
            });
            inquiryRv.setAdapter(wellreceived);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class Doctor implements DataCall <List<DoctorBean>>{
        @Override
        public void success(List<DoctorBean> data, Object... args) {

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
