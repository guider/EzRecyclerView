package com.yanyuanquan.android.library.adapter;

import java.util.List;

/**
 * Created by guider on 16/8/23.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzAdpter extends EzBaseAdatper {

    public EzAdpter(List mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzAdpter(List mDatas) {
        super(mDatas);
    }

    public EzAdpter(int layoutId) {
        super(layoutId);
    }
}
