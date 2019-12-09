package com.wd.health_main.presenter;

import com.wd.common.core.CyzPresenter;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/7 11:35
 * @Author: 作者名
 * @Version: 1.0
 */
public class PublishCommentPresenter  extends CyzPresenter<IAppRequest> {
    public PublishCommentPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.publishComment((String)args[0],(String)args[1],(int)args[2],(String)args[3]);
    }
}
