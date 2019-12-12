package com.wd.health_patient;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.health_my.activity.MoneyActivity;
import com.example.health_my.presenter.MoneyPresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.DepartmentBean;
import com.wd.common.bean.DoctorBean;
import com.wd.common.bean.Result;
import com.wd.common.core.DataCall;
import com.wd.common.core.WDActivity;
import com.wd.common.core.exception.ApiException;
import com.wd.common.util.Constant;
import com.wd.health_main.adapter.FindDepartmentAdapter;
import com.wd.health_main.presenter.FindDepartmentPresenter;
import com.wd.health_patient.adapter.InquiryAdapter;
import com.wd.health_patient.presenter.FindDoctorListPresenter;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wd.common.core.WDApplication.getContext;

@Route(path = Constant.ACTIVITY_URL_INQUIRY)
public class InquiryActivity extends WDActivity {


    @BindView(R2.id.inquiry_rv)
    RecyclerView inquiryRv;
    @BindView(R2.id.tv_zh)
    TextView tvZh;
    @BindView(R2.id.tv_hp)
    TextView tvHp;
    @BindView(R2.id.tv_zxs)
    TextView tvZxs;
    @BindView(R2.id.tv_price)
    TextView tvPrice;
    @BindView(R2.id.sdv_pic)
    SimpleDraweeView sdvPic;
    @BindView(R2.id.tv_name)
    TextView tvName;
    @BindView(R2.id.tv_jobTitle)
    TextView tvJobTitle;
    @BindView(R2.id.tv_inauguralHospital)
    TextView tvInauguralHospital;
    @BindView(R2.id.tv_praiseNum)
    TextView tvPraiseNum;
    @BindView(R2.id.tv_serverNum)
    TextView tvServerNum;
    @BindView(R2.id.tv_servicePrice)
    TextView tvServicePrice;
    @BindView(R2.id.tv_ask)
    TextView tvAsk;
    @BindView(R2.id.sdv_left)
    SimpleDraweeView sdvLeft;
    @BindView(R2.id.sdv_right)
    SimpleDraweeView sdvRight;
    @BindView(R2.id.rv_doctor)
    RecyclerView rvDoctor;
    private FindDoctorListPresenter findDoctorListPresenter;
    private int idddd;
    private InquiryAdapter inquiryAdapter;
    private PopupWindow popupWindow;
    private SharedPreferences sp;
    private String sessionId;
    private int idd;
    private MoneyPresenter moneyPresenter;
    private int servicepr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_inquiry;
    }

    @Override
    protected void initView() {
        //科室列表
        FindDepartmentPresenter findDepartmentPresenter = new FindDepartmentPresenter(new Depart());
        findDepartmentPresenter.reqeust();

        //钱包

        moneyPresenter = new MoneyPresenter(new MoneyPresen());
        //医生列表
        findDoctorListPresenter = new FindDoctorListPresenter(new Doctor());
        findDoctorListPresenter.reqeust(2, 4, 1, 1, 5);
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

    @OnClick({R2.id.tv_zh, R2.id.tv_hp, R2.id.tv_zxs, R2.id.tv_price,R2.id.tv_ask})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.tv_zh) {
            findDoctorListPresenter.reqeust(idddd, 1, 1, 1, 5);
        } else if (id == R.id.tv_hp) {
            findDoctorListPresenter.reqeust(idddd, 2, 1, 1, 5);
        } else if (id == R.id.tv_zxs) {
            findDoctorListPresenter.reqeust(idddd, 3, 1, 1, 5);
        } else if (id == R.id.tv_price) {
            findDoctorListPresenter.reqeust(idddd, 4, 1, 1, 5);
        }else if (id == R.id.tv_ask) {

            moneyPresenter.reqeust(idd, sessionId);
        }
    }

    private void showPopWindow() {
        //找到pop弹窗布局
        View view = LayoutInflater.from(InquiryActivity.this).inflate(R.layout.pop_advisory, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //找子布局控件
        TextView but = view.findViewById(R.id.pop_but);
        TextView qu = view.findViewById(R.id.pop_qu);
        //去咨询
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //取消
        qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //activity的布局
        View rootView = LayoutInflater.from(InquiryActivity.this).inflate(R.layout.activity_inquiry, null);
        //位置
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }

    private class Depart implements DataCall<List<DepartmentBean>> {
        @Override
        public void success(List<DepartmentBean> data, Object... args) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            inquiryRv.setLayoutManager(linearLayoutManager);
            final FindDepartmentAdapter wellreceived = new FindDepartmentAdapter(com.wd.health_main.R.layout.depart_item, data);
            wellreceived.setWork(new FindDepartmentAdapter.Work() {
                @Override
                public void sad(int id, String name,int myposition) {
                    wellreceived.getIndex(myposition);
                    wellreceived.notifyDataSetChanged();
                    idddd = id;
                    findDoctorListPresenter.reqeust(idddd, 4, 1, 1, 5);
                }
            });
            inquiryRv.setAdapter(wellreceived);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class Doctor implements DataCall<List<DoctorBean>> {
        @Override
        public void success(List<DoctorBean> result, Object... args) {
            sdvPic.setImageURI(result.get(0).imagePic);
            tvName.setText(result.get(0).doctorName);
            tvInauguralHospital.setText(result.get(0).inauguralHospital);
            tvJobTitle.setText(result.get(0).jobTitle);
            tvPraiseNum.setText("好评率   " + result.get(0).praise);
            tvServerNum.setText("服务患者数   " + result.get(0).serverNum);
            tvServicePrice.setText(result.get(0).servicePrice + "H币/次");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(InquiryActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvDoctor.setLayoutManager(linearLayoutManager);
            inquiryAdapter = new InquiryAdapter(R.layout.inquiry_item, result);
            inquiryAdapter.setDoctor(new InquiryAdapter.Doctor() {
                @Override
                public void sad(Uri image, String name, int myposition,String inauguralHospital,String jobTitle,String praise,int serverNum,int servicePrice) {
                    sdvPic.setImageURI(image) ;
                    tvName.setText(name);
                    inquiryAdapter.getIndex(myposition);
                    inquiryAdapter.notifyDataSetChanged();
                    tvInauguralHospital.setText(inauguralHospital);
                    tvJobTitle.setText(jobTitle);
                    tvPraiseNum.setText("好评率   " + praise);
                    tvServerNum.setText("服务患者数   " + serverNum);
                    tvServicePrice.setText(servicePrice + "H币/次");
                    servicepr = servicePrice;
                }
            });
            rvDoctor.setAdapter(inquiryAdapter);
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private class MoneyPresen implements DataCall<Result> {

        double result;

        @Override
        public void success(Result data, Object... args) {
            if (data.getStatus().equals("0000")) {
                DecimalFormat decimalFormat = new DecimalFormat("######0.00");
                result = (double) data.getResult();
                if (result>=servicepr){
                    //点击判断弹出pop本次将扣除
                    showPopWindow();
                }else {
                    //H币不足
                    showqueWindow();
                }
            }else  if (data.getStatus().equals("9999")){
                //请先登录
                showloginWindow();
            }
        }

        @Override
        public void fail(ApiException data, Object... args) {

        }
    }

    private void showloginWindow() {
        //找到pop弹窗布局
        View view = LayoutInflater.from(InquiryActivity.this).inflate(R.layout.pop_login, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //找子布局控件
        TextView but = view.findViewById(R.id.pop_but_login);
        TextView qu = view.findViewById(R.id.pop_qu_login);
        //去咨询
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentByRouter(Constant.ACTIVITY_URL_MY_LOG);
                popupWindow.dismiss();
            }
        });
        //取消
        qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //activity的布局
        View rootView = LayoutInflater.from(InquiryActivity.this).inflate(R.layout.activity_inquiry, null);
        //位置
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }

    private void showqueWindow() {
        //找到pop弹窗布局
        View view = LayoutInflater.from(InquiryActivity.this).inflate(R.layout.pop_que, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        //设置高度
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //找子布局控件
        TextView but = view.findViewById(R.id.pop_but_que);
        TextView qu = view.findViewById(R.id.pop_qu_que);
        //去咨询
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //取消
        qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //activity的布局
        View rootView = LayoutInflater.from(InquiryActivity.this).inflate(R.layout.activity_inquiry, null);
        //位置
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sessionId = sp.getString("sessionId", "");
        idd = sp.getInt("Id", 0);
    }
}
