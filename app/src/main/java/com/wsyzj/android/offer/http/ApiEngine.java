package com.wsyzj.android.offer.http;

import com.wsyzj.android.offer.BaseApp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: wsyzj
 * @date: 2017-03-19 18:28
 * @comment: 封装的网络请求
 */
public class ApiEngine {
    private int TIME_OUT = 15;

    private volatile static ApiEngine apiEngine;
    private Retrofit retrofit;

    private ApiEngine() {
        // 日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 缓存
        int size = 1024 * 1024 * 100;
        File cacheFile = new File(BaseApp.getBaseApp().getCacheDir(), "OfferHttpCache");
        Cache cache = new Cache(cacheFile, size);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
//                .addNetworkInterceptor()
//                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiSerVice.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 获取网络请求的单利
     *
     * @return
     */
    public static ApiEngine getInstance() {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine();
                }
            }
        }
        return apiEngine;
    }

    /**
     * 获取RetrofitApi列表对象
     *
     * @return
     */
    public ApiSerVice getApiService() {
        return retrofit.create(ApiSerVice.class);
    }

}
