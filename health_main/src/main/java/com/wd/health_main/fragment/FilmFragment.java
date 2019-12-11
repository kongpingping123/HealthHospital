package com.wd.health_main.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wd.common.bean.CircleBean;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.activity.DetailsActivity;
import com.wd.health_main.activity.SearchActivity;
import com.wd.health_main.adapter.CircleAdpater;
import com.wd.health_main.adapter.FindDepartmentAdapter;
import com.wd.health_main.presenter.FindDepartmentPresenter;
import com.wd.health_main.presenter.FindSickCircleListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FilmFragment extends WDFragment {
    @BindView(R2.id.rv_qu)
    RecyclerView rvQu;
    @BindView(R2.id.circle_img_search)
    ImageView circleImgSearch;
    @BindView(R2.id.rv_cir)
    RecyclerView rvCir;
    @BindView(R2.id.tv_shou)
    TextView tvShou;
    @BindView(R2.id.keshi)
    TextView keshi;
    private FindSickCircleListPresenter findSickCircleListPresenter;

    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_layout;
    }

    @Override
    protected void initView() {
        FindDepartmentPresenter findDepartmentPresenter = new FindDepartmentPresenter(new Depart());
        findDepartmentPresenter.reqeust();
        findSickCircleListPresenter = new FindSickCircleListPresenter(new Sick());
        findSickCircleListPresenter.reqeust(2, 1, 5);
    }

    @OnClick(R2.id.tv_shou)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), SearchActivity.class);
        getActivity().startActivity(intent);
    }


    private class Depart implements DataCall<List<DepartmentBean>> {
        @Override
        public void success(List<DepartmentBean> data, Object... args) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvQu.setLayoutManager(linearLayoutManager);
            final FindDepartmentAdapter wellreceived = new FindDepartmentAdapter(R.layout.depart_item, data);
            wellreceived.setWork(new FindDepartmentAdapter.Work() {
                @Override
                public void sad(int id, String name,int myposition) {
                    wellreceived.getIndex(myposition);
                    wellreceived.notifyDataSetChanged();
                    keshi.setText(name);
                    findSickCircleListPresenter.reqeust(id, 1, 5);
                }
            });
            rvQu.setAdapter(wellreceived);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class Sick implements DataCall<List<CircleBean>> {
        @Override
        public void success(final List<CircleBean> data, Object... args) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvCir.setLayoutManager(linearLayoutManager);
            CircleAdpater wellreceived = new CircleAdpater(R.layout.circle_item, data);
            rvCir.setAdapter(wellreceived);
            wellreceived.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                    int sickCircleId = data.get(position).getSickCircleId();
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("sickCircleId", sickCircleId);
                    getActivity().startActivity(intent);
                }
            });
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
