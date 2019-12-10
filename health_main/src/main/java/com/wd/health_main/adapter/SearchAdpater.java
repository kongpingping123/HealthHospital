package com.wd.health_main.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.common.bean.CircleBean;
import com.wd.common.bean.SearchBean;
import com.wd.health_main.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description: 作用描述
 * @CreateDate: 2019/12/5 15:21
 * @Author: 作者名
 * @Version: 1.0
 */
public class SearchAdpater extends BaseQuickAdapter<SearchBean, BaseViewHolder> {
    public SearchAdpater(int layoutResId, @Nullable List<SearchBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean item) {
        helper.setText(R.id.tv_zhu,item.title);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format1 = format.format(item.releaseTime);
        helper.setText(R.id.tv_shi,format1+"");
        helper.setText(R.id.tv_xiang,item.detail);
        helper.setText(R.id.tv_shou,"收藏  "+item.collectionNum);
        helper.setText(R.id.tv_jian,"评论  "+item.commentNum);
    }
}
