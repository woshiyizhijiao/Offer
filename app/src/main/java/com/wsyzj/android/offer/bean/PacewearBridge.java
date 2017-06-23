package com.wsyzj.android.offer.bean;

import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * @author: wsyzj
 * @date: 2017-05-09 13:19
 * @comment: //TODO
 */
public class PacewearBridge {

    private Context mContext;

    public PacewearBridge(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    private void onJsLoaded() {
        new Handler(mContext.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, "onJsLoaded", 0).show();
            }
        });
    }
}
