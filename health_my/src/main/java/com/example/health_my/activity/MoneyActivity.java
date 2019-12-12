package com.example.health_my.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.MoneyAdpater;
import com.example.health_my.presenter.MoneyPresenter;
import com.example.health_my.presenter.MoneysPresenter;
import com.wd.common.bean.Money;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoneyActivity extends WDActivity {


    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.text_money)
    TextView textMoney;
    @BindView(R2.id.money_rel)
    RecyclerView moneyRel;
    private MoneyPresenter moneyPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private MoneysPresenter moneysPresenter;
    private MoneyAdpater moneyAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_money;
    }

    @Override
    protected void initView() {

        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        moneyPresenter = new MoneyPresenter(new MoneyPresen());
        moneyPresenter.reqeust(id, sessionId);
        moneysPresenter = new MoneysPresenter(new MoneysPresen());
        moneysPresenter.reqeust(id, sessionId, 1, 5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        moneyRel.setLayoutManager(layoutManager);
        moneyAdpater = new MoneyAdpater(MoneyActivity.this);
        moneyRel.setAdapter(moneyAdpater);
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

    private class MoneyPresen implements DataCall<Result> {

        double result;
        private DecimalFormat decimalFormat;
        private SharedPreferences.Editor edit;

        @Override
        public void success(Result data, Object... args) {
            edit = sp.edit();
            if (data.getStatus().equals("0000")) {
                decimalFormat = new DecimalFormat("######0.00");
                result = (double) data.getResult();
                textMoney.setText(decimalFormat.format(result));
                edit.putString("money", String.valueOf(result));
                edit.commit();
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class MoneysPresen implements DataCall<List<Money>> {
        @Override
        public void success(List<Money> data, Object... args) {

            moneyAdpater.addAll(data);

            moneyAdpater.notifyDataSetChanged();
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
