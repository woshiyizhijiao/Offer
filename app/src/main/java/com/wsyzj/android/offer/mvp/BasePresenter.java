package com.wsyzj.android.offer.mvp;


import org.reactivestreams.Subscription;

/**
 * @author: wsyzj
 * @date: 2017-03-18 10:07
 * @comment: MVP模式的指挥者(连接View和Model)
 */
public class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V> {

    protected V mView;
    protected M mModel;
//    private CompositeSubscription mSubscription;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    /**
     * 添加订阅
     *
     * @param subscription
     */
    protected void addSubscribe(Subscription subscription) {
//        if (mSubscription == null) {
//            mSubscription = new CompositeSubscription();
//        }
//        mSubscription.add(subscription);
    }

    /**
     * 取消订阅
     */
    public void unSubscribe() {
//        if (mSubscription != null && mSubscription.hasSubscriptions()) {
//            mSubscription.clear();
//            mSubscription = null;
//        }
    }
}
