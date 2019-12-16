package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.FollowAdpater;
import com.example.health_my.presenter.FollowPresenter;
import com.wd.common.bean.Querydoctor;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowActivity extends WDActivity {


    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.login_iv)
    TextView loginIv;
    @BindView(R2.id.imagetss)
    ImageView imagetss;
    @BindView(R2.id.text_tv)
    TextView textTv;
    @BindView(R2.id.rll_vienna)
    RelativeLayout rllVienna;
    @BindView(R2.id.follow_rlv)
    RecyclerView followRlv;
    @BindView(R2.id.rll_viennas)
    RelativeLayout rllViennas;
    private FollowPresenter followPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private FollowAdpater followAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_follow;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        followPresenter = new FollowPresenter(new FollowPresen());
        followPresenter.reqeust(id,sessionId,1,5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        followRlv.setLayoutManager(linearLayoutManager);
        followAdpater = new FollowAdpater(FollowActivity.this);
        followRlv.setAdapter(followAdpater);
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

    private class FollowPresen implements DataCall<List<Querydoctor>> {
        @Override
        public void success(List<Querydoctor> data, Object... args) {
            if (data != null) {
                rllVienna.setVisibility(View.GONE);
                rllViennas.setVisibility(View.VISIBLE);
                followAdpater.addAll(data);
                followAdpater.notifyDataSetChanged();
            }else if (data == null) {
                rllVienna.setVisibility(View.VISIBLE);
                rllViennas.setVisibility(View.GONE);
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
