package com.wd.health_main.presenter;

import com.wd.common.core.DataCall;
import com.wd.common.core.WDPresenter;

import io.reactivex.Observable;

/**
 * Time:  2019-12-04
 * Author:  杨世博
 * Description:
 */
public class BannerPresenter extends WDPresenter {
    public BannerPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(Object... args) {
        return null;
    }
}
