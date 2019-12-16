package com.wd.health_main.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.Banner;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.XiangqingBase;
import com.wd.common.bean.ZixunBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.activity.DeiserActivity;
import com.wd.health_main.activity.GengduoActivity;
import com.wd.health_main.activity.SousuoActivity;
import com.wd.health_main.adapter.DepartmentAdapter;
import com.wd.health_main.adapter.InformationAdapter;
import com.wd.health_main.adapter.MyXiangqingadapter;
import com.wd.health_main.adapter.MyZixunadapter;
import com.wd.health_main.presenter.BannerPresenter;
import com.wd.health_main.presenter.FindDepartmentPresenter;
import com.wd.health_main.presenter.XiangqingPresenter;
import com.wd.health_main.presenter.ZixunPresenter;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R2.id.show_image)
    ImageView showImage;
    @BindView(R2.id.recy_view)
    RecyclerView recyView;
    @BindView(R2.id.recy_view1)
    RecyclerView recyView1;
    @BindView(R2.id.rv_cinema)
    RecyclerView rvCinema;


    @BindView(R2.id.sousuo)
    TextView sousuo;
    @BindView(R2.id.text_login)
    ImageView textLogin;
    @BindView(R2.id.gengduo)
    TextView gengduo;
    private int id1;
    private int int2;
    private int ido;
    private BannerPresenter bannerPresenter;
    private ZixunPresenter zixunPresenter;
    private LinearLayoutManager linearLayoutManager;
    private MyZixunadapter myZixunadapter;
    private GridLayoutManager gridLayoutManager;
    private XiangqingPresenter xiangqingPresenter;

    private MyXiangqingadapter myXiangqingadapter;
    private InformationAdapter informationAdapter;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private SharedPreferences.Editor id;
    private SharedPreferences.Editor name;

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

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentByRouter(Constant.ACTIVITY_URL_MY_LOGIN);
            }
        });

         gengduo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 intent(GengduoActivity.class);
             }
         });
        //问诊
        FindDepartmentPresenter findDepartmentPresenter = new FindDepartmentPresenter(new FDepart());
        findDepartmentPresenter.reqeust();

        // mzBannerView = getActivity().findViewById(R.id.show_banner);
        bannerPresenter = new BannerPresenter(new MyBanner());
        bannerPresenter.reqeust();
        // Fresco.initialize(getContext());

        //健康详情
        xiangqingPresenter = new XiangqingPresenter(new jiankang());
        xiangqingPresenter.reqeust(1, 1, 5);
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
            public void onActi(int Id,String name) {
                xiangqingPresenter.reqeust(Id, 1, 5);
                sp = getActivity().getSharedPreferences("xiang",Context.MODE_PRIVATE);
                edit = sp.edit();
                id = edit.putInt("Id", Id);
                CinemaFragment.this.name = edit.putString("Name", "");
                edit.commit();
            }
        });


        //健康详情

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyView1.setLayoutManager(linearLayoutManager);


        informationAdapter = new InformationAdapter(getContext());
        recyView1.setAdapter(informationAdapter);
        /*linearLayoutManager1 = new LinearLayoutManager(getContext());
        myXiangqingadapter = new MyXiangqingadapter(getContext(), MyXiangqingadapter.HOT_TYPE);*/
        // myXiangqingadapter = new MyXiangqingadapter(getContext(),MyXiangqingadapter.FASHION_TYPE);

/*

        recyView1.setLayoutManager(linearLayoutManager1);
        recyView1.setAdapter(myXiangqingadapter);
*/
//        linearLayoutManager1 = new LinearLayoutManager(getContext());
//        myXiangqingadapter = new MyXiangqingadapter(getContext());
//        recyView1.setLayoutManager(linearLayoutManager1);
//           recyView1.setAdapter(myXiangqingadapter);


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

                 /* Intent intent = new Intent(getContext(), Yaopinfragment.class);
                  startActivity(intent);*/

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @OnClick(R2.id.sousuo)
    public void onClick() {
        Intent intent = new Intent(getContext(), SousuoActivity.class);
        startActivity(intent);

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
        public void success(final List<XiangqingBase> data, Object... args) {
            Log.d("aaa", "success: " + data);
            informationAdapter.clear();
            informationAdapter.addAll(data);

            informationAdapter.notifyDataSetChanged();



       /*    informationAdapter.setOnItemClickListener(new InformationAdapter.OnItemClickListener() {



                 @Override
                 public void onClick(int position) {
                     for (int i = 0; i < data.size(); i++) {
                         int2 = data.get(position).getId();

                     }
                     Intent intent = new Intent(getContext(), DeiserActivity.class);
                     intent.putExtra("id", int2);
                     startActivity(intent);
                 }
             });*/

           /* myXiangqingadapter.clear();
            myXiangqingadapter.AddAll(data);
            myXiangqingadapter.notifyDataSetChanged();
            myXiangqingadapter.clear();
            myXiangqingadapter.AddAll(data);
            myXiangqingadapter.notifyDataSetChanged();

            myXiangqingadapter.setJing(new MyXiangqingadapter.Jing() {


                @Override
                public void gg(int id) {
                    for (int i = 0; i < data.size(); i++) {
                        id1 = data.get(id).getId();
                    }
                    Intent intent = new Intent(getContext(), DeiserActivity.class);
                    intent.putExtra("id", id1);
                    startActivity(intent);

                }
            });*/

            informationAdapter.setJing(new InformationAdapter.Jing() {


                @Override
                public void gg(int id) {
                    for (int i = 0; i < data.size(); i++) {
                        ido = data.get(id).getId();

                    }
                    Intent intent = new Intent(getContext(), DeiserActivity.class);
                    intent.putExtra("id", ido);
                    startActivity(intent);
                }
            });

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class FDepart implements DataCall<List<DepartmentBean>> {
        @Override
        public void success(List<DepartmentBean> data, Object... args) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            rvCinema.setLayoutManager(gridLayoutManager);
            DepartmentAdapter wellreceived = new DepartmentAdapter(R.layout.layout_inquiry, data);
            wellreceived.setWork(new DepartmentAdapter.Work() {
                @Override
                public void sad(int id, String name) {
                    intentByRouter(Constant.ACTIVITY_URL_INQUIRY);
                }
            });
            rvCinema.setAdapter(wellreceived);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
