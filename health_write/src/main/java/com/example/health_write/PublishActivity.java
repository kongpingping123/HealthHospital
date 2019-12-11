package com.example.health_write;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.TimePickerView;
import com.example.health_write.adapter.ImageAdapter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.wd.common.core.WDActivity;
import com.wd.common.util.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.ResourceBundle.clearCache;

@Route(path = Constant.ACTIVITY_URL_WRITE)
public class PublishActivity extends WDActivity {
    private ImageView keshi;
    private ImageView zhuyao;
    private ImageView xia_ImageView;
    private ImageView time_ImageView;
    private RecyclerView add_ImageView;
    private TextView add_TextView;
    private TextView et_apply_department;
    private TextView bingzheng;
    private TextView time_TextView;
    private TimePickerView pvTime;
    private TextView over_time;
    private List<LocalMedia> images;
    private ImageAdapter imageAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish;
    }

    @Override
    protected void initView() {
        keshi = findViewById(R.id.keshi);
        et_apply_department = findViewById(R.id.et_apply_department);
        bingzheng = findViewById(R.id.bingzheng);
        zhuyao = findViewById(R.id.zhuyao);
        add_ImageView = findViewById(R.id.add_ImageView);
        add_TextView = findViewById(R.id.add_TextView);
        time_TextView = findViewById(R.id.time_TextView);
        time_ImageView = findViewById(R.id.time_ImageView);
        xia_ImageView = findViewById(R.id.xia_ImageView);
        over_time = findViewById(R.id.over_time);

        ArrayList<String> strings = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        add_ImageView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        imageAdapter = new ImageAdapter(strings,PublishActivity.this);

        //  imageAdapter.addItem("res://com.dingtao.rrmmp/R.drawable.add");
//        recyclerView.setAdapter(iamgeAdpater);
        add_ImageView.setAdapter(imageAdapter);

        xia_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimex();
            }
        });

        time_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimex();
            }
        });


        add_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(PublishActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(6)
                        .minSelectNum(1)
                        .imageSpanCount(4)
                        .selectionMedia(images)// 是否传入已选图片 List<LocalMedia> list
                        .selectionMode(PictureConfig.MULTIPLE)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }

        });
        imageAdapter.onItemClickListenerx(new ImageAdapter.OnItemClickListenerx() {
            @Override
            public void onItemClick(int position) {
                onItemClick(position);
                notify();
            }
        });


        clearCache();


        keshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String [] list={"内科", "眼科", "骨科", "儿科", "传染病科", "皮肤病科", "耳鼻喉科", "精神病科"};
                final ListPopupWindow listPopupWindow;
                listPopupWindow = new ListPopupWindow(PublishActivity.this);
                listPopupWindow.setAdapter(new ArrayAdapter<String>(PublishActivity.this,android.R.layout.simple_list_item_1,list));
                listPopupWindow.setAnchorView(et_apply_department);
                listPopupWindow.setModal(true);
//                et_apply_department.setSelection(et_apply_department.getText().length());
                listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        et_apply_department.setText(list[position]);
                        listPopupWindow.dismiss();
                    }
                });
                listPopupWindow.show();
                et_apply_department.setCursorVisible(false);

            }
        });
        zhuyao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String [] list={"猩红热", "百日咳", "水痘", "风疹", "麻疹",

                        "儿童骨髓炎", "儿童风湿热", "小儿肾炎","小儿遗尿症", "小儿夜哭",
                        "儿童骨髓炎", "儿童风湿热", "小儿肾炎","小儿遗尿症", "小儿夜哭"};
                final ListPopupWindow listPopupWindow;
                listPopupWindow = new ListPopupWindow(PublishActivity.this);
                listPopupWindow.setAdapter(new ArrayAdapter<String>(PublishActivity.this,android.R.layout.simple_list_item_1,list));
                listPopupWindow.setAnchorView(bingzheng);
                listPopupWindow.setModal(true);
//                bingzheng.setSelection(bingzheng.getText().length());
                listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        bingzheng.setText(list[position]);
                        listPopupWindow.dismiss();
                    }
                });
                listPopupWindow.show();
                et_apply_department.setCursorVisible(false);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    images = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i <images.size() ; i++) {
                        imageAdapter.addItem("file://"+images.get(i).getPath());

                    }
                    imageAdapter.notifyDataSetChanged();
                    break;
            }
        }

    }
    private void getTimex() {
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                time_TextView.setText((CharSequence) date);
            }

        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentSize(12)//滚轮文字大小
                .setTitleSize(14)//标题文字大小
                .setTitleText("选择日期")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
//    .setSubmitColor(Color.BLUE)//确定按钮文字颜色
//    .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTitleBgColor(Color.BLUE)//标题背景颜色 Night mode
                //  .setBgColor(Color.blue(1))//滚轮背景颜色 Night mode
////    .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
////    .setRangDate(startDate,endDate)//起始终止年月日设定
//    //.setLabel("年","月","日","时","分","秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.show();

    }
    @Override
    protected void destoryData() {

    }
}
