package com.yanyuanquan.android.library.adapter;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yanyuanquan.android.library.adapter.anno.ItemType;
import com.yanyuanquan.android.library.adapter.holder.EzHolder;

import java.io.File;
import java.lang.reflect.Field;
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

    public EzMultAdapter() {
    }

    private SparseArray<Integer> layouts = new SparseArray<>();

    public void addItemType(int type, int layoutId) {
        layouts.put(type, layoutId);
    }

    @Override
    public int getMultItemViewType(int position) {
        T t = mDatas.get(position);
        Class clz = t.getClass();
        Field[] fs = clz.getDeclaredFields();
        for (Field field : fs) {
            ItemType anno = field.getAnnotation(ItemType.class);
            if (anno != null) {
                field.setAccessible(true);
                try {
                   return (int) field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.e("EzMultAdapter","没有找到带有ItemType 注解的字段");
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
