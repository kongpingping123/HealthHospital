package com.wd.health_main.activity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.wd.common.bean.DtonBase;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.presenter.DisePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class DeiserActivity extends WDActivity {

    /*@BindView(R2.id.jing1)
    TextView jing1;
    @BindView(R2.id.jing2)
    TextView jing2;
    @BindView(R2.id.simple_view)
    SimpleDraweeView simpleView;
    @BindView(R2.id.jing3)
    TextView jing3;*/
    @BindView(R2.id.imager3)
    ImageView imager3;

    private DisePresenter disePresenter;
    private int id;

    @Override
    protected int getLayoutId() {

        return R.layout.dijing_layout;
    }

    @Override
    protected void initView() {
        disePresenter = new DisePresenter(new dijing());
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        disePresenter.reqeust(id);

       WebView wv =  findViewById(R.id.webview);




    }


    @Override
    protected void destoryData() {

    }




    @OnClick(R2.id.imager3)
    public void onClick() {
        finish();

    }




    class dijing implements DataCall<DtonBase> {

        private Uri parse;

        @Override
        public void success(DtonBase data, Object... args) {

            Log.d("aaa", "success: " + data);




            /* jing1.setText(data.source);
             *//*parse = Uri.parse(data.whetherCollection);
            simpleView.setImageURI(parse);*//*
            jing2.setText(data.title);
            jing3.setText(data.whetherCollection);*/

        }



        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
