package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.tools.LogUtils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 焦洋
 * @date 2018/2/2 17:07
 * @Description: $desc$
 */
public class FileOperationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_operation);
    }

    /**
     * 将一些文字存储到硬盘一个文件中。
     *
     * @param view
     */
    public void redFile(View view) {
        try {
            FileWriter writer = new FileWriter("test_offer", true);
            writer.write("我是一只焦");
            writer.close();
        } catch (IOException e) {
            LogUtils.e("有没有走异常的");
            e.printStackTrace();
        }
    }
}
