package com.wsyzj.android.offer.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.tools.ImageTools;
import com.wsyzj.android.offer.widget.ImageTextSortView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wsyzj
 * @date: 2017-02-18 13:45
 * @comment: 图文混排
 */
public class ImageTextSortAct extends AppCompatActivity {

    private ImageTextSortView imagetext_sort;
    private List<String> contents = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_image_text_sort);
        Bitmap bitmap = ImageTools.drawableToBitmap(getResources().getDrawable(R.mipmap.ic_launcher));
        initView();
    }

    private void initView() {
        contents.add("手里的解放啦就是对方了解啊大厦附近的撒解放了" + "\n");
        contents.add("手里的解放啦就是对方了解啊大厦附近的撒解放了");
        contents.add("手里的解放啦就是对方了解啊大厦附近的撒解放了");
        contents.add("手里的解放啦就是对方了解啊大厦附近的撒解放了");
        imagetext_sort = (ImageTextSortView) findViewById(R.id.imagetext_sort);
        imagetext_sort.setContent(contents);
    }

    /**
     * 添加图片
     */
    public void addPhoto(View view) {
        contents.add(ImageTextSortView.mBitmapTag + "/storage/emulated/0/ic_launcher.png");
    }
}
