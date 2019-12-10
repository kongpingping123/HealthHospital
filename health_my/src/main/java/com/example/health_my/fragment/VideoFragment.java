package com.example.health_my.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.example.health_my.R2;
import com.example.health_my.adpater.TrailerFragmentAdapter;
import com.example.health_my.presenter.VideoPresenter;
import com.wd.common.bean.Video;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDFragment;
import com.wd.common.core.exception.ApiException;

import java.util.List;

import butterknife.BindView;

public class VideoFragment extends WDFragment {
    @BindView(R2.id.video_rlv)
    RecyclerView videoRlv;
    @BindView(R2.id.tlv_video)
    RelativeLayout tlvVideo;
    @BindView(R2.id.text_videos)
    RelativeLayout textVideos;
    private VideoPresenter videoPresenter;
    private SharedPreferences sp;
    private String sessionId;
    private int id;
    private TrailerFragmentAdapter adapter;

    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_fragment;
    }

    @Override
    protected void initView() {
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        id = sp.getInt("Id", 0);


        videoPresenter = new VideoPresenter(new VideoPresen());
        videoPresenter.reqeust(id, sessionId, 1, 5);

        adapter = new TrailerFragmentAdapter(getContext());
        videoRlv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        videoRlv.setLayoutManager(linearLayoutManager);

    }

    private class VideoPresen implements DataCall<List<Video>> {

        private String title;

        @Override
        public void success(List<Video> data, Object... args) {
            for (int i = 0; i < data.size(); i++) {
                title = data.get(i).title;
            }
            if (title != null) {
                tlvVideo.setVisibility(View.GONE);
                textVideos.setVisibility(View.VISIBLE);
                adapter.addAll(data);

                adapter.notifyDataSetChanged();
            }else if (title == null) {
                tlvVideo.setVisibility(View.VISIBLE);
                textVideos.setVisibility(View.GONE);
            }

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
