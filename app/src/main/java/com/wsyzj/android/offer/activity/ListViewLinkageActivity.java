package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.adapter.LinkageLeftAdapter;
import com.wsyzj.android.offer.adapter.LinkageRightAdapter;
import com.wsyzj.android.offer.bean.AcupointC;

import java.util.List;

/**
 * author : 焦洋
 * time   : 2017/11/6  11:56
 * desc   : ListViewLinkageActivity
 */
public class ListViewLinkageActivity extends AppCompatActivity {

    private ListView lv_left;
    private ExpandableListView exlv_right;
    private List<AcupointC> mAcupointData;
    private LinkageLeftAdapter mLeftAdapter;
    private LinkageRightAdapter mRightAdapter;
    private boolean isScroll;
    private boolean shouldSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_linkage);

        initView();
        initData();
    }

    private void initView() {
        lv_left = (ListView) findViewById(R.id.lv_left);
        exlv_right = (ExpandableListView) findViewById(R.id.exlv_right);
    }

    private void initData() {
        mAcupointData = getAcupointData();
        setLeftData();
        setRightData();
    }

    /**
     * 穴位数据
     */
    private List<AcupointC> getAcupointData() {
        String result_sort = getString(R.string.result_sort1);
        return new Gson().fromJson(result_sort, new TypeToken<List<AcupointC>>() {
        }.getType());
    }

    /**
     * 左边ListView数据
     */
    private void setLeftData() {
        mLeftAdapter = new LinkageLeftAdapter(this, mAcupointData);
        lv_left.setAdapter(mLeftAdapter);
        lv_left.setItemChecked(0, true);

        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isScroll = false;
                lv_left.setItemChecked(position, true);
                exlv_right.setSelectedGroup(position);
            }
        });
    }

    /**
     * 右边ex数据
     */
    private void setRightData() {
        mRightAdapter = new LinkageRightAdapter(this, mAcupointData);
        exlv_right.setAdapter(mRightAdapter);

        for (int i = 0; i < mRightAdapter.getGroupCount(); i++) {
            exlv_right.expandGroup(i);
        }

        exlv_right.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

        exlv_right.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    shouldSet = false;
                } else {
                    shouldSet = true;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    if (shouldSet) {
                        lv_left.setItemChecked(firstVisibleItem, true);
                        lv_left.smoothScrollToPosition(firstVisibleItem);
                    }
                } else {
                    isScroll = true;
                }
            }
        });
    }
}
