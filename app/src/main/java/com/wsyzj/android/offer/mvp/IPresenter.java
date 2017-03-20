package com.wsyzj.android.offer.mvp;

/**
 * @author: wsyzj
 * @date: 2017-03-19 17:08
 * @comment: MVP
 */
public interface IPresenter<V extends IView> {

    void attachView(V view);

    void detachView();
}

