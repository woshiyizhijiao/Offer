package com.wsyzj.android.offer.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @date: 2017-02-18 13:59
 * @url: http://blog.csdn.net/gaoshouxiaodi/article/details/50519344
 * @comment: 图文混排
 */
public class ImageTextSortView extends EditText {
    private Context mContext;
    private List<String> mContents;

    public static final String mBitmapTag = "☆";
    private String mNewLineTag = "\n";

    public ImageTextSortView(Context context) {
        super(context);
        init(context);
    }

    public ImageTextSortView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageTextSortView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mContents = getContents();
        insertData();
    }

    /**
     * 插入数据
     */
    private void insertData() {
        if (mContents.size() > 0) {
            for (String str : mContents) {
                if (str.indexOf(mBitmapTag) != -1) {  // 判断是否用图片的地址
                    String path = str.replace(mBitmapTag, ""); // 还原图片的地址
                    Bitmap bitmap = getSmallBitmap(path, 720, 1280);
                    // 插入图片
                    insertBitmap(path, bitmap);
                } else {
                    // 输入文字
                    SpannableString ss = new SpannableString(str);
                    append(ss);
                }
            }
        }
    }

    /**
     * 插入图片
     *
     * @param path
     * @param bitmap
     */
    private SpannableString insertBitmap(String path, Bitmap bitmap) {
        Editable edit_text = getEditableText();
        int index = getSelectionStart();    // 获取光标所在位置
        // 插入换行符，使图片单独占一行(插入图片前换行)
        SpannableString newLine = new SpannableString("\n");
        edit_text.insert(index, newLine);
        // 创建一个SpannableString对象，以便插入用ImageSpan对象封装的图像
        path = mBitmapTag + path + mBitmapTag;
        SpannableString spannableString = new SpannableString(path);
        // 根据Bitmap对象创建ImageSpan对象
        ImageSpan imageSpan = new ImageSpan(mContext, bitmap);
        // 用ImageSpan对象替换你指定的字符串
        spannableString.setSpan(imageSpan, 0, path.length(), spannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 将选择的图片追加到EditText中光标所在位置
        if (index < 0 || index >= edit_text.length()) {
            edit_text.append(spannableString);
        } else {
            edit_text.insert(index, newLine);//插入图片后换行
        }
        return spannableString;
    }

    /**
     * 插入图片
     *
     * @param path
     */
    public void insertBitmap(String path) {
        Bitmap bitmap = getSmallBitmap(path, 480, 800);
        insertBitmap(path, bitmap);
    }

    /**
     * 设置显示的内容集合
     */
    public void setContent(List<String> contents) {
        if (mContents == null) {
            mContents = new ArrayList<>();
        }
        mContents.clear();
        mContents.addAll(contents);
        insertData();
    }

    /**
     * 用集合的形式获取里面的内容
     */
    private List<String> getContents() {
        if (mContents == null) {
            mContents = new ArrayList<>();
        }
        String content = getText().toString().replace(mNewLineTag, "");
        if (content.length() > 0 && content.contains(mBitmapTag)) {
            String[] split = content.split(mBitmapTag);
            mContents.clear();
            for (String str : split) {
                mContents.add(str);
            }
        } else {
            mContents.add(content);
        }
        return mContents;
    }

    /**
     * 根据图片获得图片并压缩，返回bitmap用于显示
     *
     * @return
     */
    public Bitmap getSmallBitmap(String filePath, int reqwidht, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqwidht, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int w_width = dm.widthPixels;
        int b_width = bitmap.getWidth();
        int b_height = bitmap.getHeight();
        int w_height = w_width * b_height / b_width;
        bitmap = Bitmap.createScaledBitmap(bitmap, w_width, w_height, false);
        return bitmap;
    }

    /**
     * 计算图片的缩放值
     *
     * @return
     */
    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;

        if (width > reqWidth || height > reqHeight) {
            int widthRatio = Math.round((float) width / (float) reqWidth);
            int heightRatio = Math.round((float) height / (float) reqHeight);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    float oldY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldY = event.getY();
                requestFocus();
                break;
            case MotionEvent.ACTION_MOVE:
                float newY = event.getY();
                if (Math.abs(oldY - newY) > 20) {
                    clearFocus();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
