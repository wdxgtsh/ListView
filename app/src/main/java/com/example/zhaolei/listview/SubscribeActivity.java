package com.example.zhaolei.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SubscribeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SubscribeAdapter.Callback{
    private ListView lv;
    private List<SubscribeBean> data;
    private SubscribeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_article);
        lv = (ListView) findViewById(R.id.video_article_lv);

        init();
    }

    /*
    *  init method
    */
    private void init() {

        data = new ArrayList<SubscribeBean>();
        for (int i = 0; i < 10; i++) {
            SubscribeBean bean = new SubscribeBean();
            bean.setData("2017-07-09");
            if (i == 5) {
                bean.setSubscribeTitle("脊柱外科-脊柱外科-脊柱外科-脊柱外科-脊柱外科-脊柱外科-脊柱外科-脊柱外科-脊柱外科-" + i);
                bean.setSubscribeDesc("脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc脊柱外科Desc" + i);
            } else {
                bean.setSubscribeTitle("脊柱外科-" + i);
                bean.setSubscribeDesc("脊柱外科Desc" + i);
            }
            bean.setImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2225057053,4286504650&fm=27&gp=0.jpg");
            bean.setCollectionCount(i * 9);
            data.add(bean);
        }

        adapter = new SubscribeAdapter(this, data, this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listview的item被点击了！，点击的位置是-->" + position,
                Toast.LENGTH_SHORT).show();
    }

    public void click(View v) {
        SubscribeBean bean = (SubscribeBean)data.get((int)v.getTag());
        bean.setCollectionCount(bean.getCollectionCount() + 1);
        Toast.makeText(this, "擦擦擦擦擦" + v.getTag(), Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }
}
