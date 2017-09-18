package com.example.zhaolei.listview;

/**
 * Created by zhaolei on 2017/9/17.
 */

public class SubscribeBean {
    // 日期
    private String data;
    // 订阅 title
    private String subscribeTitle;
    // 订阅 desc
    private String subscribeDesc;
    // image url
    private String imageUrl;
    // subscribe count
    private int collectionCount;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSubscribeTitle() {
        return subscribeTitle;
    }

    public void setSubscribeTitle(String subscribeTitle) {
        this.subscribeTitle = subscribeTitle;
    }

    public String getSubscribeDesc() {
        return subscribeDesc;
    }

    public void setSubscribeDesc(String subscribeDesc) {
        this.subscribeDesc = subscribeDesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }
}
