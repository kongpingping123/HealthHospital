package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.encrypted.RsaCoder;
import com.example.health_my.presenter.PlishPresenter;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetsActivity extends WDActivity {


    @BindView(R2.id.fg_pwd)
    EditText fgPwd;
    @BindView(R2.id.fg_pwds)
    EditText fgPwds;
    @BindView(R2.id.text_accomplish)
    Button textAccomplish;
    @BindView(R2.id.jian)
    ImageView jian;
    private SharedPreferences sp;
    private String pwd;
    private PlishPresenter plishPresenter;
    private String id;
    private String sessionId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgets;
    }

    @Override
    protected void initView() {

        plishPresenter = new PlishPresenter(new PlishPresen());
        sp = getSharedPreferences("login", MODE_PRIVATE);
        pwd = sp.getString("pwd", "");
        sessionId = sp.getString("sessionId", "");
        id = sp.getString("Id", "");
        textAccomplish.setOnClickListener(new View.OnClickListener() {

            private String key1;
            private String key;

            @Override
            public void onClick(View v) {
                String pwds = fgPwd.getText().toString();
                String pwdss = fgPwds.getText().toString();
                key1 = RsaCoder.encryptByPublicKey(pwd);
                key = RsaCoder.encryptByPublicKey(pwds);

                plishPresenter.reqeust(id, sessionId, key1, key);

            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

    private class PlishPresen implements DataCall<Result> {
        @Override
        public void success(Result data, Object... args) {
            Toast.makeText(ForgetsActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(ForgetsActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
        }
    }
}
