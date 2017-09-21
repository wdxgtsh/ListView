package com.example.zhaolei.listview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by zhaolei on 2017/9/18.
 */


@SuppressLint("NewApi")
public class ConsultFragment extends Fragment
{

    private RecyclerView mRecycleView;
    private ConsultAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.tab_consult, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        initData();
        initView();
    }

    private void initData() {
        // 竖直方向的网格样式，每行四个Item
        mLayoutManager = new GridLayoutManager(getActivity(), 4, OrientationHelper.VERTICAL, false);

        mAdapter = new ConsultAdapter(getData());
    }

    private void initView() {

        mRecycleView = (RecyclerView)getView().findViewById(R.id.consult_recycle_view);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.addItemDecoration(new ConsultGridRvDividerDecoration(getActivity()));

        System.out.println("=====================================>>>>>>>>>>>>>>>>>>>>>>>>>>");

        mRecycleView.setAdapter(mAdapter);


    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for (int i = 0; i < 50; i++) {
            data.add(i + temp);
        }
        return data;
    }
}


