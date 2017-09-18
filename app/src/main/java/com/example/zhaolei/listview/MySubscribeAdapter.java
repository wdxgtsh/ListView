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
 * Created by zhaolei on 2017/9/16.
 */
public class MySubscribeAdapter extends BaseAdapter {

    private  static final  String TAG = "MySubscribeAdapter";
    private Context context;
    private List<MySubscribeBean> mData;
    private LayoutInflater mInflater;
    private MyClickListener mListener;

    public interface Callback {
        public void click(View v);
    }

    /**
     *
     * @param context
     * @param data
     */
    public  MySubscribeAdapter(Context context, List<MySubscribeBean> data, MyClickListener listener) {

        this.context = context;
        this.mData = data;
        mInflater = LayoutInflater.from(context);
        mListener = listener;
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

        MySubscribeViewHolder holder = null;
        // 判断 是否缓存
        if (convertView == null) {
            holder = new MySubscribeViewHolder();
            // 通过LayoutInflater 实例化布局
            convertView = mInflater.inflate(R.layout.viewholder_item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.iv_subscribe_alllable_photo);
            holder.title = (TextView) convertView.findViewById(R.id.tv_subscribe_alllable_name);
            holder.subscribeNum = (TextView) convertView.findViewById(R.id.tv_subscribe_alllable_num);
            holder.subscribeImageView = (ImageView) convertView.findViewById(R.id.iv_subscribe_label);
            convertView.setTag(holder);
        } else {
            // 通过tag找到缓存的布局文件
            holder = (MySubscribeViewHolder)convertView.getTag();
        }
        // 设置布局中控件的显示的视图
        MySubscribeBean bean = (MySubscribeBean) mData.get(position);
        Picasso.with(context).load(bean.getSubscribeImage()).into(holder.img);

        holder.title.setText(bean.getSubscribeName());
        holder.subscribeNum.setText(String.valueOf(bean.getSubscribeCount()));
        holder.subscribeImageView.setTag(position);
        holder.subscribeImageView.setOnClickListener(mListener);
        return convertView;
    }

    public final class MySubscribeViewHolder {

        public ImageView img;
        public TextView title;
        public TextView subscribeNum;
        public ImageView subscribeImageView;
    }

    /**
     *  用于回调的抽象类
     */
    public static abstract class  MyClickListener implements View.OnClickListener {
        /**
         *  基类的onclick方法
         */
        @Override
        public void onClick(View v) {
            myOnClick((Integer)v.getTag(), v);
        }

        public abstract void myOnClick(int position, View v);
    }
}

