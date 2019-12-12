package com.example.health_my.fragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.SickAdpater;
import com.example.health_my.presenter.SickPresenter;
import com.wd.common.bean.Collection;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;

import java.util.List;

import butterknife.BindView;

public class SickFragment extends WDFragment {
    @BindView(R2.id.sick_rlv)
    RecyclerView sickRlv;
    private SickPresenter sickPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private SickAdpater sickAdpater;

    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sick_fragment;
    }

    @Override
    protected void initView() {
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);
        sickPresenter = new SickPresenter(new SickPresen());
        sickPresenter.reqeust(id,sessionId,1,5);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        sickRlv.setLayoutManager(layoutManager);
        sickAdpater = new SickAdpater(getContext());
        sickRlv.setAdapter(sickAdpater);

    }

    private class SickPresen implements DataCall<List<Collection>> {
        @Override
        public void success(List<Collection> data, Object... args) {
            sickAdpater.addAll(data);

            sickAdpater.notifyDataSetChanged();
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
