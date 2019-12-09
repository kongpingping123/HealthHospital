package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述 查询病友圈详情
 * @CreateDate: 2019/12/5 20:46
 * @Author: 作者名
 * @Version: 1.0
 */
public class FindSickCircleInfoPresenter extends WDPresenter<IAppRequest> {
    public FindSickCircleInfoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findSickCircleInfo((int)args[0]);
    }
}
