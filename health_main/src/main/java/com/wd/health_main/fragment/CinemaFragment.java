package com.wd.health_main.fragment;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.Banner;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.bean.ZixunBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.MyXiangqingadapter;
import com.wd.health_main.adapter.MyZixunadapter;
import com.wd.health_main.presenter.BannerPresenter;
import com.wd.health_main.presenter.XiangqingPresenter;
import com.wd.health_main.presenter.ZixunPresenter;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

@Route(path = Constant.ACTIVITY_URL_Cine)
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
    @BindView(R2.id.recy_view)
    RecyclerView recyView;
    @BindView(R2.id.recy_view1)
    RecyclerView recyView1;


    private BannerPresenter bannerPresenter;
    private ZixunPresenter zixunPresenter;
    private LinearLayoutManager linearLayoutManager;
    private MyZixunadapter myZixunadapter;
    private GridLayoutManager gridLayoutManager;
    private XiangqingPresenter xiangqingPresenter;
    private LinearLayoutManager linearLayoutManager1;
    private MyXiangqingadapter myXiangqingadapter;


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

        //健康详情
        xiangqingPresenter = new XiangqingPresenter(new jiankang());
        xiangqingPresenter.reqeust(1,1,5);
        //健康咨询
        zixunPresenter = new ZixunPresenter(new jiankangzixun());
        zixunPresenter.reqeust();
        //健康咨询
        gridLayoutManager = new GridLayoutManager(getContext(), 5);
        myZixunadapter = new MyZixunadapter(getContext());
        recyView.setLayoutManager(gridLayoutManager);
        recyView.setAdapter(myZixunadapter);
        myZixunadapter.setOnActu(new MyZixunadapter.OnActu() {
            @Override
            public void onActi(int Id) {
                xiangqingPresenter.reqeust(Id,1,5);
            }
        });


        //健康详情

        linearLayoutManager1 = new LinearLayoutManager(getContext());
        myXiangqingadapter = new MyXiangqingadapter(getContext());
       recyView1.setLayoutManager(linearLayoutManager1);
       recyView1.setAdapter(myXiangqingadapter);


     //常见病症

        showDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            intentByRouter(Constant.ACTIVITY_URL_Drugs);

            }
        });

        showDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentByRouter(Constant.ACTIVITY_URL_Drugs);
            }
        });
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


    //健康咨询

    class jiankangzixun implements DataCall<List<ZixunBean>> {

        @Override
        public void success(List<ZixunBean> data, Object... args) {
            Log.d("aaa", "success: " + data);
            myZixunadapter.AllAdd(data);
            myZixunadapter.notifyDataSetChanged();

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
    //健康详情

    class jiankang implements DataCall<List<XiangqingBase>> {

        @Override
        public void success(List<XiangqingBase> data, Object... args) {
            Log.d("aaa", "success: " + data);
            myXiangqingadapter.clear();
             myXiangqingadapter.AddAll(data);
             myXiangqingadapter.notifyDataSetChanged();

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
