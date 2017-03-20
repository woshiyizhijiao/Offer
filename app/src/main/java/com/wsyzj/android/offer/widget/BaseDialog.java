package com.wsyzj.android.offer.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.KeyEvent;

/**
 * @author: wsyzj
 * @date: 2017-03-20 21:09
 * @comment: 使用全局统一的dialog方便管理
 */
public class BaseDialog extends ProgressDialog {

    public BaseDialog(Context context) {
        super(context);
        init();
    }

    private void init() {
        setCanceledOnTouchOutside(true);
        setCancelable(false);
        setMessage("请稍候...");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (BaseDialog.this.isShowing())
                    BaseDialog.this.dismiss();
                break;
        }
        return true;
    }
}