package com.wsyzj.android.offer.mvp.contract;

import com.wsyzj.android.offer.mvp.IModel;
import com.wsyzj.android.offer.mvp.IPresenter;
import com.wsyzj.android.offer.mvp.IView;

/**
 * @author: wsyzj
 * @date: 2017-03-19 16:31
 * @comment: RxJava + Mvp
 */
public class RxJavaContract {

    public interface View extends IView {
        void showDialog();

        void hideDialog();
    }

    public interface Model extends IModel {
//        Observable<Gank> getGank();
    }

    public interface Presenter extends IPresenter<View> {
        void getGank();
    }
}
