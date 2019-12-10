package com.example.health_my.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class PlishPresenter extends WDPresenter<IAppRequest> {

    public PlishPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.updateUserPwd((String)args[0],(String)args[1],(String)args[2],(String)args[3]);
    }
}
