package com.wd.health_main.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.DtonBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.Consultation_DetailsAdapter;
import com.wd.health_main.presenter.DisePresenter;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeiserActivity extends WDActivity {

    @BindView(R2.id.consultation_back)
    SimpleDraweeView consultationBack;
    @BindView(R2.id.consultation_view)
    RecyclerView consultationView;
    @BindView(R2.id.consult_xing)
    ImageView consultXing;
    @BindView(R2.id.consult_xingy)
    ImageView consultXingy;
    @BindView(R2.id.consult_share)
    ImageView consultShare;
    private DisePresenter disePresenter;
    private int id;
    private Consultation_DetailsAdapter consultation_detailsAdapter;
    @Override
    protected int getLayoutId() {

        return R.layout.activity_consultation__details;
    }

    @Override
    protected void initView() {
        disePresenter = new DisePresenter(new dijing());
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        disePresenter.reqeust(id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DeiserActivity.this);
        consultationView.setLayoutManager(linearLayoutManager);
        consultation_detailsAdapter = new Consultation_DetailsAdapter();
        consultationView.setAdapter(consultation_detailsAdapter);
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

    @OnClick({R2.id.consultation_back, R2.id.consult_xing, R2.id.consult_xingy, R2.id.consult_share})
    public void onViewClicked(View view) {
        int viewId = view.getId();
        if (viewId == R.id.consultation_back) {
            finish();
        } else if (viewId == R.id.consult_xing) {
        } else if (viewId == R.id.consult_xingy) {
        } else if (viewId == R.id.consult_share) {
        }
    }

    class dijing implements DataCall<DtonBase> {

        private Uri parse;

        @Override
        public void success(DtonBase data, Object... args) {
            consultation_detailsAdapter.addAll(Arrays.asList(data));
            consultation_detailsAdapter.notifyDataSetChanged();
        }


        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
