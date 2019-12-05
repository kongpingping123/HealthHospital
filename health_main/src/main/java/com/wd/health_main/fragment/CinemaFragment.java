package com.wd.health_main.fragment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.wd.common.bean.Banner;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.presenter.BannerPresenter;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;


public class CinemaFragment extends WDFragment {

    @BindView(R2.id.show_banner)
    MZBannerView showBanner;
    @BindView(R2.id.show_disease)
    ImageView showDisease;
    @BindView(R2.id.changyoubingqing)
    TextView changyoubingqing;
    @BindView(R2.id.show_drugs)
    ImageView showDrugs;
    @BindView(R2.id.show_inner)
    ImageView showInner;
    @BindView(R2.id.show_eye)
    ImageView showEye;
    @BindView(R2.id.show_bone)
    ImageView showBone;
    @BindView(R2.id.show_little)
    ImageView showLittle;
    @BindView(R2.id.show_pass)
    ImageView showPass;
    @BindView(R2.id.show_skin)
    ImageView showSkin;
    @BindView(R2.id.show_ear)
    ImageView showEar;
    @BindView(R2.id.show_spirit)
    ImageView showSpirit;
    @BindView(R2.id.show_image)
    ImageView showImage;
    @BindView(R2.id.show_tab)
    TabLayout showTab;
    @BindView(R2.id.show_view)
    ViewPager showView;

    private BannerPresenter bannerPresenter;


    @Override
    public String getPageName() {
        return "首页fragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.cinema_layout;
    }

    @Override
    protected void initView() {
       // mzBannerView = getActivity().findViewById(R.id.show_banner);
        bannerPresenter = new BannerPresenter(new MyBanner());
        bannerPresenter.reqeust();
        // Fresco.initialize(getContext());

    }

    @Override
    public void onResume() {
        super.onResume();

    }




    class BannerViewHolder implements MZViewHolder<Banner> {
        private SimpleDraweeView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_layout, null);
            mImageView = view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Banner data) {
            // 数据绑定
            mImageView.setImageURI(Uri.parse(data.imageUrl));
        }
    }

    class MyBanner implements DataCall<List<Banner>> {


        @Override
        public void success(List<Banner> data, Object... args) {
            showBanner.setIndicatorVisible(false);
            showBanner.setPages(data, new MZHolderCreator<BannerViewHolder>() {
                @Override
                public BannerViewHolder createViewHolder() {
                    return new BannerViewHolder();
                }
            });
            showBanner.start();

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }


    }



}
