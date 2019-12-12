package com.wd.health_main.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
     // private String body ="<div class=\\\"article undefined\\\"><p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">黄芪性甘，微温。</span></p><div id=\\\"container4AD\\\">\\r\\n            <div name=\\\"PAJK_AD\\\" data-ubtid=\\\"sect-recommendAd\\\" classname=\\\"detail-ad\\\" id=\\\"TT022\\\" data-ad-code=\\\"TT022\\\" data-need-login=\\\"{true}\\\" data-page-id=\\\"H5web_application_article_bannerdetail\\\">\\r\\n            </div>\\r\\n        </div>\\r\\n        <div data-ubtid=\\\"sect-inquiry\\\" id=\\\"container4Inquiry\\\">\\r\\n        </div>\\r\\n        <div data-ubtid=\\\"sect-shopping\\\" data-class=\\\"shop-has-text\\\" id=\\\"container4Shopping\\\">\\r\\n        </div> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">归经：归肺、脾、肝、肾经。</span></p> \\r\\n<div class=\\\"media-wrap image-wrap\\\"> \\r\\n <img id=\\\"920-1.jpg\\\" src=\\\"https://jkcdn.pajk.com.cn/image/T1g6hOB_W_1RCvBVdK.jpg?img=/tf,d_jpg,d_png/rs,w_500\\\"> \\r\\n</div> \\r\\n<p><span style=\\\"color:#222222\\\"><strong>功效：</strong>具有补气固表，利尿托毒，排脓，敛疮生肌之功效。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\"><strong>用途：</strong>用于气虚乏力，食少便溏，中气下陷，久泻脱肛，便血崩漏，表虚自汗，气虚水肿黄芪圆片，痈疽难溃，久溃不敛，血虚痿黄，内热消渴。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">这是传统医学对黄芪的解读。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">王医生也临床也会用到黄芪，常常会起到不错的效果。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">今天门诊，一位心衰患者说：王医生，喝了黄芪水，最近确实感觉好一些了！</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">我们在医院总能碰到心功能不全，心衰的患者。 西医治疗心衰的金三角倍他乐克，贝那普利，螺内酯都用了，也加了利尿剂。心率55次/分，血压120/70mmHg，也没有水肿。按照现代医学心衰的治疗生命体征目标，已经完全达标。可是，患者就是难受，就是憋气，气短， 而且心功能评价，患者并不是终末期心衰。</span></p> \\r\\n<div class=\\\"media-wrap image-wrap\\\"> \\r\\n <img id=\\\"920-2.jpg\\\" src=\\\"https://jkcdn.pajk.com.cn/image/T1bYVOB__T1RCvBVdK.jpg?img=/tf,d_jpg,d_png/rs,w_500\\\"> \\r\\n</div> \\r\\n<p><strong><span style=\\\"color:#222222\\\">那怎么办能呢？</span></strong></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">药已经达到极致了，再让出去买点沙库巴曲缬沙坦，最新的治疗心衰的药物，全球首个arni药物， 部分患者能够解决问题，部分患者还是整天难受。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">我们得给患者解决问题呀。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">王医生建议：黄芪泡水喝或熬水喝， 往往能有不错的收获，部分这样的患者，都能改善或减轻症状。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><strong><span style=\\\"color:#222222\\\">现代研究：</span></strong></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">药理研究表明,黄芪具有增强机体免疫功能，强心，协助降血压、血糖、利尿、抗衰老、抗疲劳、抗病毒、镇静等作用。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">大家看一看，无论中医的第一条补气，还是现代医学的强心，都是和心脏有直接相关的。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\\">您要说治疗心衰，虽然近年来有了长足的进步，但目前世界上无法根治，尤其对于有一些症状，就是没办法，医生干瞪眼，因为西药就这几类。这个时候我们发挥中医药的优势， 黄芪补气，利尿；这和心衰气虚，水肿的主要原因整好相对应。而药理也证明黄芪具有强心利尿作用不谋而合。</span></p> \\r\\n<p style=\\\"text-align:left;\\\"><span style=\\\"color:#222222\\";
    private WebSettings settings1;

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

                 webview.getSettings().setJavaScriptEnabled(true);
                 webview.setWebViewClient(new WebViewClient());

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
