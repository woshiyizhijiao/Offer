package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.adapter.VpGalleryAdapter;
import com.wsyzj.android.offer.widget.ZoomOutPageTransformer;

/**
 * @author: wsyzj
 * @date: 2017-05-20 13:26
 * @comment: ViewPager画廊效果
 */
public class ViewPagerGalleryActivity extends AppCompatActivity {
    private final String[] mImgs = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495268693998&di=e2e56e5b4a8b191d433fa5550d7834b7&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201207%2F03%2F20120703173916_VuQid.thumb.700_0.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495268693998&di=355b269bd51ac31f71f43ddf55dc0308&imgtype=0&src=http%3A%2F%2Fr002.joyme.com%2Fr002%2Fimage%2F2013%2F02%2F3%2F80ADF189D89F62FC38D002B9C3FD29F8.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495268694005&di=f37fe4d99d47e12f80b39f6665029599&imgtype=0&src=http%3A%2F%2Fimg.bimg.126.net%2Fphoto%2FinzIK9gKkbjEvV3N80H7Vw%3D%3D%2F5774177672243494136.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495268694004&di=d032177a927fcfe51b63e03c87b57be2&imgtype=0&src=http%3A%2F%2Fi3.hoopchina.com.cn%2Fblogfile%2F201210%2F09%2F134976807334664.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495268694001&di=26d33ad8f790ee2822f51055dbb5e8f1&imgtype=0&src=http%3A%2F%2Ff6.topitme.com%2F6%2Ff8%2Fd2%2F1159659445321d2f86o.jpg",
    };
    private ViewPager viewPager;
    private VpGalleryAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_viewpager_gallery);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        mAdapter = new VpGalleryAdapter(this, mImgs);
        viewPager.setAdapter(mAdapter);
        viewPager.setPageTransformer(false, new ZoomOutPageTransformer());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(20);
    }

}
