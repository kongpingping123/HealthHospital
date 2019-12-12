package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.encrypted.RsaCoder;
import com.example.health_my.presenter.LoginPresenter;
import com.example.health_my.presenter.WeiXinPresenter;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.wd.common.bean.Login;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.WDApplication;
import com.wd.common.core.exception.ApiException;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends WDActivity {


    @BindView(R2.id.login_iv)
    ImageView loginIv;
    @BindView(R2.id.ed_email)
    EditText edEmail;
    @BindView(R2.id.ed_pwd)
    EditText edPwd;
    @BindView(R2.id.tv_login)
    Button tvLogin;
    @BindView(R2.id.wjpwd)
    TextView wjpwd;
    @BindView(R2.id.zhuce)
    TextView zhuce;
    @BindView(R2.id.image_weixin)
    ImageView imageWeixin;
    private LoginPresenter loginPresenter;
    private String encode;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private WeiXinPresenter weiXinPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        loginPresenter = new LoginPresenter(new LoginPresen());
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(RegisterActivity.class);
            }
        });
        wjpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(ForgetActivity.class);
            }
        });
        imageWeixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // weiXinPresenter = new WeiXinPresenter();

                if (!WDApplication.getWXApi().isWXAppInstalled()) {
                    Toast.makeText(LoginActivity.this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
                    return;
                }
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                WDApplication.getWXApi().sendReq(req);
            }
        });
    }

    @Override
    protected void destoryData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.tv_login)
    public void onViewClicked() {
        String email = edEmail.getText().toString();
        String pwd = edPwd.getText().toString();
        sp = getSharedPreferences("login", MODE_PRIVATE);
        edit = sp.edit();
        edit.putString("pwd", pwd);
        edit.commit();
        String pwds = RsaCoder.encryptByPublicKey(pwd);
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pwds)) {
            Toast.makeText(LoginActivity.this, "你的输入为空", Toast.LENGTH_SHORT).show();
        }
        loginPresenter.reqeust(email, pwds);

    }

    private class LoginPresen implements DataCall<Login> {
        @Override
        public void success(Login data, Object... args) {
            Toast.makeText(LoginActivity.this, "登录成功!!", Toast.LENGTH_SHORT).show();
            edit.putString("nickName", data.nickName);
            edit.putString("email", data.email);
            edit.putString("headPic", data.headPic);
            edit.putInt("age", data.age);
            edit.putInt("height", data.height);
            edit.putInt("weight", data.weight);
            edit.putString("userName", data.userName);
            edit.putString("sessionId", data.sessionId);
            edit.putInt("Id", data.id);
            edit.commit();
            finish();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getWXlOGINcODE(BaseResp baseResp) {
        String code = ((SendAuth.Resp) baseResp).code;
        weiXinPresenter.reqeust(code);
    }
}
