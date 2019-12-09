package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述  病友圈列表数据
 * @CreateDate: 2019/12/5 15:03
 * @Author: 作者名
 * @Version: 1.0
 */
public class FindSickCircleListPresenter extends WDPresenter<IAppRequest> {

    public FindSickCircleListPresenter(DataCall consumer) {
        super(consumer);
    }

    @Override
    protected Observable getModel(Object... args) {
       return iRequest.findSickCircleList((int) args[0], (int) args[1], (int) args[2]);
    }
}
