package com.wd.health_main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wd.common.bean.SearchBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.SearchAdpater;
import com.wd.health_main.presenter.SearchSickCirclePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends WDActivity {


    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.tv_shou)
    EditText tvShou;
    @BindView(R2.id.shou)
    TextView shou;
    @BindView(R2.id.rv_sear)
    RecyclerView rvSear;
    @BindView(R2.id.im_no)
    RelativeLayout imNo;
    private SearchSickCirclePresenter searchSickCirclePresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        searchSickCirclePresenter = new SearchSickCirclePresenter(new Search());

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

    @OnClick({R2.id.back, R2.id.shou})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.shou) {
            String pwd = tvShou.getText().toString().trim();
            searchSickCirclePresenter.reqeust(pwd);
        }
    }

    private class Search implements DataCall<List<SearchBean>> {

        private String title;

        @Override
        public void success(final List<SearchBean> data, Object... args) {
            //判断是否为空
            for (int i = 0; i < data.size(); i++) {
                title = data.get(i).title;
            }
            if (title == null) {
                imNo.setVisibility(View.VISIBLE);
                rvSear.setVisibility(View.GONE);
            }else {
                imNo.setVisibility(View.GONE);
                rvSear.setVisibility(View.VISIBLE);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvSear.setLayoutManager(linearLayoutManager);
                SearchAdpater wellreceived = new SearchAdpater(R.layout.circle_item, data);
                rvSear.setAdapter(wellreceived);
                wellreceived.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                        int sickCircleId = data.get(position).sickCircleId;
                        Intent intent = new Intent(SearchActivity.this, DetailsActivity.class);
                        intent.putExtra("sickCircleId", sickCircleId);
                        startActivity(intent);
                    }
                });
            }

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
