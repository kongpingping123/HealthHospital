package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;


public class AddUserVideoPresenter extends WDPresenter<IAppRequest> {

    public AddUserVideoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.addUserVideoCollection((int)args[0],(String) args[1],(int)args[2]);
    }
}
