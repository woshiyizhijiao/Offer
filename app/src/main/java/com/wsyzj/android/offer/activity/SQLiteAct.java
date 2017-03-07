package com.wsyzj.android.offer.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.socks.library.KLog;
import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.sqlite.BaseSQLiteOpenHelper;

/**
 * @author: wsyzj
 * @date: 2017-03-07 15:09
 * @comment: 数据库的相关操作
 */
public class SQLiteAct extends AppCompatActivity {

    private BaseSQLiteOpenHelper mSQLiteHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sqlite);

        mSQLiteHelper = new BaseSQLiteOpenHelper(this, "BookStore.db", null, 3);
    }

    /**
     * 增
     * auther
     * price
     * pages
     * name
     *
     * @param view
     */
    public void insert(View view) {
        SQLiteDatabase db = mSQLiteHelper.getWritableDatabase();
        // SQLite语法
        db.execSQL("insert into " + BaseSQLiteOpenHelper.TABLE_NAME + " (auther, price, pages, name) values(?, ?, ?, ?)",
                new String[]{"我是一只焦", "100.00", "100", "我是一本书"});

        ContentValues values = new ContentValues();
        values.put("auther", "东野圭吾");
        values.put("price", 36.0);
        values.put("pages", 500);
        values.put("name", "白夜行");
        db.insert(BaseSQLiteOpenHelper.TABLE_NAME, null, values);
        values.clear();

        values.put("auther", "白岩松");
        values.put("price", 36.0);
        values.put("pages", 1000);
        values.put("name", "白说");
        db.insert(BaseSQLiteOpenHelper.TABLE_NAME, null, values);
    }

    /**
     * 删
     *
     * @param view
     */
    public void delete(View view) {
        SQLiteDatabase db = mSQLiteHelper.getWritableDatabase();

        db.execSQL("delete from " + BaseSQLiteOpenHelper.TABLE_NAME + " where pages = ?", new String[]{"100"});

        db.delete(BaseSQLiteOpenHelper.TABLE_NAME, "pages > ?", new String[]{"600"});
    }

    /**
     * 改
     *
     * @param view
     */
    public void update(View view) {
        SQLiteDatabase db = mSQLiteHelper.getWritableDatabase();

        db.execSQL("update " + BaseSQLiteOpenHelper.TABLE_NAME + " set price = ? where = name ?",
                new String[]{"100.00", "我是一本书"});

        ContentValues values = new ContentValues();
        values.put("price", 36.0);
        db.update(BaseSQLiteOpenHelper.TABLE_NAME, values, "price = ?", new String[]{"500"});
    }

    /**
     * 查
     *
     * @param view
     */
    public void query(View view) {
        SQLiteDatabase db = mSQLiteHelper.getReadableDatabase();

//         db.rawQuery("select * from " + BaseSQLiteOpenHelper.TABLE_NAME, null);

        Cursor cursor = db.query(BaseSQLiteOpenHelper.TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String auther = cursor.getString(cursor.getColumnIndex("auther"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                KLog.e("作者: " + auther + " 书名: " + name + " 价格: " + price + " 页数: " + pages);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
