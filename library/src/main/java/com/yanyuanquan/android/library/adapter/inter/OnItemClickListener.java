package com.yanyuanquan.android.library.adapter.inter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public interface OnItemClickListener<VH extends RecyclerView.ViewHolder> {

    void onItemClickListener(VH holder);
}
