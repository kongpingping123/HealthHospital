package com.example.health_my.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.InformationAdapter;
import com.example.health_my.presenter.InFoPresenter;
import com.wd.common.bean.InFo;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;

import java.util.List;

import butterknife.BindView;

public class InForFragment extends WDFragment {

    @BindView(R2.id.info_rlv)
    RecyclerView infoRlv;
    @BindView(R2.id.info_rl)
    RelativeLayout infoRl;
    @BindView(R2.id.info_rls)
    RelativeLayout infoRls;
    private InFoPresenter inFoPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private InformationAdapter inFoAdpater;

    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.infor_fragment;
    }

    @Override
    protected void initView() {

        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);


        inFoPresenter = new InFoPresenter(new InFoPresen());
        inFoPresenter.reqeust(id, sessionId, 1, 5);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        infoRlv.setLayoutManager(layoutManager);
        inFoAdpater = new InformationAdapter(getContext());
        infoRlv.setAdapter(inFoAdpater);

    }

    private class InFoPresen implements DataCall<List<InFo>> {

        private String infoId;

        @Override
        public void success(List<InFo> data, Object... args) {

            for (int i = 0; i < data.size(); i++) {
                infoId = data.get(i).infoId;
            }
            if (infoId != null) {
                infoRl.setVisibility(View.GONE);
                infoRls.setVisibility(View.VISIBLE);
                inFoAdpater.addAll(data);

                inFoAdpater.notifyDataSetChanged();
            }else if (infoId == null) {
                infoRl.setVisibility(View.VISIBLE);
                infoRls.setVisibility(View.GONE);
            }

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
