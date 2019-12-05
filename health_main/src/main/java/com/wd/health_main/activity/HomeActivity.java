package com.wd.health_main.activity;

import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.adapter.MyPageradapter;
import com.wd.health_main.fragment.CinemaFragment;
import com.wd.health_main.fragment.FilmFragment;
import com.wd.health_main.fragment.MypageFragment;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


@Route(path = Constant.ACTIVITY_URL_Home)
public class HomeActivity extends WDActivity {


    private RadioGroup radioGroup;
    private ViewPager viewPager;
   private ArrayList<Fragment> list = new ArrayList<>();
    private MyPageradapter myPageradapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;

    }

    @Override
    protected void initView() {
        radioGroup = findViewById(R.id.radio_group);
        viewPager = findViewById(R.id.view_pager);

        list.add(new CinemaFragment());
        list.add(new FilmFragment());
        list.add(new MypageFragment());

        myPageradapter = new MyPageradapter(getSupportFragmentManager(),list);
         viewPager.setAdapter(myPageradapter);

         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 if (checkedId == R.id.rb1) {
                  viewPager.setCurrentItem(0);
                 }else {
                     if (checkedId == R.id.rb2) {
                         viewPager.setCurrentItem(1);
                     }else {
                         if (checkedId == R.id.rb3) {
                             viewPager.setCurrentItem(3);
                         }
                     }
                 }
             }
         });

    }
    @Override
    protected void destoryData() {

    }
}
