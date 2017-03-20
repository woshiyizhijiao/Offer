package com.wsyzj.android.offer.http;

import com.wsyzj.android.offer.model.Gank;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author: wsyzj
 * @date: 2017-03-19 18:32
 * @comment: Retrofit的接口
 */
public interface ApiSerVice {

    String BASE_URL = "http://gank.io/";

    @GET("api/data/Android/10/{page}")
    Observable<Gank> getGank(@Path("page") String page);

}
