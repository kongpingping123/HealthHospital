package com.wd.health_main.presenter;

import com.wd.common.core.CyzPresenter;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/6 15:55
 * @Author: 作者名
 * @Version: 1.0
 */
public class FindSickCircleCommentListPresenter extends WDPresenter<IAppRequest> {
    public FindSickCircleCommentListPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findSickCircleCommentList((int)args[0],(int)args[1],(int)args[2]);
    }
}
