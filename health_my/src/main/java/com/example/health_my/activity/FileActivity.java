package com.example.health_my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.wd.common.core.WDActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileActivity extends WDActivity {


    @BindView(R2.id.text_add)
    TextView textAdd;
    @BindView(R2.id.re_add)
    RelativeLayout reAdd;
    @BindView(R2.id.re_bing)
    RelativeLayout reBing;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_file;
    }

    @Override
    protected void initView() {
        textAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reAdd.setVisibility(View.GONE);
                reBing.setVisibility(View.VISIBLE);
            }
        });
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
