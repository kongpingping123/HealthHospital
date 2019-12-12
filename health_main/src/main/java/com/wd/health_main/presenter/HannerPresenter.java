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
public class HannerPresenter extends WDPresenter<IAppRequest>  {


    public HannerPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.intecaifanyijian((int)args[0],(int)args[1]);
    }
}
