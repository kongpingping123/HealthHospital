package com.wd.health_main.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.bean.CommBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.presenter.CommPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = Constant.ACTIVITY_URL_Com)
public class CommonActivity extends WDActivity {



    @BindView(R2.id.a1)
    TextView a1;
    @BindView(R2.id.a2)
    TextView a2;
    @BindView(R2.id.a3)
    TextView a3;
    @BindView(R2.id.a4)
    TextView a4;
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.a5)
    TextView a5;

    private CommPresenter commPresenter;
    private int ss;
    private int i;
    private SharedPreferences sp;
    private int id;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_common;
    }

    @Override
    protected void initView() {
        commPresenter = new CommPresenter(new comm());
        sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        id = sp.getInt("Id", 0);
        name = sp.getString("Name", "");
        commPresenter.reqeust(id, name);

        textName.setText(name);
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


    private class comm implements DataCall<CommBase> {

        @Override
        public void success(CommBase data, Object... args) {

            a1.setText(data.pathology);
            a2.setText(data.symptom);
            a3.setText(data.benefitTaboo);

            if (data.chineseMedicineTreatment != null) {
                a4.setText(data.chineseMedicineTreatment);
            }else if (data.chineseMedicineTreatment == null) {
                a4.setText("无");
            }

            if (data.westernMedicineTreatment != null) {
                a5.setText(data.westernMedicineTreatment);
            }else if (data.westernMedicineTreatment == null){
                a5.setText("无");
            }


        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }


  /*  //接口回调
    private Onkong onkong;

    public void setOnkong(Onkong onkong) {

        this.onkong = onkong;
    }

    public interface Onkong{

        void onkong(int Id);

    }*/
}
