package com.wd.health_main.fragment.yaopinfragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.bean.BingBase;
import com.wd.common.bean.DiseBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.activity.CommonActivity;
import com.wd.health_main.adapter.MyZixunadapter;
import com.wd.health_main.adapter.Mybingadapter;
import com.wd.health_main.adapter.Mydiseaseadapter;
import com.wd.health_main.presenter.BingPresenter;
import com.wd.health_main.presenter.BingzhengPresenter;

import org.greenrobot.greendao.annotation.Id;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
@Route(path = Constant.ACTIVITY_URL_Bing)
public class Bingzhengfragment extends WDFragment {

    @BindView(R2.id.recy_view2)
    RecyclerView recyView2;
    @BindView(R2.id.recy_view3)
    RecyclerView recyView3;
    private BingzhengPresenter bingzhengPresenter;
    private LinearLayoutManager linearLayoutManager;
    private Mydiseaseadapter mydiseaseadapter;
    private BingPresenter bingPresenter;
    private GridLayoutManager gridLayoutManager;
    private Mybingadapter mybingadapter;
    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.bingzheng_layout;


    }

    @Override
    protected void initView() {
        bingzhengPresenter = new BingzhengPresenter(new bing());
        bingzhengPresenter.reqeust();

        //常见病症

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyView2.setLayoutManager(linearLayoutManager);

        mydiseaseadapter = new Mydiseaseadapter(getContext());
         recyView2.setAdapter(mydiseaseadapter);

        bingPresenter = new BingPresenter(new bv());
        bingPresenter.reqeust(2);

        gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyView3.setLayoutManager(gridLayoutManager);
        mybingadapter = new Mybingadapter(getContext());
        recyView3.setAdapter(mybingadapter);
        mybingadapter.setJing(new Mybingadapter.Jing() {

            private SharedPreferences.Editor edit;
            private SharedPreferences sp;

            @Override
            public void gg(int id, String name) {
                 intentByRouter(Constant.ACTIVITY_URL_Com);
                sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
                edit = sp.edit();
                edit.putInt("Id",id);
                edit.putString("Name",name);
                edit.commit();
            }
        });
        mydiseaseadapter.setOnActu(new Mydiseaseadapter.OnActu() {
            @Override
            public void onActi(int Id) {
                bingPresenter.reqeust(Id);
            }
        });

    }

    class bing implements DataCall<List<DiseBase>> {

        @Override
        public void success(List<DiseBase> data, Object... args) {
            Log.d("aaa", "success: " + data);
           // data.clear();
            //mydiseaseadapter.clear();
        mydiseaseadapter.AddAll(data);
        mydiseaseadapter.notifyDataSetChanged();

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }

    }

      class bv implements DataCall<List<BingBase>> {

          @Override
          public void success(final List<BingBase> data, Object... args) {
              Log.d("aaa1", "success: " + data);
              mybingadapter.clear();
              mybingadapter.AddAll(data);
              mybingadapter.notifyDataSetChanged();
          }


          @Override
          public void fail(ApiException data, Object... args) {

          }
      }
}
