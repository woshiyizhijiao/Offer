package com.wsyzj.android.offer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.AcupointC;
import com.wsyzj.android.offer.tools.UIUtils;

import java.util.List;

/**
 * author : 焦洋
 * time   : 2017/11/6  14:15
 * desc   : LinkageLeftAdapter
 */
public class LinkageLeftAdapter extends BaseAdapter {

    private Context mContext;
    private List<AcupointC> mAcupointData;

    public LinkageLeftAdapter(Context context, List<AcupointC> acupointData) {
        mContext = context;
        mAcupointData = acupointData;
    }

    @Override
    public int getCount() {
        return mAcupointData == null ? 0 : mAcupointData.size();
    }

    @Override
    public AcupointC getItem(int position) {
        return mAcupointData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.item_linkage_left);
            holder.tv_index = (TextView) convertView.findViewById(R.id.tv_index);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AcupointC item = getItem(position);
        holder.tv_index.setText(item.Letters);
        return convertView;
    }

    private static class ViewHolder {
        private TextView tv_index;
    }
}
