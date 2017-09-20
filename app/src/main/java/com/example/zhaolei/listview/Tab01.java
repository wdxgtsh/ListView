package com.example.zhaolei.listview;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zhaolei on 2017/9/18.
 */


@SuppressLint("NewApi")
public class Tab01 extends Fragment {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.tab_01, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        initData();
        initView();
    }

    private void initData() {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new HomeAdapter(getData());
    }

    private void initView() {
        mRecycleView = (RecyclerView)getView().findViewById(R.id.home_recycle_view);
        // 设置布局管理器
        mRecycleView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecycleView.setAdapter(mAdapter);
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for (int i = 0; i < 20; i++) {
            data.add(i + temp);
        }
        return data;
    }
}

