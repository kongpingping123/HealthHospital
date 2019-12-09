package com.wd.health_main.activity;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.bean.DonBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.presenter.DomPresenter;
 @Route(path = Constant.ACTIVITY_URL_Don)
public class DonActivity extends WDActivity {

    private DomPresenter domPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.don_layout;
    }

    @Override
    protected void initView() {
        domPresenter = new DomPresenter(new dom());
          domPresenter.reqeust(17);
    }

    @Override
    protected void destoryData() {

    }

    private class dom implements DataCall<DonBase> {

        @Override
        public void success(DonBase data, Object... args) {
            Log.d("aaa", "success: "+data);

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
