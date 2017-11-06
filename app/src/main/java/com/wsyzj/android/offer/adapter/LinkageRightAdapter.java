package com.wsyzj.android.offer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.AcupointB;
import com.wsyzj.android.offer.bean.AcupointC;
import com.wsyzj.android.offer.tools.UIUtils;

import java.util.List;

/**
 * author : 焦洋
 * time   : 2017/11/6  14:26
 * desc   : LinkageRightAdapter
 */
public class LinkageRightAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<AcupointC> mAcupointData;

    public LinkageRightAdapter(Context context, List<AcupointC> acupointData) {
        mContext = context;
        mAcupointData = acupointData;
    }

    @Override
    public int getGroupCount() {
        return mAcupointData == null ? 0 : mAcupointData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public AcupointC getGroup(int groupPosition) {
        return mAcupointData.get(groupPosition);
    }

    @Override
    public List<AcupointB.TBean.ContentBean> getChild(int groupPosition, int childPosition) {
        return mAcupointData.get(groupPosition).Content;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.item_right_group_linkage);
            holder.tv_index = (TextView) convertView.findViewById(R.id.tv_index);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        AcupointC group = getGroup(groupPosition);
        holder.tv_index.setText(group.Letters);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.item_right_child_linkage);
            holder.gridView = (GridView) convertView.findViewById(R.id.gridView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        List<AcupointB.TBean.ContentBean> child = getChild(groupPosition, childPosition);
        holder.gridView.setAdapter(new LinkageRihgtChildAdapter(mContext, child));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private static class ViewHolder {
        private TextView tv_index;
        private GridView gridView;
    }
}
