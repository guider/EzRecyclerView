package com.yanyuanquan.android.library.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.ViewGroup;

import java.util.List;

import static com.yanyuanquan.android.library.adapter.EzBaseAdpter.Type.*;

/**
 * Created by guider on 16/8/23.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzBaseAdpter<T,VH extends RecyclerView.ViewHolder> extends DataHelpAdatper<T,VH> {


    public enum Type {CONTENT, HEADER, FOOTER, LOADING, EMPTY}

    public EzBaseAdpter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzBaseAdpter(List mDatas) {
        super(mDatas);
    }

    public EzBaseAdpter(int layoutId) {
        super(layoutId);
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEADER.ordinal()) {

        } else if (viewType == FOOTER.ordinal()) {

        } else if (viewType == LOADING.ordinal()) {

        } else if (viewType == EMPTY.ordinal()) {

        } else {
            //CONTENT.ordinal();

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        if (hasLoadingFooter()) {

        }

        return 0;
    }


}
