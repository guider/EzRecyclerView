package com.yanyuanquan.android.library.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class ViewHelpAdapter<T,VH extends RecyclerView.ViewHolder> extends DataHelpAdatper<T,VH>{



    public ViewHelpAdapter(List<T> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public ViewHelpAdapter(List<T> mDatas) {
        super(mDatas);
    }

    public ViewHelpAdapter(int layoutId) {
        super(layoutId);
    }




}
