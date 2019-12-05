package com.wd.health_main.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;
import com.wd.health_main.R;


@Route(path = Constant.ACTIVITY_URL_MAIN)
public class MainActivity extends WDActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                  if (count<0){
                      intentByRouter(Constant.ACTIVITY_URL_Gui);
                      finish();
                  }else {
                      tv.setText(count+"S");
                      count--;
                      handler.sendEmptyMessageDelayed(99,1000);
                  }
        }
    };
    private RelativeLayout btn11;
    private TextView tv;
        private  int count =3;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btn11 = findViewById(R.id.btn11);
        tv = findViewById(R.id.tv);
        handler.sendEmptyMessageDelayed(99,1000);

      btn11.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              intentByRouter(Constant.ACTIVITY_URL_Gui);
              finish();
              handler.removeMessages(99);
          }
      });
    }

    @Override
    protected void destoryData() {

    }


}
