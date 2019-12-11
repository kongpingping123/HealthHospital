package com.wd.health_main.activity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.MyPageradapter;
import com.wd.health_main.fragment.yaopinfragment.Bingzhengfragment;
import com.wd.health_main.fragment.yaopinfragment.Yaopinfragment;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = Constant.ACTIVITY_URL_Drugs)
public class DrugsActivity extends WDActivity {



    @BindView(R2.id.view_pager1)
    ViewPager viewPager1;
    @BindView(R2.id.table)
    TabLayout table;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> listtab = new ArrayList<>();
    private MyPageradapter myPageradapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_drugs;
    }

    @Override
    protected void initView() {
        list.add(new Bingzhengfragment());
        list.add(new Yaopinfragment());

               listtab.add("常见病症");
                listtab.add("常用药品");


                viewPager1.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {

                        return list.get(position);
                    }

                    @Override
                    public int getCount() {
                        return list.size();
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return listtab.get(position);
                    }
                });
                table.setupWithViewPager(viewPager1);


    }

    @Override
    protected void destoryData() {

    }


}
