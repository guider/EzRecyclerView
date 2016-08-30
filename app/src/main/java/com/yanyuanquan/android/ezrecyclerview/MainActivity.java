package com.yanyuanquan.android.ezrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.yanyuanquan.android.library.adapter.EzAdapter;
import com.yanyuanquan.android.library.adapter.EzBaseAdapter;
import com.yanyuanquan.android.library.adapter.holder.EzHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerview;
    private EzAdapter<String> adapter;
    List<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter = new EzAdapter<String>(arr, android.R.layout.simple_list_item_2) {
            @Override
            public void convert(EzHolder holder, String s) {
                holder.setText(android.R.id.text1, s);
            }

            @Override
            public boolean loadingViewBelowHeader() {
                return true;
            }

            @Override
            public boolean emptyViewBelowHeader() {
                return true;
            }

            @Override
            public boolean errorViewBelowHeader() {
                return true;
            }
        });
//        adapter.addHeader(LayoutInflater.from(this).inflate(R.layout.headerview,recyclerview,false));
        adapter.setLoadingView(LayoutInflater.from(this).inflate(R.layout.loadingveiw, recyclerview, false));
        View errorView;
        adapter.setErrorView(errorView = LayoutInflater.from(this).inflate(R.layout.errorview, recyclerview, false));
        getData(false);
        errorView.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(true);
                adapter.setCurrentStatus(EzBaseAdapter.Status.STATUS_LOADING);
                adapter.notifyDataSetChanged();
            }
        });
    }

    Handler handler = new Handler();

    private List getData(final boolean b) {
        handler.postDelayed(new TimerTask() {
            @Override
            public void run() {

                if (!b) {
                    adapter.setCurrentStatus(EzBaseAdapter.Status.STATUS_ERROR);
                    adapter.notifyDataSetChanged();
                } else {

                    for (int i = 0; i < 20; i++) {
                        arr.add("  guider  >>> " + i);
                    }
                    adapter.setCurrentStatus(EzBaseAdapter.Status.STATUS_CONTENT);
                    adapter.notifyDataSetChanged();
                }
            }
        }, 2000);

        return arr;
    }
}
