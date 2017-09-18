package com.example.zhaolei.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zhaolei on 2017/9/17.
 */

public class SubscribeAdapter extends BaseAdapter implements View.OnClickListener{

    private Context context;
    private List<SubscribeBean> mData;
    private LayoutInflater mInflater;
    private Callback mCallback;

    public interface Callback {
        public void click(View v);
    }

    /**
     *
     * @param context
     * @param data
     */
    public  SubscribeAdapter(Context context, List<SubscribeBean> data, SubscribeAdapter.Callback callback) {

        this.context = context;
        this.mData = data;
        mInflater = LayoutInflater.from(context);
        mCallback = callback;
    }

    @Override
    public int getCount() {return mData.size();}

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SubscribeViewHolder holder = null;
        // 判断 是否缓存
        if (convertView == null) {
            holder = new SubscribeViewHolder();
            // 通过LayoutInflater 实例化布局
            convertView = mInflater.inflate(R.layout.video_article_item, null);

            holder.data_tv = (TextView) convertView.findViewById(R.id.video_article_date_l);
            holder.title_tv = (TextView) convertView.findViewById(R.id.video_article_title_tv);
            holder.desc_tv = (TextView) convertView.findViewById(R.id.video_article_desc_tv);
            holder.image_iv = (ImageView) convertView.findViewById(R.id.resource_iv);
            holder.collection_tv = (TextView) convertView.findViewById(R.id.collection_tv);
            convertView.setTag(holder);
        } else {
            // 通过tag找到缓存的布局文件
            holder = (SubscribeViewHolder) convertView.getTag();
        }
        // 设置布局中控件的显示的视图
        SubscribeBean bean = (SubscribeBean) mData.get(position);

        holder.data_tv.setText(bean.getData());
        holder.title_tv.setText(bean.getSubscribeTitle());
        holder.desc_tv.setText(bean.getSubscribeDesc());

        Picasso.with(context).load(bean.getImageUrl()).into(holder.image_iv);

        holder.collection_tv.setText(String.valueOf(bean.getCollectionCount()));
        holder.collection_tv.setTag(position);

        holder.collection_tv.setOnClickListener(this);
        return convertView;
    }

    public final class SubscribeViewHolder {

        public TextView data_tv;
        public TextView title_tv;
        public TextView desc_tv;
        public ImageView image_iv;
        public TextView collection_tv;
    }

    /**
     * @param 响应按钮点击事件 调用自定义接口  并传入View
     */
    public void onClick(View v) {
        mCallback.click(v);
    }
}

