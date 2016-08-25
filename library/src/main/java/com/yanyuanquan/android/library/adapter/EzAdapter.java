package com.yanyuanquan.android.library.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzAdapter<T,VH extends RecyclerView.ViewHolder> extends EzBaseAdpter<T,VH> {
    public EzAdapter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzAdapter(List mDatas) {
        super(mDatas);
    }

    public EzAdapter(int layoutId) {
        super(layoutId);
    }

}
