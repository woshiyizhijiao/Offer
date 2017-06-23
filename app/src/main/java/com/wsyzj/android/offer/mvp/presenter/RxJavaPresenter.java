package com.wsyzj.android.offer.mvp.presenter;

import com.wsyzj.android.offer.model.Gank;
import com.wsyzj.android.offer.mvp.BasePresenter;
import com.wsyzj.android.offer.mvp.contract.RxJavaContract;
import com.wsyzj.android.offer.mvp.model.RxJavaModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * @author: wsyzj
 * @date: 2017-03-19 16:37
 * @comment: RxJava + Mvp
 */
public class RxJavaPresenter extends BasePresenter<RxJavaContract.View, RxJavaContract.Model>
        implements RxJavaContract.Presenter {

    public RxJavaPresenter(RxJavaContract.View view) {
        mView = view;
        mModel = new RxJavaModel();
    }

    @Override
    public void getGank() {
        Subscription subscribe = mModel.getGank()
                .subscribe(new Subscriber<Gank>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Gank gank) {

                    }
                });
        addSubscribe(subscribe);
    }
}
