package com.wd.health_patient.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;
import com.wd.common.core.http.IAppRequest;

import io.reactivex.Observable;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/10 15:38
 * @Author: 作者名
 * @Version: 1.0
 */
public class FindDoctorListPresenter extends WDPresenter<IAppRequest> {
    public FindDoctorListPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return iRequest.findDoctorList((int)args[0],(int)args[1],(int)args[2],(int)args[3],(int)args[4]);
    }
}
