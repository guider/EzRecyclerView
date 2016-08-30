package com.yanyuanquan.android.library.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yanyuanquan.android.library.adapter.anno.ItemType;
import com.yanyuanquan.android.library.adapter.holder.EzHolder;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guider on 16/8/30.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public abstract class EzMultAdapter<T> extends EzAdapter<T> {

    public EzMultAdapter(List<T> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    public EzMultAdapter(List<T> mDatas) {
        super(mDatas);
    }

    public EzMultAdapter(int layoutId) {
        super(layoutId);
    }

    private SparseArray<Integer> layouts = new SparseArray<>();

    public void addItemType(int type, int layoutId) {
        layouts.put(type, layoutId);
    }

    @Override
    public int getMultItemViewType(int position) {
        T t = mDatas.get(position);
        Method[] ms = t.getClass().getDeclaredMethods();
        int itemType = 0;
        for (Method method : ms) {
            ItemType it = method.getAnnotation(ItemType.class);
            if (it != null) {
                Class clz = t.getClass();

                return itemType;
            }
        }


        return super.getMultItemViewType(position);
    }

    @Override
    protected EzHolder createDefaultHolder(ViewGroup parent, int viewType) {
        return new EzHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutType(viewType), parent, false));
    }

    protected int getLayoutType(int viewType) {
        return layouts.get(viewType);
    }
}
