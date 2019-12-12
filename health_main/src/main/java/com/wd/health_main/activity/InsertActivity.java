package com.wd.health_main.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.bean.IntBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.presenter.IntjingPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = Constant.ACTIVITY_URL_Coms)
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
    private int ids;
    private SharedPreferences sp;

    @Override
    protected int getLayoutId() {
        return R.layout.drugs_details_layout;
    }

    @Override
    protected void initView() {
        intjingPresenter = new IntjingPresenter(new intko());
        sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        ids = sp.getInt("Ids", 0);
        intjingPresenter.reqeust(ids);


    }

    @Override
    protected void destoryData() {

    }


     class intko implements DataCall<IntBase> {

        @Override
        public void success(IntBase data, Object... args) {

            drugsName.setText(data.name);
            drugsChengfen.setText(data.component);
            drugsJinji.setText(data.taboo);
            drugsZhuzhi.setText(data.effect);
            drugsYongfa.setText(data.usage);
            drugsXingzhuang.setText(data.shape);
            drugsBaozhuang.setText(data.packing);
            drugsFanying.setText(data.sideEffects);
            drugsChucang.setText(data.storage);
            drugsShixiang.setText(data.mindMatter);
            drugsWenhao.setText(data.approvalNumber);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
