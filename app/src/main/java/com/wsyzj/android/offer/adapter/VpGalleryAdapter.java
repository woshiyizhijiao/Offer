package com.wsyzj.android.offer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.tools.BaseHttp;
import com.wsyzj.android.offer.tools.UIUtils;

/**
 * @author: wsyzj
 * @date: 2017-06-23 10:10
 * @comment: Gallery
 */
public class VpGalleryAdapter extends PagerAdapter {
    private Context mContext;
    private String[] mImgs;

    public VpGalleryAdapter(Context context, String[] imgs) {
        mContext = context;
        mImgs = imgs;
    }

    @Override
    public int getCount() {
        return mImgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = UIUtils.inflate(R.layout.viewpager_item_gallery);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        container.addView(view);

        BaseHttp.with(mContext, mImgs[position], R.mipmap.ic_launcher, imageView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
