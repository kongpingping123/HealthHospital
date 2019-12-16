package com.example.health_my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.encrypted.RsaCoder;
import com.example.health_my.presenter.EmailPreseter;
import com.example.health_my.presenter.RegisterPresenter;
import com.wd.common.bean.Register;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends WDActivity {


    @BindView(R2.id.login_iv)
    ImageView loginIv;
    @BindView(R2.id.re_email)
    EditText reEmail;
    @BindView(R2.id.re_verify)
    EditText reVerify;
    @BindView(R2.id.re_verif)
    TextView reVerif;
    @BindView(R2.id.re_pwd)
    EditText rePwd;
    @BindView(R2.id.re_pwd1)
    EditText rePwd1;
    @BindView(R2.id.re_yq)
    EditText reYq;
    @BindView(R2.id.re_register)
    Button reRegister;
    @BindView(R2.id.lv)
    LinearLayout lv;
    private EmailPreseter emailPreseter;
    private RegisterPresenter registerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

        //获取邮箱
        emailPreseter = new EmailPreseter(new EmailPrese());
        reVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = reEmail.getText().toString();
                if (email == null) {
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }
                emailPreseter.reqeust(email);
            }
        });
        //注册
        registerPresenter = new RegisterPresenter(new RegisterPresen());
        reRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = reEmail.getText().toString();
                String verify = reVerify.getText().toString();
                String pwd = rePwd.getText().toString();
                String pwd1 = rePwd1.getText().toString();
                String yq = reYq.getText().toString();
                String pwds = RsaCoder.encryptByPublicKey(pwd);
                String key = RsaCoder.encryptByPublicKey(pwd1);
                //   String pwdss = RsaCoder.encryptByPublicKey(pwd1);

                registerPresenter.reqeust(email,verify,pwds,key);
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

    private class EmailPrese implements DataCall<Result> {
        @Override
        public void success(Result data, Object... args) {
            Toast.makeText(RegisterActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    private class RegisterPresen implements DataCall<Register> {
        @Override
        public void success(Register data, Object... args) {
            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }
}
