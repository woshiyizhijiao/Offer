package com.wsyzj.android.offer.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author: wsyzj
 * @date: 2017-03-07 15:17
 * @comment: 数据库操作的类
 * -- primary key 表示为主键的意思 autoincrement 自动递增
 * -- text 文本类型
 * -- blob 二进制类型
 * -- integer 整形
 * -- real 浮点型
 */
public class BaseSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "BOOK";

    private final String NAME = "create table "
            + TABLE_NAME + " ("
            + "id integer primary key autoincrement, "
            + "auther text, "
            + "price real, "
            + "pages integer, "
            + "name text )";

    public BaseSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 数据库只会创建一次
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NAME);
    }

    /**
     * 更新数据库
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 如果存在该表就删除
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
}
