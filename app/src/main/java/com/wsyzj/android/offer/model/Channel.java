package com.wsyzj.android.offer.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;


/**
 * @name:
 * @author: wsyzj
 * @company: 曙华科技
 * @date: 2017-03-02 17:32
 * @comment: 拖拽的按钮
 */
public class Channel implements MultiItemEntity {
    public static final int TYPE_MY_TITLE = 0;                    // 我的频道(标题)
    public static final int TYPE_MY_CHANNEL = 1;                  // 我的频道
    public static final int TYPE_RECOMMEND_TITLE = 2;             // 推荐频道(标题)
    public static final int TYPE_RECOMMEND_CHANNEL = 3;           // 推荐频道

    private int itemType;
    public String title;

    public Channel(int itemType, String title) {
        this.itemType = itemType;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
