package com.example.health_my.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class InFoPresenter extends WDPresenter<IAppRequest> {

    public InFoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findUserInfoCollectionList((int)args[0],(String)args[1],(int)args[2],(int)args[3]);
    }
}
