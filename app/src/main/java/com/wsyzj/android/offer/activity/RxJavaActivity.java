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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.Observable.create;

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
     * 订阅事件连接了被观察者和观察者
     *
     * @param view
     */
    public void usage1(View view) {
        create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
//                emitter.onError(new NullPointerException());
                emitter.onComplete();   // onError onComplete 只能同时发送一个，且观察者中接收后不再接收事件
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable emitter) {
                LogUtils.e("onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                LogUtils.e("onNext " + value);
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError ");
            }

            @Override
            public void onComplete() {
                LogUtils.e("onComplete");
            }
        });
    }

    /**
     * 线程用法
     *
     * @param v
     */
    public void thread1(View v) {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                LogUtils.e("Observable thread : " + Thread.currentThread().getName());
                LogUtils.e("emitter : 1");
                emitter.onNext(1);
            }
        });

        Consumer consumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) throws Exception {
                LogUtils.e("Consumer thread : " + Thread.currentThread().getName());
                LogUtils.e("onNext : " + integer);
            }
        };

        observable
                .subscribeOn(Schedulers.newThread())        // 指定observable线程，指定多次线程第一次有效
                .observeOn(AndroidSchedulers.mainThread())  // 指定consumer线程，可制定多次线程
                .subscribe(consumer);
    }

    /**
     * 线程用法2
     * Schedulers.io() 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
     * Schedulers.computation() 代表CPU计算密集型的操作, 例如需要大量计算的操作
     * Schedulers.newThread() 代表一个常规的新线程
     * AndroidSchedulers.mainThread() 代表Android的主线程
     *
     * @param v
     */
    public void thread2(View v) {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                LogUtils.e("first Observable thread : " + Thread.currentThread().getName());
                LogUtils.e("first emitter : 1");
                emitter.onNext(1);
            }
        });

        Consumer consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtils.e("first consumer thread : " + Thread.currentThread());
                LogUtils.e("first onNext ：" + integer);
            }
        };

        observable
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {

                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtils.e("sencond consumer thread : " + Thread.currentThread());
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {

                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtils.e("third consumer thread : " + Thread.currentThread());
                    }
                })
                .subscribe(consumer);
    }

    /**
     * 操作符
     *
     * @param v
     */
    public void operatorMap(View v) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {

            @Override
            public String apply(Integer integer) throws Exception {
                return "this is result : " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtils.e(s);
            }
        });
    }

    /**
     * 操作符FlatMap和concatMap的区别:
     * FlatMap 接收的顺序可能不按照上游发送的顺序
     * concatMap 严格按照上游发送的顺序
     */
    public void operatorFlatMap(View v) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int x = 0; x < 3; x++) {
                    list.add("i am vaule : " + integer);
                }
                return Observable.fromIterable(list).delay(100, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtils.e(s);
            }
        });
    }
}
