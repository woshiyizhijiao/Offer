package com.wsyzj.android.offer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.AcupointB;
import com.wsyzj.android.offer.tools.UIUtils;

import java.util.List;

/**
 * author : 焦洋
 * time   : 2017/11/6  17:00
 * desc   : LinkageRihgtChildAdapter
 */
public class LinkageRihgtChildAdapter extends BaseAdapter {

    private Context mContext;
    private List<AcupointB.TBean.ContentBean> mDatas;

    public LinkageRihgtChildAdapter(Context context, List<AcupointB.TBean.ContentBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public AcupointB.TBean.ContentBean getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.item_linkage_right_child);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AcupointB.TBean.ContentBean item = getItem(position);
        holder.tv_name.setText(item.Title);
        return convertView;
    }

    private static class ViewHolder {
        private TextView tv_name;
    }
}
