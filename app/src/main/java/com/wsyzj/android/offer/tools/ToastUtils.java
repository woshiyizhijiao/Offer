package com.wsyzj.android.offer.tools;

import android.widget.Toast;

import com.wsyzj.android.offer.BaseApp;


/**
 * 吐司
 */
public class ToastUtils {

    public static Toast mToast;

    /**
     * @param msg
     */
    public static void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApp.getBaseApp(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
