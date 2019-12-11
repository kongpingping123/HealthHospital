package com.wd.health_main.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.common.bean.SousuoBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SousuoActivity extends WDActivity {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.nr)
    EditText nr;
    @BindView(R2.id.search)
    TextView search;
    @BindView(R2.id.searrecycleview)
    RecyclerView searrecycleview;

    @Override
    protected int getLayoutId() {
        return R.layout.sousuo_layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void destoryData() {

    }


    @OnClick({R2.id.back, R2.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R2.id.back:
                finish();
                break;
            case R2.id.search:

                break;
        }
    }

    class sousuo implements DataCall<List<SousuoBase>>{

        @Override
        public void success(List<SousuoBase> data, Object... args) {
            Log.d("aaa", "success: "+data);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
