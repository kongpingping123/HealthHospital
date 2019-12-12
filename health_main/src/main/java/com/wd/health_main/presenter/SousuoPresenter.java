package com.wd.health_main.presenter;

import android.content.Intent;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class SousuoPresenter extends WDPresenter<IAppRequest> {
    public SousuoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.ousuohomepage((int) args[0]);
    }
}
