package com.yanyuanquan.android.library.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yanyuanquan.android.library.R;
import com.yanyuanquan.android.library.adapter.holder.EzHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by guider on 16/8/23.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzBaseAdapter<T> extends ViewHelpAdapter<T> {

    public View headerView, footerView, loadingFooterView, emptyView, loadingView, errorView;

    public enum Type {CONTENT, HEADER, FOOTER, LOADINGFOOTER, LOADING, EMPTY, ERROR}

    public enum Status {STATUS_LOADING, STATUS_ERROR, STATUS_EMPTY, STATUS_CONTENT}

    public enum LFStatus {LFSTATUS_LOAD_NOMORE, LFSTATUS_LOAD_ERROR, LFSTATUS_LOADING_MORE, LFSTATUS_OTHER}

    public EzBaseAdapter(List<T> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzBaseAdapter(List<T> mDatas) {
        super(mDatas);
    }

    public EzBaseAdapter(int layoutId) {
        super(layoutId);
    }

    public EzBaseAdapter() {
    }

    public LFStatus lfStatus = LFStatus.LFSTATUS_LOADING_MORE;
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
        if (viewType == Type.HEADER.ordinal()) {
            holder = new EzHolder(headerView);
        } else if (viewType == Type.FOOTER.ordinal()) {
            holder = new EzHolder(footerView);
        } else if (viewType == Type.LOADINGFOOTER.ordinal()) {
            holder = new EzHolder(loadingFooterView);
        } else if (viewType == Type.LOADING.ordinal()) {
            holder = new EzHolder(loadingView);
        } else if (viewType == Type.EMPTY.ordinal()) {
            holder = new EzHolder(emptyView);
        } else if (viewType == Type.ERROR.ordinal()) {
            holder = new EzHolder(errorView);
        } else {
            holder = createDefaultHolder(parent, viewType);
            bindListener(holder);
        }
        return holder;
    }


    protected EzHolder createDefaultHolder(ViewGroup parent, int viewType) {
        return new EzHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(EzHolder holder, int position) {
        int viewType = holder.getItemViewType();
        if (viewType == Type.HEADER.ordinal()) {

        } else if (viewType == Type.FOOTER.ordinal()) {

        } else if (viewType == Type.LOADINGFOOTER.ordinal()) {
            convertFooter(holder);
        } else if (viewType == Type.LOADING.ordinal()) {

        } else if (viewType == Type.EMPTY.ordinal()) {

        } else if (viewType == Type.ERROR.ordinal()) {

        } else {
            convert(holder, mDatas.get(holder.getLayoutPosition() - (hasHeader() ? 1 : 0)));
        }
    }

    public abstract void convert(EzHolder holder, T t);

    @Override
    public int getItemViewType(int position) {
        Log.e("zjw","  postion  >>> " + position + "   status  " + currentStatus );
        if (position == 0 || position == 1) {
            if (currentStatus == Status.STATUS_LOADING) {
                if (position == 0) {
                    return hasHeader() ? Type.HEADER.ordinal() : Type.LOADING.ordinal();
                } else if (position == 1 && hasHeader() && hasLoadingView() && loadingViewBelowHeader()) {
                    return Type.LOADING.ordinal();
                }
            } else if (currentStatus == Status.STATUS_EMPTY) {
                if (position == 0 && hasHeader() && emptyViewBelowHeader()) {
                    return Type.HEADER.ordinal();
                } else {
                    return Type.EMPTY.ordinal();
                }
            } else if (currentStatus == Status.STATUS_ERROR) {
                if (position == 0 && hasHeader() && hasErrorView() && errorViewBelowHeader()) {
                    return Type.HEADER.ordinal();
                } else {
                    return Type.ERROR.ordinal();
                }
            } else if (position == 0 && hasHeader()) {
                return Type.HEADER.ordinal();
            }
        } else if (position <= getItemCount() - 2) {
            if (hasFooter() && hasLoadingFooter()) {
                return position == getItemCount() - 1 ? Type.FOOTER.ordinal() : Type.LOADINGFOOTER.ordinal();
            } else if (hasFooter() || hasLoadingFooter()) {
                return (position == getItemCount() && (hasFooter()) ? Type.FOOTER.ordinal() : Type.LOADINGFOOTER.ordinal());
            }
        }
        return getMultItemViewType(position);
    }

    public int getMultItemViewType(int position) {
        Log.e("zjw",super.getItemViewType(position)+"  view Type  ");
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        if (currentStatus == Status.STATUS_LOADING) {
            return (hasHeader() && loadingViewBelowHeader()) ? 2 : 1;
        }

        if (currentStatus == Status.STATUS_EMPTY) {
            return (hasHeader() && emptyViewBelowHeader()) ? 2 : 1;
        }
        if (currentStatus == Status.STATUS_ERROR) {
            return (hasHeader() && errorViewBelowHeader()) ? 2 : 1;
        }
        int count = 0;
        if (mDatas != null) {
            count = mDatas.size();
        }
        if (count > 0) {
            count = count + (hasFooter() ? 1 : 0) + (hasLoadingFooter() ? 1 : 0) + (hasHeader() ? 1 : 0);
        }
        Log.e("zjw" ,"  count  >>>   "+count);
        return count;
    }

    protected void convertFooter(EzHolder holder) {
        View progressBar = holder.getItemView().findViewById(R.id.view_hlep_adapter_progressbar);
        View textView = holder.getItemView().findViewById(R.id.view_hlep_adapter_textview);
        if (textView != null && textView instanceof TextView) {
            if (lfStatus == LFStatus.LFSTATUS_LOAD_ERROR) {
                holder.getItemView().setVisibility(View.VISIBLE);
                ((TextView) textView).setText(isNetworkAvailable(holder.getItemView().getContext()) ? "加载出错了" : "没有可用的网络");
                textView.setVisibility(View.VISIBLE);
                if (progressBar != null)
                    progressBar.setVisibility(View.VISIBLE);

            } else if (lfStatus == LFStatus.LFSTATUS_LOAD_NOMORE) {
                holder.getItemView().setVisibility(View.VISIBLE);
                ((TextView) textView).setText("没有更多了");
                textView.setVisibility(View.VISIBLE);
                if (progressBar != null)
                    progressBar.setVisibility(View.VISIBLE);
            } else if (lfStatus == LFStatus.LFSTATUS_LOADING_MORE) {
                holder.getItemView().setVisibility(View.VISIBLE);
                ((TextView) textView).setText("加载中...");
                textView.setVisibility(View.VISIBLE);
                if (progressBar != null)
                    progressBar.setVisibility(View.VISIBLE);
            } else {
                holder.getItemView().setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                if (progressBar != null)
                    progressBar.setVisibility(View.GONE);
            }
        }

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

    @Override
    public boolean hasErrorView() {
        return errorView != null;
    }
}
