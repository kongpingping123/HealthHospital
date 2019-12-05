package com.wd.health_main.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;

import java.util.ArrayList;

@Route(path = Constant.ACTIVITY_URL_Gui)
public class GuidanceActivity extends WDActivity {


       private ViewPager pager;
       private Button button;
       private RadioGroup radioGroup;
       private boolean isButton = true;
       @Override
    protected int getLayoutId() {
        return R.layout.activity_guidance;
    }

    @Override
    protected void initView() {
               //   button.setVisibility(View.GONE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SharedPreferences sp = getSharedPreferences("ydy", Context.MODE_PRIVATE);
        if (sp.getBoolean("key",false)){

        }
        sp.edit().putBoolean("key",true).commit();

        pager = findViewById(R.id.pager);
        button = findViewById(R.id.button1);
       // button.setOnClickListener(this);
        button.setVisibility(View.GONE);
        radioGroup = findViewById(R.id.radioGroup1);
        int arr [] = {R.drawable.yindao1,R.drawable.yindao2,R.drawable.yindao3,R.drawable.yindao4,R.drawable.yindao5,};
        final ArrayList<ImageView> list = new ArrayList<ImageView>();
        RadioGroup.LayoutParams params =  new RadioGroup.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 10;
        for (int i = 0; i < arr.length; i++) {
            ImageView imageView = new ImageView(GuidanceActivity.this);
            imageView.setImageResource(arr[i]);
            list.add(imageView);
            RadioButton button = new RadioButton(GuidanceActivity.this);
            button.setButtonDrawable(R.drawable.indicator_selected);
            radioGroup.addView(button,params);
        }
        radioGroup.check(radioGroup.getChildAt(0).getId());
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = list.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);

            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
                if (position==list.size()-1){
                    button.setVisibility(View.VISIBLE);
                }else {
                    button.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentByRouter(Constant.ACTIVITY_URL_Home);
                //  button.setVisibility(View.VISIBLE);
            }
        });

    }






    @Override
    protected void destoryData() {

    }

}
