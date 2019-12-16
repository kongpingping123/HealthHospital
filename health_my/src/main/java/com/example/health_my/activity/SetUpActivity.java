package com.example.health_my.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.wd.common.core.WDActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetUpActivity extends WDActivity {


    @BindView(R2.id.set_up_activity_btn_quit_landing)
    Button setUpActivityBtnQuitLanding;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {

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

    @OnClick(R2.id.set_up_activity_btn_quit_landing)
    public void onViewClicked() {
        SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
        if(sp!=null){
            sp.edit().clear().commit();
            Toast.makeText(SetUpActivity.this, "退出登录成功", Toast.LENGTH_LONG).show();
        }
        Intent logoutIntent = new Intent(SetUpActivity.this, MyActivity.class);
        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logoutIntent);


    }
}
