package com.wd.health_main.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.bean.Popular;
import com.wd.common.bean.Seach;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.ListAdpater;
import com.wd.health_main.fragment.yaopinfragment.HistryFlowView;
import com.wd.health_main.presenter.PopularPresenter;
import com.wd.health_main.presenter.SeachPresenter;
import com.wd.health_main.viewpager.Help;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SousuoActivity extends WDActivity {

    @BindView(R2.id.seach_back_img)
    ImageView seachBackImg;
    @BindView(R2.id.seach_edit)
    EditText seachEdit;
    @BindView(R2.id.seach_seach)
    TextView seachSeach;
    @BindView(R2.id.seach_histry)
    TextView seachHistry;

    @BindView(R2.id.text_lv)
    ListView text_lv;
    @BindView(R2.id.seach_popular)
    TextView seachPopular;
    @BindView(R2.id.seach_flow)
    HistryFlowView seachFlow;
    @BindView(R2.id.line)
    LinearLayout line;
    @BindView(R2.id.seach_doctor)
    TextView seachDoctor;
    @BindView(R2.id.recycler_doctor)
    RecyclerView recyclerDoctor;
    @BindView(R2.id.seach_diease)
    TextView seachDiease;
    @BindView(R2.id.recycler_disease)
    RecyclerView recyclerDisease;
    @BindView(R2.id.seach_drugs)
    TextView seachDrugs;
    @BindView(R2.id.recycler_drugs)
    RecyclerView recyclerDrugs;
    @BindView(R2.id.line1)
    LinearLayout line1;
    @BindView(R2.id.seach_no_message)
    TextView seachNoMessage;
    @BindView(R2.id.line2)
    LinearLayout line2;
    private PopularPresenter popularPresenter;
    private SeachPresenter seachPresenter;
    private String edit;
    private List<String> searchHistory;
    private ListAdpater listAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.sousuo_layout;
    }

    @Override
    protected void initView() {


        seachSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = seachEdit.getText().toString();
                Help.saveSearchHistory(edit);
                seachPresenter = new SeachPresenter(new SeachPresen());
                seachPresenter.reqeust(edit);
            }
        });
        searchHistory = Help.getSearchHistory();
        listAdpater = new ListAdpater();
        text_lv.setAdapter(listAdpater);
        listAdpater.addAll(searchHistory);
        listAdpater.notifyDataSetChanged();
        popularPresenter = new PopularPresenter(new PopilarPresen());
        popularPresenter.reqeust();

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

    private class PopilarPresen implements DataCall<List<Popular>> {
        @Override
        public void success(List<Popular> data, Object... args) {
            int group = data.size();
            for (int i = 0; i < group; i++) {
                seachFlow.addTag(data.get(i).name);
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class SeachPresen implements DataCall<Seach> {
        @Override
        public void success(Seach data, Object... args) {

        }

        @Override
        public void fail(ApiException data, Object... args) {
            Toast.makeText(SousuoActivity.this, "关键词不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}





