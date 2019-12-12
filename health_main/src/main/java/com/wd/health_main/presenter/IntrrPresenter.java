package com.wd.health_main.presenter;


import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;


/**
 * Time:  2019-12-04
 * Author:
 * Description:
 */
public class IntrrPresenter extends WDPresenter<IAppRequest>  {


    public IntrrPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.bannershow();
    }
}
