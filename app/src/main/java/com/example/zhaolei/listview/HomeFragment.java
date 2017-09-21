package com.example.zhaolei.listview;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by zhaolei on 2017/9/18.
 */


@SuppressLint("NewApi")
public class HomeFragment extends Fragment{

    private RecyclerView mRecycleView;
    private HomeAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button addButton;
    private Button deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.tab_home, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        initData();
        initView();
    }

    private void initData() {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // 横向
//        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new HomeAdapter(getData());
        mAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),"click " + position + " item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity(),"long click " + position + " item", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        mRecycleView = (RecyclerView)getView().findViewById(R.id.home_recycle_view);
        // 设置布局管理器
        mRecycleView.setLayoutManager(mLayoutManager);
        // 设置 装饰样式
        mRecycleView.addItemDecoration(new HomeDividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
        // 横向
//        mRecycleView.addItemDecoration(new HomeDividerItemDecoration(getActivity(),LinearLayoutManager.HORIZONTAL));
        // 设置Item添加和移除的动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        // 设置adapter
        mRecycleView.setAdapter(mAdapter);


        addButton = (Button)getView().findViewById(R.id.add_item);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });
        deleteButton = (Button)getView().findViewById(R.id.delete_item);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(v);
            }
        });
    }

    public void addItem(View v) {

        mAdapter.addNewItem();
        // 由于Adapter内部是直接在首个Item位置做增加操作，增加完毕后列表移动到首个Item位置
        mLayoutManager.scrollToPosition(0);
    }

    public void deleteItem(View v) {

        mAdapter.deleteItem();
        // 由于Adapter内部是直接在首个Item位置做删除操作，删除完毕后列表移动到首个Item位置
        mLayoutManager.scrollToPosition(0);
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

