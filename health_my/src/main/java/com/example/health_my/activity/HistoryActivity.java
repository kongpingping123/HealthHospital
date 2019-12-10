package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.LViennaAdpater;
import com.example.health_my.presenter.LViennaPresenter;
import com.wd.common.bean.LVienna;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends WDActivity {

    @BindView(R2.id.rlv)
    RecyclerView rlv;
    @BindView(R2.id.rll_vienna)
    RelativeLayout rllVienna;
    @BindView(R2.id.rll_viennas)
    RelativeLayout rllViennas;
    private LViennaPresenter lViennaPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private LViennaAdpater lViennaAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);

        lViennaPresenter = new LViennaPresenter(new LviennaPresen());
        lViennaPresenter.reqeust(id, sessionId, 1, 5);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rlv.setLayoutManager(linearLayoutManager);
        lViennaAdpater = new LViennaAdpater(HistoryActivity.this);
        rlv.setAdapter(lViennaAdpater);

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

    private class LviennaPresen implements DataCall<List<LVienna>> {

        private LVienna lVienna;

        @Override
        public void success(List<LVienna> data, Object... args) {
            for (int i = 0; i < data.size(); i++) {
                lVienna = data.get(i);
            }
            if (lVienna.doctorName != null) {
                rllVienna.setVisibility(View.GONE);
                rllViennas.setVisibility(View.VISIBLE);
                lViennaAdpater.addAll(data);

                lViennaAdpater.notifyDataSetChanged();
            }else if (lVienna.doctorName == null) {
                rllViennas.setVisibility(View.GONE);
                rllVienna.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
