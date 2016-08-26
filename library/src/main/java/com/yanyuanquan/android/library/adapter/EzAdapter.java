package com.yanyuanquan.android.library.adapter;

import java.util.List;

/**
 * Created by guider on 16/8/24.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzAdapter<T> extends ViewHelpAdpter<T> {
    public EzAdapter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzAdapter(List mDatas) {
        super(mDatas);
    }

    public EzAdapter(int layoutId) {
        super(layoutId);
    }

}
