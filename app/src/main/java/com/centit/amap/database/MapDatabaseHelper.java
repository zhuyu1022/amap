package com.centit.amap.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhu_yu on 2017/10/10.
 */

public class MapDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_TABLE= "create table location(" +
            "id integer primary key autoincrement," +
            "time text," +
            "lat real," +
            "lon real," +
            "address text," +
            "userid text)";

    public MapDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建数据库
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    /**
     * 更新数据库
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exits location");
        onCreate(sqLiteDatabase);
    }


}
