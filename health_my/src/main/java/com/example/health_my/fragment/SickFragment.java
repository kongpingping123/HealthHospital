package com.example.health_my.fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.wd.common.core.WDFragment;

import butterknife.BindView;

public class SickFragment extends WDFragment {
    @BindView(R2.id.sick_rlv)
    RecyclerView sickRlv;

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

    }
}
