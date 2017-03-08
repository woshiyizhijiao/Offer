package com.wsyzj.android.offer.adapter;

import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wsyzj.android.offer.R;

import java.util.List;

/**
 * @author: wsyzj
 * @date: 2017-03-13 11:06
 * @comment: Lottie动画效果
 */
public class RvLottieAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RvLottieAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        LottieAnimationView lottie_view = helper.getView(R.id.lottie_view);
        lottie_view.setAnimation(item);
        lottie_view.loop(true);
        lottie_view.playAnimation();
    }
}
