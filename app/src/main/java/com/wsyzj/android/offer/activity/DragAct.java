package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.adapter.RvDragAdapter;
import com.wsyzj.android.offer.model.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: DragAct
 * @author: wsyzj
 * @company: 曙华科技
 * @date: 2017-03-02 16:17
 * @comment: 仿今日头条频道管理
 */
public class DragAct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Channel> mChannels = new ArrayList<>();
    private RvDragAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
    }

    private void initDatas() {
        mChannels.add(new Channel(Channel.TYPE_MY_TITLE, "我的频道"));
        for (int x = 0; x < 20; x++) {
            mChannels.add(new Channel(Channel.TYPE_MY_CHANNEL, "头条" + x));
        }
        mChannels.add(new Channel(Channel.TYPE_RECOMMEND_TITLE, "推荐频道"));
        for (int x = 0; x < 20; x++) {
            mChannels.add(new Channel(Channel.TYPE_RECOMMEND_CHANNEL, "推荐" + x));
        }
    }
}
