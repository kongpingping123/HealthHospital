package com.example.health_my.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.fragment.InForFragment;
import com.example.health_my.fragment.SickFragment;
import com.example.health_my.fragment.VideoFragment;
import com.wd.common.core.WDActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionActivity extends WDActivity {


    @BindView(R2.id.jian)
    ImageView jian;
    @BindView(R2.id.coll_zx)
    RadioButton collZx;
    @BindView(R2.id.coll_sp)
    RadioButton collSp;
    @BindView(R2.id.coll_by)
    RadioButton collBy;
    @BindView(R2.id.fragment)
    FrameLayout fragment;
    private InForFragment inForFragment;
    private VideoFragment videoFragment;
    private SickFragment sickFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initView() {
        inForFragment = new InForFragment();
        videoFragment = new VideoFragment();
        sickFragment = new SickFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, inForFragment)
                .add(R.id.fragment, videoFragment)
                .add(R.id.fragment, sickFragment)
                .show(inForFragment)
                .hide(videoFragment)
                .hide(sickFragment)
                .commit();
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

    @OnClick({R2.id.coll_zx, R2.id.coll_sp, R2.id.coll_by})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.coll_zx) {
            collZx.setTextColor(Color.BLUE);
            collBy.setTextColor(Color.GRAY);
            collSp.setTextColor(Color.GRAY);
            getSupportFragmentManager().beginTransaction()
                    .show(inForFragment)
                    .hide(videoFragment)
                    .hide(sickFragment)
                    .commit();
        } else if (id == R.id.coll_sp) {
            collSp.setTextColor(Color.BLUE);
            collBy.setTextColor(Color.GRAY);
            collZx.setTextColor(Color.GRAY);
            getSupportFragmentManager().beginTransaction()
                    .show(videoFragment)
                    .hide(inForFragment)
                    .hide(sickFragment)
                    .commit();
        } else if (id == R.id.coll_by) {
            collBy.setTextColor(Color.BLUE);
            collZx.setTextColor(Color.GRAY);
            collSp.setTextColor(Color.GRAY);
            getSupportFragmentManager().beginTransaction()
                    .show(sickFragment)
                    .hide(inForFragment)
                    .hide(videoFragment)
                    .commit();
        }
    }
}
