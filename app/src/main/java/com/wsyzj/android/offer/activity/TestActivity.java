package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.PacewearBridge;

/**
 * @author: wsyzj
 * @date: 2017-05-09 13:14
 * @comment: //TODO
 */
public class TestActivity extends AppCompatActivity {


    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://xiazaihai.cs0309.html5.qq.com/demo_routine");

        mWebView.addJavascriptInterface(new PacewearBridge(this), "PacewearBridge");
    }

    public void js(View view) {
        mWebView.loadUrl("javascript:anzhuo()");
    }
}
