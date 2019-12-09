package com.wd.health_main.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.SickBean;
import com.wd.common.core.WDApplication;
import com.wd.health_main.R;
import com.wd.health_main.activity.DetailsActivity;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/6 15:59
 * @Author: 作者名
 * @Version: 1.0
 */
public class PopAdapter extends BaseQuickAdapter<SickBean, BaseViewHolder> {
    public PopAdapter(int layoutResId, @Nullable List<SickBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final SickBean item) {
        helper.setText(R.id.pop_name,item.nickName);
        helper.setText(R.id.pop_xiang,item.content);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String format1 = format.format(item.commentTime);
        helper.setText(R.id.pop_shi,format1 + "");
        ImageView imageView = helper.getView(R.id.pop_iv);
        Uri uri = Uri.parse(item.headPic);
        imageView.setImageURI(uri);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.sad(item.headPic,item.nickName,item.commentId);
            }
        });

    }

    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }



    public interface CallBack{
        void sad(String image,String name,int commentId);
    }
}
