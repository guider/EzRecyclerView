package com.yanyuanquan.android.library.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.yanyuanquan.android.library.adapter.inter.DataHelp;
import com.yanyuanquan.android.library.adapter.inter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guider on 16/8/23.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class DataHelpAdatper<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements DataHelp<T> {

    private List<T> mDatas;
    private int layoutId;

    public DataHelpAdatper(List<T> mDatas, int layoutId) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;

    }

    public DataHelpAdatper(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    public DataHelpAdatper(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void setData(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public void append(List<T> datas) {
        if (mDatas == null) {
            mDatas = new ArrayList<T>();
        }
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public void append(T data) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(data);
        notifyItemInserted(mDatas.size() - 1);
    }

    @Override
    public void appendBefor(T data) {
        List<T> tmpList = new ArrayList<>();
        tmpList.add(data);
        tmpList.addAll(mDatas);
        notifyItemInserted(0);
    }

    @Override
    public void appendBefor(List<T> datas) {
        List<T> tmpDatas = new ArrayList<>();
        tmpDatas.addAll(datas);
        tmpDatas.addAll(mDatas);
        mDatas = tmpDatas;
        notifyDataSetChanged();
    }

    @Override
    public void insert(T data, int position) {
        if (mDatas == null && mDatas.size() < position) {
            Log.d("zjw", "数据插入错误");
            return;
        }
        mDatas.add(position, data);
        notifyItemInserted(position);
    }

    @Override
    public void insert(List<T> data, int position) {
        if (mDatas == null && mDatas.size() < position) {
            Log.d("zjw", "数据插入错误");
            return;
        }
        mDatas.addAll(position, data);
        notifyItemRangeInserted(position, data.size());
    }

    @Override
    public void replace(T data, int postion) {
        if (mDatas == null || mDatas.size() < postion) {
            Log.d("zjw", "数据替换错误");
            return;
        }
        mDatas.set(postion, data);
        notifyItemInserted(postion);
    }

    @Override
    public void remove(T data) {
        if (mDatas != null) {
            mDatas.remove(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public void remove(int postion) {
        if (mDatas != null && mDatas.size() > postion) {
            mDatas.remove(postion);
            notifyItemRemoved(postion);
        }
    }

    @Override
    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public List<T> getDatas() {
        return mDatas;
    }

    @Override
    public T getData(int position) {
        return mDatas.get(position);
    }

    @Override
    public boolean hasLoadingFooter() {
        return false;
    }


}
