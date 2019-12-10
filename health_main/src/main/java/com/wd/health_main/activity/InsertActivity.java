package com.wd.health_main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wd.common.bean.IntBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.presenter.IntjingPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InsertActivity extends WDActivity {

    @BindView(R2.id.drugs_name)
    TextView drugsName;
    @BindView(R2.id.drugs_chengfen)
    TextView drugsChengfen;
    @BindView(R2.id.drugs_jinji)
    TextView drugsJinji;
    @BindView(R2.id.drugs_zhuzhi)
    TextView drugsZhuzhi;
    @BindView(R2.id.drugs_yongfa)
    TextView drugsYongfa;
    @BindView(R2.id.drugs_xingzhuang)
    TextView drugsXingzhuang;
    @BindView(R2.id.drugs_baozhuang)
    TextView drugsBaozhuang;
    @BindView(R2.id.drugs_fanying)
    TextView drugsFanying;
    @BindView(R2.id.drugs_chucang)
    TextView drugsChucang;
    @BindView(R2.id.drugs_shixiang)
    TextView drugsShixiang;
    @BindView(R2.id.drugs_wenhao)
    TextView drugsWenhao;
    private IntjingPresenter intjingPresenter;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.drugs_details_layout;
    }

    @Override
    protected void initView() {
        intjingPresenter = new IntjingPresenter(new intko());
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        intjingPresenter.reqeust(2);


    }

    @Override
    protected void destoryData() {

    }


     class intko implements DataCall<IntBase> {

        @Override
        public void success(IntBase data, Object... args) {
            Log.d("aaa1", "success: " + data);
          drugsChengfen.setText(data.approvalNumber);
       drugsJinji.setText(data.component);
           drugsZhuzhi.setText(data.effect);
           drugsYongfa.setText(data.mindMatter);
           drugsXingzhuang.setText(data.name);
           drugsBaozhuang.setText(data.shape);
           drugsFanying.setText(data.sideEffects);
           drugsChucang.setText(data.storage);
           drugsShixiang.setText(data.taboo);
           drugsWenhao.setText(data.usage);


        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
