package com.example.health_my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.presenter.EmailPreseter;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetActivity extends WDActivity {


    @BindView(R2.id.re_email)
    EditText reEmail;
    @BindView(R2.id.re_verif)
    TextView reVerif;
    @BindView(R2.id.re_verify)
    EditText reVerify;
    @BindView(R2.id.text_next)
    Button textNext;
    @BindView(R2.id.jian)
    ImageView jian;
    private EmailPreseter emailPreseter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void initView() {
//获取邮箱
        emailPreseter = new EmailPreseter(new EmailPreses());
        reVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = reEmail.getText().toString();
                emailPreseter.reqeust(email);
            }
        });

        textNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(ForgetsActivity.class);
                finish();
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


    private class EmailPreses implements DataCall<Result> {
        @Override
        public void success(Result data, Object... args) {
            Toast.makeText(ForgetActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(ForgetActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
