package com.example.zhaolei.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MySubscribeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lv;
    private List<MySubscribeBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_subscribe);
        lv = (ListView) findViewById(R.id.my_subscribe_listView);

        init();
    }

    /*
    *  init method
    */
    private void init() {

        data = new ArrayList<MySubscribeBean>();
        for (int i = 0; i < 10; i++) {
            MySubscribeBean bean = new MySubscribeBean();
            bean.setSubscribeName("脊柱外科-" + i);
            bean.setSubscribeCount(i * 9);
            bean.setSubscribeImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2225057053,4286504650&fm=27&gp=0.jpg");
            data.add(bean);
        }

        lv.setAdapter(new MySubscribeAdapter(this, data, myClickListener));
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listview的item被点击了！，点击的位置是-->" + position,
                Toast.LENGTH_SHORT).show();
    }

    private MySubscribeAdapter.MyClickListener myClickListener = new MySubscribeAdapter.MyClickListener() {
        @Override
        public void myOnClick(int position, View v) {
            Toast.makeText(MySubscribeActivity.this, "item上的控件被点击了！，点击的位置是-->" + position,
                    Toast.LENGTH_SHORT).show();
        }
    };
}
