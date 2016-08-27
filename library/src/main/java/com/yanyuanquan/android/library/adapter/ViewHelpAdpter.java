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

    public View headerView, footerView, loadingFooterView, emptyView, loadingView;

    public enum Type {UNNKONW, CONTENT, HEADER, FOOTER, LOADINGFOOTER, LOADING, EMPTY, ERROR}

    public enum Status {STATUS_LOADING, STATUS_ERROR, STATUS_EMPTY, STATUS_OTHER}

    public enum LFStatus {STATUS_LOAD_NOMORE, STATUS_LOAD_ERROR, STATUS_LOAD_MORE}

    public ViewHelpAdpter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public ViewHelpAdpter(List mDatas) {
        super(mDatas);
    }

    public ViewHelpAdpter(int layoutId) {
        super(layoutId);
    }


    public Status currentStatus = Status.STATUS_LOADING;

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public EzHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EzHolder holder = null;
        if (viewType == Type.CONTENT.ordinal()) {

        } else if (viewType == Type.HEADER.ordinal()) {

        } else if (viewType == Type.FOOTER.ordinal()) {

        } else if (viewType == Type.LOADING.ordinal()) {

        } else if (viewType == Type.EMPTY.ordinal()) {

        } else if (viewType == Type.ERROR.ordinal()) {

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

        } else if (viewType == Type.ERROR.ordinal()) {

        } else if (viewType == Type.LOADINGFOOTER.ordinal()) {

        } else {
            //UNKNOW.ordinal();
            throw new IllegalArgumentException(" unknow viewType  >> " + viewType);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (currentStatus == Status.STATUS_LOADING) {
            if (position == 0 && hasHeader() && loadingViewBelowHeader()) {
                return Type.HEADER.ordinal();
            } else {
                return Type.LOADING.ordinal();
            }
        } else if (currentStatus == Status.STATUS_EMPTY) {
            if (position == 0 && hasHeader() && emptyViewBelowHeader()) {
                return Type.HEADER.ordinal();
            } else {
                return Type.EMPTY.ordinal();
            }
        } else if (currentStatus == Status.STATUS_ERROR) {
            if (position == 0 && hasHeader() &&hasErrorView()&& errorViewBelowHeader()) {
                return Type.HEADER.ordinal();
            } else {
                return Type.ERROR.ordinal();
            }
        } else {
            if (position == 0 &&hasHeader() ){
                return Type.HEADER.ordinal();
            }


        }


        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        int count = 0;
        if (mDatas == null || mDatas.size() == 0) {
            count = mDatas.size();
        }
        if (count > 0) {
            count = count + (hasFooter() ? 1 : 0) + (hasLoadingFooter() ? 1 : 0);
        } else {
            count += (hasHeader() ? 1 : 0);
            // according to currentStatus get ItemCount
            count += (Status.STATUS_LOADING == currentStatus) ? ((hasLoadingView() && loadingViewBelowHeader())
                    ? 1 : 0) : ((hasEmptyView() && emptyViewBelowHeader()) ? 1 : 0);
        }
        return count;
    }

    @Override
    public boolean hasFooter() {
        return footerView != null;
    }

    @Override
    public boolean hasHeader() {
        return headerView != null;
    }

    @Override
    public boolean hasLoadingFooter() {
        return loadingFooterView != null;
    }

    @Override
    public boolean hasEmptyView() {
        return emptyView != null;
    }

    @Override
    public boolean hasLoadingView() {
        return loadingView != null;
    }
}
