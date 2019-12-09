package com.wd.health_main.activity;

import android.content.Intent;
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

import org.greenrobot.greendao.annotation.Id;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = Constant.ACTIVITY_URL_Com)
public class CommonActivity extends WDActivity {


    @BindView(R2.id.adssad)
    TextView adssad;
    @BindView(R2.id.a1)
    TextView a1;
    @BindView(R2.id.a2)
    TextView a2;
    @BindView(R2.id.a3)
    TextView a3;
    @BindView(R2.id.a4)
    TextView a4;

    private CommPresenter commPresenter;
    private int ss;
    private int i;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_common;
    }

    @Override
    protected void initView() {
        commPresenter = new CommPresenter(new comm());
        Intent intent = getIntent();
        ss = intent.getIntExtra("id", 0);
        i = intent.getIntExtra("i", 0);
        commPresenter.reqeust(ss,i);



    }

    @Override
    protected void destoryData() {

    }




    private class comm implements DataCall<CommBase> {



        @Override
        public void success(CommBase data, Object... args) {



            a1.setText(data.symptom);
            adssad.setText(data.pathology);
            a2.setText(data.chineseMedicineTreatment);
            a3.setText(data.benefitTaboo);
            a4.setText(data.diseaseCategoryId);
         //   a5.setText(data.id);




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
