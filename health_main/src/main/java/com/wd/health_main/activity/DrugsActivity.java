package com.wd.health_main.activity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.MyPageradapter;
import com.wd.health_main.fragment.yaopinfragment.Bingzhengfragment;
import com.wd.health_main.fragment.yaopinfragment.Yaopinfragment;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = Constant.ACTIVITY_URL_Drugs)
public class DrugsActivity extends WDActivity {


    @BindView(R2.id.radio_group1)
    RadioGroup radioGroup1;
    @BindView(R2.id.view_pager1)
    ViewPager viewPager1;
        private ArrayList<Fragment> list = new ArrayList<>();
    private MyPageradapter myPageradapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_drugs;
    }

    @Override
    protected void initView() {
           list.add(new Bingzhengfragment());
        list.add(new Yaopinfragment());

        myPageradapter = new MyPageradapter(getSupportFragmentManager(),list);
        viewPager1.setAdapter(myPageradapter);


          radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

              @Override
              public void onCheckedChanged(RadioGroup group, int checkedId) {
                  radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                      @Override
                      public void onCheckedChanged(RadioGroup group, int checkedId) {


                          if (checkedId == R.id.ra01) {
                              viewPager1.setCurrentItem(0);

                          }else {
                              if (checkedId == R.id.ra02) {
                              viewPager1.setCurrentItem(1);

                              }
                          }
                      }
                  });
              }
          });
    }

    @Override
    protected void destoryData() {

    }


}
