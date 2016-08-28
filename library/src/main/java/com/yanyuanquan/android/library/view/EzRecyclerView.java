package com.yanyuanquan.android.library.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.yanyuanquan.android.library.adapter.EzBaseAdapter;

/**
 * Created by guider on 16/8/22.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public class EzRecyclerView extends RecyclerView {

    public EzRecyclerView(Context context) {
        super(context);
    }

    public EzRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EzRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(final Adapter adapter) {

        super.setAdapter(adapter);

        adapter.registerAdapterDataObserver(new AdapterDataObserver() {
            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                refreshData();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                super.onItemRangeChanged(positionStart, itemCount);
                refreshData();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                super.onItemRangeChanged(positionStart, itemCount, payload);
                refreshData();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                refreshData();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                refreshData();
            }

            @Override
            public void onChanged() {
                super.onChanged();
                refreshData();
            }

            public void refreshData() {
                if (adapter instanceof EzBaseAdapter) {
                    if (((EzBaseAdapter) adapter).getDatas() == null || ((EzBaseAdapter) adapter).getDatas().size() == 0) {
                        ((EzBaseAdapter) adapter).setCurrentStatus(EzBaseAdapter.Status.STATUS_EMPTY);
                    }else {
                        ((EzBaseAdapter) adapter).setCurrentStatus(EzBaseAdapter.Status.STATUS_OTHER);
                    }
                }
            }
        });

    }


}
