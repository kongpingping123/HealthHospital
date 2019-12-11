package com.wd.health_main.activity;

import android.os.Bundle;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GengduoActivity extends WDActivity {
    @BindView(R2.id.xrecycler_view)
    XRecyclerView xrecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.gengduo_layout;
    }

    @Override
    protected void initView() {




    }

    @Override
    protected void destoryData() {

    }



     class gengduo implements DataCall<List<DepartmentBean>>{

         @Override
         public void success(List<DepartmentBean> data, Object... args) {

         }

         @Override
         public void fail(ApiException data, Object... args) {

         }
     }
}
