package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.adapter.RvDragAdapter;
import com.wsyzj.android.offer.listener.ItemChannelHelperCallback;
import com.wsyzj.android.offer.model.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * @name:
 * @author: wsyzj
 * @company: 曙华科技
 * @date: 2017-03-02 16:17
 * @comment: 仿今日头条频道管理
 */
public class ChannelAct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Channel> mChannels = new ArrayList<>();
    private RvDragAdapter mAdapter;
    private ItemTouchHelper mHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_drag);

        initDatas();
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.reclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mAdapter = new RvDragAdapter(mChannels);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(manager);

        ItemChannelHelperCallback helperCallback = new ItemChannelHelperCallback();
        mHelper = new ItemTouchHelper(helperCallback);
        mHelper.attachToRecyclerView(recyclerView);

        /**
         * 当第一行为我的频道和推荐频道时需要把改行的长度固定为4
         */
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int itemViewType = mAdapter.getItemViewType(position);
                return itemViewType == Channel.TYPE_MY_CHANNEL || itemViewType == Channel.TYPE_RECOMMEND_CHANNEL ? 1 : 4;
            }
        });
    }

    private void initDatas() {
        mChannels.add(new Channel(Channel.TYPE_MY_TITLE, "我的频道"));
        for (int x = 0; x < 10; x++) {
            mChannels.add(new Channel(Channel.TYPE_MY_CHANNEL, "头条" + x));
        }
        mChannels.add(new Channel(Channel.TYPE_RECOMMEND_TITLE, "推荐频道"));
        for (int x = 0; x < 10; x++) {
            mChannels.add(new Channel(Channel.TYPE_RECOMMEND_CHANNEL, "推荐" + x));
        }
    }
}
