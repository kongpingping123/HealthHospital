package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.presenter.SignPresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@Route(path = Constant.ACTIVITY_URL_MY_LOGIN)
public class MyActivity extends WDActivity {


    @BindView(R2.id.iv_touxiang)
    SimpleDraweeView ivTouxiang;
    @BindView(R2.id.username)
    TextView username;
    @BindView(R2.id.text_sign)
    TextView textSign;
    @BindView(R2.id.text_File)
    LinearLayout textFile;
    @BindView(R2.id.ll_Vienna)
    LinearLayout llVienna;
    @BindView(R2.id.ll_Viennas)
    LinearLayout llViennas;
    @BindView(R2.id.my_money)
    LinearLayout myMoney;
    @BindView(R2.id.my_collection)
    LinearLayout myCollection;
    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.caifang)
    ImageView caifang;
    @BindView(R2.id.text_setup)
    LinearLayout textSetup;
    @BindView(R2.id.text_follow)
    LinearLayout textFollow;
    private SharedPreferences sp;
    private String headPic;
    private String userName;
    private SignPresenter signPresenter;
    private String sessionId;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my;
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        headPic = sp.getString("headPic", "");
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        userName = sp.getString("userName", "");

        Uri uri = Uri.parse(headPic);
        ivTouxiang.setImageURI(uri);

        username.setText(userName);

        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentByRouter(Constant.ACTIVITY_URL_Cine);
            }
        });
        textSign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signPresenter = new SignPresenter(new SignPresen());
                signPresenter.reqeust(id, sessionId);
            }
        });

        textFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(FileActivity.class);
            }
        });

        llVienna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(ViennaActivity.class);
            }
        });

        llViennas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(HistoryActivity.class);
            }
        });

        myMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(MoneyActivity.class);
            }
        });

        myCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(CollectionActivity.class);
            }
        });
        caifang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(InterviewActivity.class);
            }
        });
        textSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(SetUpActivity.class);
            }
        });
        textFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(FollowActivity.class);
            }
        });
    }

    @Override
    protected void destoryData() {

    }

    @OnClick(R2.id.iv_touxiang)
    public void onViewClicked() {
        intent(LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class SignPresen implements DataCall<Result> {
        @Override
        public void success(Result data, Object... args) {
            Toast.makeText(MyActivity.this, "签到成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(MyActivity.this, "今天已签到", Toast.LENGTH_SHORT).show();
        }
    }
}
