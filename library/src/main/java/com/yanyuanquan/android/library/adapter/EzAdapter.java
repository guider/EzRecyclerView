package com.yanyuanquan.android.library.adapter;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzAdapter<T> extends EzBaseAdapter<T> {

    private int headerHeigh = 0;

    public EzAdapter(List<T> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzAdapter(List<T> mDatas) {
        super(mDatas);
    }

    public EzAdapter(int layoutId) {
        super(layoutId);
    }
    public EzAdapter() {
        super();
    }
    public void setLoadingView(View loadingView) {
        this.loadingView = loadingView;
//        ViewGroup.LayoutParams lp = loadingView.getLayoutParams();
//        lp.height = headerHeigh;
//        this.headerView.setLayoutParams(lp);
    }

    public void setErrorView(View errorView) {
        this.errorView = errorView;
    }

    public View getHeaderView() {
        return headerView;
    }

    public void addHeaderView(View headerView) {
        this.headerView = headerView;
    }

    private void addHeaderView(View headerView, int height) {
        this.headerView = headerView;
        this.headerHeigh = height;
        ViewGroup.LayoutParams lp = headerView.getLayoutParams();
        lp.height = headerHeigh;
        this.headerView.setLayoutParams(lp);
    }

    public View getLoadingFooterView() {
        return loadingFooterView;
    }

    public void setLoadingFooterView(View loadingFooterView) {
        this.loadingFooterView = loadingFooterView;
    }

    public View getFooterView() {
        return footerView;
    }

    public void addFooterView(View footerView) {
        this.footerView = footerView;
    }

    public View getLoadingView() {
        return loadingView;
    }

    public View getEmptyView() {
        return emptyView;
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }

    public View getErrorView() {
        return errorView;
    }
}
