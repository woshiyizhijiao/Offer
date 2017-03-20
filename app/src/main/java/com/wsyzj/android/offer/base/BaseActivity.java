package com.wsyzj.android.offer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wsyzj.android.offer.mvp.BasePresenter;
import com.wsyzj.android.offer.mvp.IView;
import com.wsyzj.android.offer.widget.BaseTitleView;

/**
 * @author: wsyzj
 * @date: 2017-03-18 10:06
 * @comment: 所有Activity的基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {

    private P mPresenter;
    public BaseTitleView baseTitleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
        layout();
        initViews();
        initDatas(savedInstanceState);
    }

    /**
     * 设置统一的标题布局
     */
    private void layout() {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();

        LinearLayout parentView = new LinearLayout(this);
        parentView.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(parentView);

        // 统一的标题布局
        baseTitleView = new BaseTitleView(this);
        LinearLayout.LayoutParams title_lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        parentView.addView(baseTitleView, title_lp);

        // 填充内容布局
        View contentView = View.inflate(this, contentView(), null);
        LinearLayout.LayoutParams contetnView_lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        parentView.addView(contentView, contetnView_lp);
    }

    /**
     * MVP模式的Presenter
     */
    private void createPresenter() {
        mPresenter = presenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.unSubscribe();
        }
    }

    protected abstract P presenter();

    protected abstract int contentView();                               // 创建布局

    protected abstract void initViews();                                // 初始化控件

    protected abstract void initDatas(Bundle savedInstanceState);       // 初始化数据

}
