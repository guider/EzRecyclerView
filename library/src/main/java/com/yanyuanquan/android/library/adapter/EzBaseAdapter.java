package com.yanyuanquan.android.library.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzBaseAdapter<T> extends DataHelpAdatper<T>{



    public EzBaseAdapter(List<T> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzBaseAdapter(List<T> mDatas) {
        super(mDatas);
    }

    public EzBaseAdapter(int layoutId) {
        super(layoutId);
    }




}
