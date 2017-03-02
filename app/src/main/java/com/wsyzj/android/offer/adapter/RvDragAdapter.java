package com.wsyzj.android.offer.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.model.Channel;
import com.wsyzj.android.offer.tools.LogUtils;

import java.util.List;

/**
 * @name: RvDragAdapter
 * @author: wsyzj
 * @company: 曙华科技
 * @date: 2017-03-02 16:21
 * @comment: 拖拽的adapter
 */
public class RvDragAdapter extends BaseMultiItemQuickAdapter<Channel, BaseViewHolder> {

    public RvDragAdapter(List<Channel> data) {
        super(data);
        LogUtils.e(" -- " + data.size());
        // 标明四中类型
        addItemType(Channel.TYPE_MY_TITLE, R.layout.rv_item_type_my_channel_title);
        addItemType(Channel.TYPE_MY_CHANNEL, R.layout.rv_item_type_my_channel);
        addItemType(Channel.TYPE_RECOMMEND_TITLE, R.layout.rv_item_type_recommend_channel_title);
        addItemType(Channel.TYPE_RECOMMEND_CHANNEL, R.layout.rv_item_type_recommend_channel);
    }

    @Override
    protected void convert(BaseViewHolder helper, Channel item) {
        switch (helper.getItemViewType()) {
            case Channel.TYPE_MY_TITLE:
                helper.setText(R.id.tv_my_title, item.title);
                break;
            case Channel.TYPE_MY_CHANNEL:
                helper.setText(R.id.tv_my_channel, item.title);
                break;
            case Channel.TYPE_RECOMMEND_TITLE:
                helper.setText(R.id.tv_recommend_title, item.title);
                break;
            case Channel.TYPE_RECOMMEND_CHANNEL:
                helper.setText(R.id.tv_recommend_channel, item.title);
                break;
        }
    }
}
