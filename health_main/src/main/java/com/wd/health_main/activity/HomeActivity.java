package com.wd.health_main.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.MyPageradapter;
import com.wd.health_main.fragment.CinemaFragment;
import com.wd.health_main.fragment.FilmFragment;
import com.wd.health_main.fragment.MypageFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@Route(path = Constant.ACTIVITY_URL_Home)
public class HomeActivity extends WDActivity {


    @BindView(R2.id.vp)
    FrameLayout vp;
    @BindView(R2.id.rb_shou_wei)
    ImageView rbShouWei;
    @BindView(R2.id.rb_shou_xuan)
    ImageView rbShouXuan;
    @BindView(R2.id.home_lin)
    LinearLayout homeLin;
    @BindView(R2.id.rb_movie_wei)
    ImageView rbMovieWei;
    @BindView(R2.id.rb_movie_xuan)
    ImageView rbMovieXuan;
    @BindView(R2.id.movie_lin)
    LinearLayout movieLin;
    @BindView(R2.id.sick_circle_img)
    ImageView sickCircleImg;
    @BindView(R2.id.comments_img)
    ImageView commentsImg;
    @BindView(R2.id.sick_lin)
    LinearLayout sickLin;
    private ArrayList<Fragment> list = new ArrayList<>();
    private CinemaFragment cinemaFragment;
    private FilmFragment filmFragment;
    private MypageFragment mypageFragment;
    private long mExitTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;

    }

    @Override
    protected void initView() {
       /* getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }*/
        cinemaFragment = new CinemaFragment();
        filmFragment = new FilmFragment();
        mypageFragment = new MypageFragment();
        list.add(cinemaFragment);
        list.add(filmFragment);
        list.add(mypageFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.vp, cinemaFragment)
                .add(R.id.vp, filmFragment)
                .add(R.id.vp, mypageFragment)
                .show(cinemaFragment)
                .hide(filmFragment)
                .hide(mypageFragment)
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

    @OnClick({R2.id.home_lin, R2.id.movie_lin, R2.id.sick_lin,R2.id.comments_img})
    public void onViewClicked(View view) {

        int id = view.getId();
        if (id == R.id.home_lin) {
            rbShouXuan.setVisibility(View.VISIBLE);
            rbShouWei.setVisibility(View.GONE);
            rbMovieXuan.setVisibility(View.GONE);
            rbMovieWei.setVisibility(View.VISIBLE);
            commentsImg.setVisibility(View.GONE);
            sickCircleImg.setVisibility(View.VISIBLE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .show(cinemaFragment)
                    .hide(filmFragment)
                    .hide(mypageFragment)
                    .commit();
        } else if (id == R.id.movie_lin) {
            rbMovieWei.setVisibility(View.GONE);
            rbShouXuan.setVisibility(View.GONE);
            commentsImg.setVisibility(View.GONE);
            sickCircleImg.setVisibility(View.VISIBLE);
            rbShouWei.setVisibility(View.VISIBLE);
            rbMovieXuan.setVisibility(View.VISIBLE);
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(mypageFragment)
                    .hide(cinemaFragment)
                    .hide(filmFragment)
                    .commit();
        } else if (id == R.id.sick_lin) {
            sickCircleImg.setVisibility(View.GONE);
            rbMovieXuan.setVisibility(View.GONE);
            rbShouXuan.setVisibility(View.GONE);
            rbShouWei.setVisibility(View.VISIBLE);
            commentsImg.setVisibility(View.VISIBLE);
            rbMovieWei.setVisibility(View.VISIBLE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .show(filmFragment)
                    .hide(mypageFragment)
                    .hide(cinemaFragment)
                    .commit();

        } else if (id == R.id.comments_img) {
            intentByRouter(Constant.ACTIVITY_URL_WRITE);
        }
    }

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
