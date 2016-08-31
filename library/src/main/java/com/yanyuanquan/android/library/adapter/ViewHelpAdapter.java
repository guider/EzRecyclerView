package com.yanyuanquan.android.library.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yanyuanquan.android.library.adapter.holder.EzHolder;
import com.yanyuanquan.android.library.adapter.inter.OnItemClickListener;
import com.yanyuanquan.android.library.adapter.inter.OnItemLongClickListener;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class ViewHelpAdapter<T> extends DataHelpAdatper<T>{



    public ViewHelpAdapter(List<T> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public ViewHelpAdapter(List<T> mDatas) {
        super(mDatas);
    }

    public ViewHelpAdapter(int layoutId) {
        super(layoutId);
    }

    public ViewHelpAdapter() {
    }

    /**
     * 判断当前网络是否可用
     *
     * @param context
     * @return 当前网络是否可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = connectivity.getActiveNetworkInfo();
        if (info == null || !info.isConnected()) {
            return false;
        }
        return true;
    }

    // -----  Cliclk ------
    private OnItemLongClickListener onItemLongClickListener;
    private OnItemClickListener onItemClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    protected void bindListener(final EzHolder holder) {
        if (onItemClickListener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(v, holder.getLayoutPosition() - (hasHeader() ? 1 : 0));
                }
            });
        }
        if (onItemLongClickListener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemLongClickListener.onItemClickListener(v, holder.getLayoutPosition() - (hasFooter() ? 1 : 0));
                }
            });
        }

    }
}
