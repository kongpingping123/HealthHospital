package com.wd.health_main.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.CircleBean;
import com.wd.health_main.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/5 15:21
 * @Author: 作者名
 * @Version: 1.0
 */
public class CircleAdpater extends BaseQuickAdapter<CircleBean, BaseViewHolder> {
    public CircleAdpater(int layoutResId, @Nullable List<CircleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CircleBean item) {
        helper.setText(R.id.tv_zhu,item.getTitle());
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format1 = format.format(item.getReleaseTime());
        helper.setText(R.id.tv_shi,format1+"");
        helper.setText(R.id.tv_xiang,item.getDetail());
        helper.setText(R.id.tv_shou,"收藏  "+item.getCollectionNum());
        helper.setText(R.id.tv_jian,"评论  "+item.getCommentNum());
    }
}
