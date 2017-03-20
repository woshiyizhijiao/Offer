package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.base.BaseActivity;
import com.wsyzj.android.offer.mvp.BasePresenter;
import com.wsyzj.android.offer.mvp.contract.RxJavaContract;
import com.wsyzj.android.offer.mvp.presenter.RxJavaPresenter;
import com.wsyzj.android.offer.widget.BaseDialog;

/**
 * @author: wsyzj
 * @date: 2017-03-09 12:40
 * @comment: RxJava的学习
 */
public class RxJavaAct extends BaseActivity implements RxJavaContract.View {

    private RxJavaPresenter mPresenter;
    private BaseDialog mBaseDialog;

    @Override
    protected BasePresenter presenter() {
        mPresenter = new RxJavaPresenter(this);
        return mPresenter;
    }

    @Override
    protected int contentView() {
        return R.layout.act_rxjava;
    }

    @Override
    protected void initViews() {
        baseTitleView.setTitle("RxJava");
    }

    @Override
    protected void initDatas(Bundle savedInstanceState) {

    }

    @Override
    public void showDialog() {
        if (mBaseDialog == null) {
            mBaseDialog = new BaseDialog(this);
        }
        mBaseDialog.show();
    }

    @Override
    public void hideDialog() {
        if (mBaseDialog != null && mBaseDialog.isShowing())
            mBaseDialog.dismiss();
    }

    /**
     * 请求网络
     *
     * @param view
     */
    public void netClick(View view) {
        mPresenter.getGank();
    }
}
