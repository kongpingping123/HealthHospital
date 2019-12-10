package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/9 14:06
 * @Author: 作者名
 * @Version: 1.0
 */
public class SearchSickCirclePresenter extends WDPresenter<IAppRequest> {
    public SearchSickCirclePresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.searchSickCircle((String)args[0]);
    }
}
