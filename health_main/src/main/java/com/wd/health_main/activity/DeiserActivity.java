package com.wd.health_main.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
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
import butterknife.ButterKnife;
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
    @BindView(R2.id.webview)
    WebView webview;
    private DisePresenter disePresenter;
    private int id;
    private WebSettings settings;

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





        webview.loadUrl("http://172.17.8.100/health/share/information/v1/findInformation?infoId=1 ");

         
    }

    private String getUnicodeContent() {

        String content = getUnicodeContent() ;
        settings = webview.getSettings();
        webview.getSettings().setDefaultTextEncodingName("UTF-8");
        webview.loadData(content,"text/html","UTF-8");
        return content;
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

            //webview.loadUrl();





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
