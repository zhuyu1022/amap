/**
 * Author : hoperun
 * Copyright (c) 2011 hoperun.
 * All rights reserved
 */

package com.centit.app.cmipDataUtils.sqlUtils.dbHelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;
import com.centit.app.cmipDataUtils.sqlUtils.Table.AddressInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.AppInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.CardViewTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ChatMessageTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ChatRoomTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.FileInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ModuleTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ShorCutTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.UserInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.VedioSeriseInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.XXZXDETAILInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.XXZXTYPEInfoTable;
import com.centit.core.tools.logManger.LogUtil;

/**
 * Helper class to manipulate moa data base {@hide}
 * 
 * @author mazhicheng
 * @version 1.0
 */
public class MIPDatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = "MIPDatabaseHelper";
    
    /**
     * Constructor
     * 
     * @param context Context
     */
    public MIPDatabaseHelper(Context context)
    {
        // 数据创建在默认的应用程序的位置（/data/data下）不放在/sdcard上
        // super(context, MOA.DATABASE_NAME, null, MOA.DATABASE_VERSION);
        // MOA.SDCARD_PATH + MOA.DATABASE_NAME
        // Constant_Mgr.GETMIP_ROOT_DIR()+
        // context.getApplicationInfo().packageName;
        // TODO
        super(context, Constant_DB.DATABASE_NAME, null, Constant_DB.DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        
        db.execSQL(UserInfoTable.CREATE_TABLE_SQL);
        db.execSQL(ModuleTable.CREATE_TABLE_SQL);
        db.execSQL(AddressInfoTable.CREATE_TABLE_SQL);
        db.execSQL(FileInfoTable.CREATE_TABLE_SQL);
        db.execSQL(ShorCutTable.CREATE_TABLE_SQL);
        db.execSQL(CardViewTable.CREATE_TABLE_SQL);
        db.execSQL(AppInfoTable.CREATE_TABLE_SQL);
        db.execSQL(VedioSeriseInfoTable.CREATE_TABLE_SQL);
        
        db.execSQL(ChatRoomTable.CREATE_TABLE_SQL);
        db.execSQL(ChatMessageTable.CREATE_TABLE_SQL);
        
        db.execSQL(XXZXTYPEInfoTable.CREATE_TABLE_SQL);
        db.execSQL(XXZXDETAILInfoTable.CREATE_TABLE_SQL);
    }
    
    /*
     * 数据库升级时可能用到的SQL语句： 添加字段： alter table 表名 Add column 字段名 字段类型 默认值 AFTER 字段名 (在哪个字段后面添加) 例子： alter table
     * appstore_souapp_app_androidmarket Add column getPriceCurrency varchar(50) default null AFTER getPrice 修改字段： alter
     * table表名 change 字段名 新字段名 字段类型 默认值 例子： alter table appstore_souapp_app_androidmarket change hasPrice hasPrice
     * varchar(10) null; 删除字段： alter table 表名 drop column 字段名 例子： alter table appstore_souapp_app_androidmarket drop
     * column getPriceCurrency 调整字段顺序： alter table 表名 change 字段名 新字段名 字段类型 默认值 after 字段名(跳到哪个字段之后) 例子： alter table
     * appstore_souapp_app_androidmarket change getPriceCurrency getPriceCurrency varchar(50) default null AFTER
     * getPrice
     */
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        
        if (newVersion != Constant_DB.DATABASE_VERSION)
        {
            LogUtil.e("Illegal update request. Got " + oldVersion + ", expected " + Constant_DB.DATABASE_VERSION);
            return;
        }
        else if (oldVersion > newVersion)
        {
            LogUtil.e("Illegal update request: can't downgrade from " + oldVersion + " to " + newVersion
                + ". Did you forget to wipe data?");
            return;
        }
        
        if (oldVersion < 2)
        {
            db.execSQL(XXZXTYPEInfoTable.CREATE_TABLE_SQL);
            db.execSQL(XXZXDETAILInfoTable.CREATE_TABLE_SQL);
        }
        
        if (oldVersion < 3)
        {
            db.execSQL("alter table vedioSeriseInfoTable Add column whatchtime TEXT  default null");
        }
        
        if (oldVersion < 4)
        {
            db.execSQL("alter table moduleInfoTable Add column funicon_l TEXT  default null");
        }
        //
        // if (newVersion == 3) {
        // LogUtil.e(TAG, "Illegal update request: can't downgrade from "
        // + oldVersion + " to " + newVersion
        // + ". Did you forget to wipe data?");
        // db.execSQL("alter table userInfoTable Add column getPriceCurrency TEXT  default null");
        // } else {
        // }
        
        // 欧美版的数据库为22，本版本从23开始升级，如果版本是24（MOA.DATABASE_VERSION=24）
        // 则做如下的处理，使用db.execSQL("*****")来处理数据库升级的问题，示例如下：
        // if(oldVersion < 24)
        // {
        // db.execSQL("alter table appstore_souapp_app_androidmarket Add column getPriceCurrency TEXT  default null AFTER getPrice");
        // //增加一列
        // }
    }
}
