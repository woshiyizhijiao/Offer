package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.view.View;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.base.BaseActivity;
import com.wsyzj.android.offer.mvp.BasePresenter;
import com.wsyzj.android.offer.mvp.contract.RxJavaContract;
import com.wsyzj.android.offer.mvp.presenter.RxJavaPresenter;
import com.wsyzj.android.offer.tools.LogUtils;
import com.wsyzj.android.offer.widget.BaseDialog;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: wsyzj
 * @date: 2017-03-09 12:40
 * @comment: RxJava的学习
 * 1:RxJava:Observable(被观察者)，Observer(观察者) subscribe(订阅) subscribe将被观察者和观察者关联
 */
public class RxJavaActivity extends BaseActivity implements RxJavaContract.View {

    private RxJavaPresenter mPresenter;
    private BaseDialog mBaseDialog;

    @Override
    protected BasePresenter presenter() {
        mPresenter = new RxJavaPresenter(this);
        return mPresenter;
    }

    @Override
    protected int contentView() {
        return R.layout.activity_rxjava;
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

    /**
     * @param view
     */
    public void usage1(View view) {
        // 创建一个被观察者
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        });
        // 创建一个观察者
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                LogUtils.e("onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                LogUtils.e("onNext " + value);
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError");
            }

            @Override
            public void onComplete() {
                LogUtils.e("onComplete");
            }
        };
        observable.subscribe(observer);
    }
}
