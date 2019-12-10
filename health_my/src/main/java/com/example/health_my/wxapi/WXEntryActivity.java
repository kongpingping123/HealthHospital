package com.example.health_my.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.wd.common.core.WDApplication;

import org.greenrobot.eventbus.EventBus;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WDApplication.getWXApi().handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                EventBus.getDefault().postSticky(baseResp);
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                Toast.makeText(this, "取消微信登陆", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        finish();
        String result;
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (baseResp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    result = "支付已完成";
                    break;

                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    result = "支付已取消";
                    break;

                default:
                    result = baseResp.errStr == null ? "支付遇到问题" : baseResp.errStr;
                    break;
            }
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            finish();

        }
    }
}
