package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;


public class AddVideoCommentPresenter extends WDPresenter<IAppRequest> {

    public AddVideoCommentPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.addVideoComment((int)args[0],(String) args[1],(int)args[2],(String) args[3]);
    }
}
