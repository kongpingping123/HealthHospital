package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class YaoPresenter extends WDPresenter<IAppRequest> {
    public YaoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.yaofinddrugsknglist((int)args[0],(int)args[1],(int)args[2]);

    }
}
