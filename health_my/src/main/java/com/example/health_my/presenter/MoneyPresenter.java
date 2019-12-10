package com.example.health_my.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.WDPresenters;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

public class MoneyPresenter extends WDPresenters<IAppRequest> {

    public MoneyPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findUserWallet((int)args[0],(String)args[1]);
    }
}
