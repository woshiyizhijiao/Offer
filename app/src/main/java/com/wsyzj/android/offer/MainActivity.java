package com.wsyzj.android.offer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wsyzj.android.offer.activity.CustomViewAct;
import com.wsyzj.android.offer.activity.LottieAct;

import java.util.Arrays;

/**
 * 1: 快捷键
 * -- 想要预览TextView有值时的效果 添加自定义命名空间:xmlns:tools="http://schemas.android.com/tools"
 * --- tools:text="输入模拟的文本"(运行时不会出现)
 * -- 快捷生成布局文件中的@string @dimen     alt+enter → Extract String/Dimension Resource
 * -- 关闭菜单栏中的其他文件，保存当前文件    alt(鼠标点击当前文件的关闭标志)
 * -- 查看当前类继承关系和所有的复写方法      ctrl+o
 * -- 当前文件以单独的一个窗口打开           shift+f4
 * -- 自动生成匹配正则表达式                 alt+enter → check regexp
 * -- 快速切换文件                          ctrl+tab
 * 2:  SVN
 * -- 忽略文件设置 File → Setting → Ignored Files
 * --- Directory:.gradle/ && Directory:.idea/ && Directory:build/ && Directory: app/build/ && File:local.properties && Mask:*.iml
 * -- 解除项目与SVN关联
 * --- 1: .idea文件夹找到vcs.xml → vcs="svn"改为vcs=""保存
 * --- 2: 把项目根目录.svn文件夹删除
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView list_view;
    private String[] mDatas = new String[]{"Lottie", "自定义View学习"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = (ListView) findViewById(R.id.list_view);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(mDatas));
        list_view.setAdapter(arrayAdapter);
        list_view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startAct(LottieAct.class);
                break;
            case 1:
                startAct(CustomViewAct.class);
                break;
        }
    }

    private void startAct(Class clas) {
        startActivity(new Intent(this, clas));
    }
}
