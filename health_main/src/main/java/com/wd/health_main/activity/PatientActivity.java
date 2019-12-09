package com.wd.health_main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.PatientBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.PatientAdpater;
import com.wd.health_main.presenter.FindPatientSickCircleListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wd.common.core.WDApplication.getContext;

public class PatientActivity extends WDActivity {


    @BindView(R2.id.patient_img)
    SimpleDraweeView patientImg;
    @BindView(R2.id.patient_name)
    TextView patientName;
    @BindView(R2.id.patient_rv)
    RecyclerView patientRv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_patient;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String name = intent.getStringExtra("name");
        int commentId = intent.getIntExtra("commentId",0);
        patientImg.setImageURI(image);
        patientName.setText(name);
        FindPatientSickCircleListPresenter findPatientSickCircleListPresenter = new FindPatientSickCircleListPresenter(new SickCircleList());
        findPatientSickCircleListPresenter.reqeust(commentId,1,5);
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

    private class SickCircleList implements DataCall <List<PatientBean>> {
        @Override
        public void success(final List<PatientBean> data, Object... args) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            patientRv.setLayoutManager(linearLayoutManager);
            PatientAdpater wellreceived = new PatientAdpater(R.layout.circle_item, data);
            patientRv.setAdapter(wellreceived);
            wellreceived.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                    int sickCircleId = data.get(position).sickCircleId;
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("sickCircleId", sickCircleId);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
