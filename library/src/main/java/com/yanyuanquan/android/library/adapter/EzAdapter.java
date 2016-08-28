package com.yanyuanquan.android.library.adapter;

import android.view.View;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzAdapter<T> extends EzBaseAdapter<T> {
    public EzAdapter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzAdapter(List mDatas) {
        super(mDatas);
    }

    public EzAdapter(int layoutId) {
        super(layoutId);
    }

    public void setLoadingView(View loadingView) {
        this.loadingView = loadingView;
    }
    public void setLoadingView(int  loadingViewId) {
        this.loadingView = loadingView;
    }
}
