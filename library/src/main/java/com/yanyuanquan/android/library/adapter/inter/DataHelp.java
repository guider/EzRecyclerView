package com.yanyuanquan.android.library.adapter.inter;

import java.util.List;

/**
 * Created by guider on 16/8/23.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public interface DataHelp<T> {

    void setLayoutId(int layoutId);

    void setData(List<T> datas);

    void append(List<T> datas);

    void append(T data);

    void appendBefor(List<T> datas);

    void appendBefor(T data);

    void insert(T data, int position);

    void insert(List<T> data, int position);

    void replace(T data, int postion);

    void remove(int postion);

    void remove(T data);

    void clear();

    List<T> getDatas();

    T getData(int position);

    boolean hasLoadingFooter();
}
