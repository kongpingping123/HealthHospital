package com.wd.health_main.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.common.bean.DetailsBean;
import com.wd.common.bean.Result;
import com.wd.common.bean.SickBean;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.health_main.R;
import com.wd.health_main.R2;
import com.wd.health_main.adapter.PopAdapter;
import com.wd.health_main.presenter.FindSickCircleCommentListPresenter;
import com.wd.health_main.presenter.FindSickCircleInfoPresenter;
import com.wd.health_main.presenter.PublishCommentPresenter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends WDActivity {


    @BindView(R2.id.circle_info_name)
    TextView circleInfoName;
    @BindView(R2.id.illness)
    TextView illness;
    @BindView(R2.id.circle_info_illness)
    TextView circleInfoIllness;
    @BindView(R2.id.department)
    TextView department;
    @BindView(R2.id.circle_info_department)
    TextView circleInfoDepartment;
    @BindView(R2.id.illInfo)
    TextView illInfo;
    @BindView(R2.id.circle_info_illInfo)
    TextView circleInfoIllInfo;
    @BindView(R2.id.experience)
    TextView experience;
    @BindView(R2.id.circle_info_experience_name)
    TextView circleInfoExperienceName;
    @BindView(R2.id.circle_info_experience_ftime)
    TextView circleInfoExperienceFtime;
    @BindView(R2.id.circle_info_experience_ltime)
    TextView circleInfoExperienceLtime;
    @BindView(R2.id.circle_info_experience_content)
    TextView circleInfoExperienceContent;
    @BindView(R2.id.picture)
    TextView picture;
    @BindView(R2.id.circle_info_experience_img)
    ImageView circleInfoExperienceImg;
    @BindView(R2.id.circle_info_hb)
    TextView circleInfoHb;
    @BindView(R2.id.circle_info_linear_one)
    LinearLayout circleInfoLinearOne;
    @BindView(R2.id.circle_info_collection_img)
    ImageView circleInfoCollectionImg;
    @BindView(R2.id.circle_info_collection_num)
    TextView circleInfoCollectionNum;
    @BindView(R2.id.circle_info_comment_num)
    TextView circleInfoCommentNum;
    @BindView(R2.id.circle_info_rl_one)
    RelativeLayout circleInfoRlOne;
    @BindView(R2.id.circle_info_linear_two)
    LinearLayout circleInfoLinearTwo;
    @BindView(R2.id.circle_info_advice_head)
    ImageView circleInfoAdviceHead;
    @BindView(R2.id.circle_info_advice_name)
    TextView circleInfoAdviceName;
    @BindView(R2.id.circle_info_advice_hb)
    TextView circleInfoAdviceHb;
    @BindView(R2.id.circle_info_advice_time)
    TextView circleInfoAdviceTime;
    @BindView(R2.id.circle_info_rl_two)
    RelativeLayout circleInfoRlTwo;
    @BindView(R2.id.circle_info_advice_content)
    TextView circleInfoAdviceContent;
    @BindView(R2.id.circle_info_rl_three)
    RelativeLayout circleInfoRlThree;
    @BindView(R2.id.image_ping)
    ImageView imagePing;
    private PopupWindow popupWindow;
    private int sickCircleId;
    private RecyclerView poprv;
    private PublishCommentPresenter publishCommentPresenter;
    private int sickCircleId1;
    private PopAdapter wellreceived;
    private EditText editText;
    private ImageView tv;
    private TextView textView;
    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private FindSickCircleCommentListPresenter findSickCircleCommentListPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int sickCircleId = intent.getIntExtra("sickCircleId", 0);
        FindSickCircleInfoPresenter findSickCircleInfoPresenter = new FindSickCircleInfoPresenter(new Circle());
        findSickCircleInfoPresenter.reqeust(sickCircleId);
        //评论
        publishCommentPresenter = new PublishCommentPresenter(new Push());
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

    @OnClick(R2.id.image_ping)
    public void onViewClicked() {
        showPopupWindow();
        findSickCircleCommentListPresenter = new FindSickCircleCommentListPresenter(new Sickcitcle());
        findSickCircleCommentListPresenter.reqeust(sickCircleId,1,5);
    }

    private void showPopupWindow() {
        //找到pop弹窗布局
        View view = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.pop_item, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //返回键可退
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.setContentView(view);
        imageView = view.findViewById(R.id.image_pop);
        poprv = view.findViewById(R.id.rv_pop);
        tv = view.findViewById(R.id.pop_tv);
        textView = view.findViewById(R.id.pop_liuxia);
        relativeLayout = view.findViewById(R.id.pop_rel);
        editText = view.findViewById(R.id.pop_et);
        ImageView send = view.findViewById(R.id.pop_send);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //点击显示隐藏
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    InputMethodManager m = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }, 300);
                imageView.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                tv.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
            }
        });
        //点击发送评论
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString().trim();
                //发送评论

                publishCommentPresenter.reqeust("418","1575890666852418",sickCircleId1,content);
            }
        });
        //activity的布局
        View rootView = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.activity_details, null);
        //位置
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //popupWindow消失屏幕变为不透明
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
        //popupWindow出现屏幕变为半透明
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        popupWindow.update();
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);

    }

    private class Circle implements DataCall<DetailsBean> {
        @Override
        public void success(DetailsBean data, Object... args) {
            sickCircleId = data.sickCircleId;
            circleInfoIllness.setText(data.disease);
            circleInfoDepartment.setText(data.department);
            //病症详情
            circleInfoIllInfo.setText(data.detail);
            circleInfoExperienceName.setText(data.treatmentHospital);
            circleInfoExperienceContent.setText(data.treatmentProcess);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format1 = format.format(data.treatmentStartTime);
            circleInfoExperienceFtime.setText(format1 + "");
            SimpleDateFormat forma = new SimpleDateFormat("HH:mm");
            String forma1 = forma.format(data.treatmentEndTime);
            circleInfoExperienceLtime.setText("-" + forma1 + "");
            String imageUrl = data.picture;
            Glide.with(DetailsActivity.this).load(imageUrl).into(circleInfoExperienceImg);
            circleInfoCollectionNum.setText(data.collectionNum + "");
            circleInfoCommentNum.setText(data.commentNum + "");
            Glide.with(DetailsActivity.this).load(data.adoptHeadPic).into(circleInfoAdviceHead);
            circleInfoAdviceName.setText(data.adoptNickName);
            circleInfoAdviceContent.setText(data.adoptComment);
            sickCircleId1 = data.sickCircleId;

        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class Sickcitcle implements DataCall <List<SickBean>>{


        @Override
        public void success(List<SickBean> data, Object... args) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DetailsActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            linearLayoutManager.setReverseLayout(true);//布局反向
            linearLayoutManager.setStackFromEnd(true);//数据反向
            poprv.setLayoutManager(linearLayoutManager);
            wellreceived = new PopAdapter(R.layout.pop_rv_item, data);
            poprv.setAdapter(wellreceived);
            //显示底部
            poprv.scrollToPosition(wellreceived.getItemCount()-1);
            wellreceived.setCallBack(new PopAdapter.CallBack() {
                @Override
                public void sad(String image, String name,int commentId) {
                    Intent intent = new Intent(DetailsActivity.this,PatientActivity.class);;
                    intent.putExtra("image",image);
                    intent.putExtra("name",name);
                    intent.putExtra("commentId",commentId);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class Push implements DataCall<Result>{

        @Override
        public void success(Result data, Object... args) {
            if (data.getStatus().equals("0000")){
                findSickCircleCommentListPresenter.reqeust(sickCircleId,1,5);
                editText.setText("");
                Toast.makeText(DetailsActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
                wellreceived.notifyDataSetChanged();
            }else  if (data.getStatus().equals("9999")){
                editText.setText("");
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.GONE);
                Toast.makeText(DetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }
}
