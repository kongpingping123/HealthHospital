package com.wd.health_main.fragment.yaopinfragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.bean.DrugBase;
import com.wd.common.bean.YaoBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.activity.InsertActivity;
import com.wd.health_main.adapter.MyDrougadapter;
import com.wd.health_main.adapter.MyYaoadapter;
import com.wd.health_main.adapter.MyZixunadapter;
import com.wd.health_main.presenter.DrugPresenter;
import com.wd.health_main.presenter.YaoPresenter;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
 @Route(path = Constant.ACTIVITY_URL_Yao)
public class Yaopinfragment extends WDFragment {

    @BindView(R2.id.recy_view4)
    RecyclerView recyView4;
    @BindView(R2.id.recy_view5)
    RecyclerView recyView5;
    private DrugPresenter drugPresenter;
    private LinearLayoutManager linearLayoutManager;
    private MyDrougadapter myDrougadapter;
    private YaoPresenter yaoPresenter;
    private GridLayoutManager gridLayoutManager;
    private MyYaoadapter myYaoadapter;
     private int id1;
     private SharedPreferences sp;
     private SharedPreferences.Editor edit;

     @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.yaopin_layout;
    }

    @Override
    protected void initView() {

        drugPresenter = new DrugPresenter(new drow());
        drugPresenter.reqeust();

        linearLayoutManager = new LinearLayoutManager(getContext());
        myDrougadapter = new MyDrougadapter(getContext());
        myDrougadapter.setOnActu(new MyDrougadapter.OnActu() {
            @Override
            public void onActi(int Id) {
                yaoPresenter.reqeust(Id,1,5);
            }
        });
        recyView4.setLayoutManager(linearLayoutManager);
        recyView4.setAdapter(myDrougadapter);


        yaoPresenter = new YaoPresenter(new yao());
        yaoPresenter.reqeust(1,1,5);

        gridLayoutManager = new GridLayoutManager(getContext(),3);
        myYaoadapter = new MyYaoadapter(getContext());
        myYaoadapter.setJing(new MyYaoadapter.Jing() {
            @Override
            public void gg(int id, String name) {
                intentByRouter(Constant.ACTIVITY_URL_Coms);
                sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
                edit = sp.edit();
                edit.putInt("Ids",id);
                edit.putString("Names",name);
                edit.commit();
            }
        });
        recyView5.setLayoutManager(gridLayoutManager);
        recyView5.setAdapter(myYaoadapter);


    }


    class drow implements DataCall<List<DrugBase>> {

        @Override
        public void success(List<DrugBase> data, Object... args) {
            Log.d("aaa", "success: " + data);

            myDrougadapter.AllAdd(data);
            myDrougadapter.notifyDataSetChanged();
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    class yao implements DataCall<List<YaoBase>>{

        @Override
        public void success(final List<YaoBase> data, Object... args) {
            Log.d("aaa", "success: "+data);
            myYaoadapter.clear();
            myYaoadapter.AddAll(data);
            myYaoadapter.notifyDataSetChanged();
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
