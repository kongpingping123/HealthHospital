package com.example.health_my.activity;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.health_my.R;
import com.wd.common.bean.InteBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;

import java.util.List;


@Route(path = Constant.ACTIVITY_URL_Int)
public class InterviewActivity extends WDActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.interview_layout;

    }

    @Override
    protected void initView() {




    }

    @Override
    protected void destoryData() {

    }

     class interview implements DataCall<List<InteBase>>{

         @Override
         public void success(List<InteBase> data, Object... args) {
             Log.d("aaa", "success: "+data);
         }

         @Override
         public void fail(ApiException data, Object... args) {

         }
     }
}
