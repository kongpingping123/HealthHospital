package com.example.health_my.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class ViennaPresenter extends WDPresenter<IAppRequest> {

    public ViennaPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findCurrentInquiryRecord((int)args[0],(String)args[1]);
    }
}
