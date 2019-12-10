package com.wd.health_main.fragment.yaopinfragment;

import android.content.Intent;
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
    private int id1;
    private String name1;
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
      mybingadapter.setWork(new Mybingadapter.Work() {
          @Override
          public void sad() {

              intentByRouter(Constant.ACTIVITY_URL_Com);

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

      class bv implements DataCall<List<BingBase>>{

          @Override
          public void success(final List<BingBase> data, Object... args) {
              Log.d("aaa1", "success: "+data);
             mybingadapter.clear();
                mybingadapter.AddAll(data);
                mybingadapter.notifyDataSetChanged();
              mybingadapter.setJing(new Mybingadapter.Jing() {



                  @Override
                  public void gg(int id, String name) {
                      for (int i = 0; i <data.size() ; i++) {
                          id1 = data.get(id).getId();
                          name1 = data.get(i).getName();
                      }
                      Intent intent =  new Intent(getActivity(), CommonActivity.class);
                      intent.putExtra("id",id1);
                      intent.putExtra("i",name1);
                      startActivity(intent);

                  }
              });
                  }


          @Override
          public void fail(ApiException data, Object... args) {

          }
      }
}
