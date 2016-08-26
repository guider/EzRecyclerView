package com.yanyuanquan.android.library.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yanyuanquan.android.library.adapter.holder.EzHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by guider on 16/8/23.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class ViewHelpAdpter<T> extends DataHelpAdatper<T> {

    public View headerView, footerView, loadingFooterView;

    public enum Type {UNNKONW, CONTENT, HEADER, FOOTER, LOADINGFOOTER, LOADING, EMPTY}

    public ViewHelpAdpter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public ViewHelpAdpter(List mDatas) {
        super(mDatas);
    }

    public ViewHelpAdpter(int layoutId) {
        super(layoutId);
    }


    @Override
    public EzHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EzHolder holder = null;
        if (viewType == Type.CONTENT.ordinal()) {

        } else if (viewType == Type.HEADER.ordinal()) {

        } else if (viewType == Type.FOOTER.ordinal()) {

        } else if (viewType == Type.LOADING.ordinal()) {

        } else if (viewType == Type.EMPTY.ordinal()) {

        } else if (viewType == Type.LOADINGFOOTER.ordinal()) {
        } else {
            //UNKNOW.ordinal();
            throw new IllegalArgumentException(" unknow viewType  >> " + viewType);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(EzHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == Type.CONTENT.ordinal()) {

        } else if (viewType == Type.HEADER.ordinal()) {

        } else if (viewType == Type.FOOTER.ordinal()) {

        } else if (viewType == Type.LOADING.ordinal()) {

        } else if (viewType == Type.EMPTY.ordinal()) {

        } else if (viewType == Type.LOADINGFOOTER.ordinal()) {

        } else {
            //UNKNOW.ordinal();
            throw new IllegalArgumentException(" unknow viewType  >> " + viewType);

        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        int size = 0;
        if (mDatas ==null||mDatas.size() ==0){

        }
        size = size + (hasFooter() ? 1 : 0) + (hasLoadingFooter() ? 1 : 0) + (hasHeader() ? 1 : 0);


        return 0;
    }

    @Override
    public boolean hasFooter() {
        return footerView != null;
    }

    @Override
    public boolean hasHeader() {
        return headerView != null;
    }

}
