/*
 * File name:  ChatMessageTable.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月9日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipDataUtils.sqlUtils.Table;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月9日]
 */
public class ChatMessageTable implements BaseColumns
{
    
    public static final int    CHATMESSAGEINFO_INFO = Constant_DB.CHATMESSAGEINFO_FLAG;
    
    public static final String TABLE_NAME           = "ChatMessageTable";
    
    public static final Uri    CONTENT_URI          =
                                                        Uri.parse("content://" + Constant_DB.AUTHORITY + "/"
                                                            + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID               = "openId";
    
    /**
     * 
     */
    public static final String cid                  = "cid";
    
    public static final String mid                  = "mid";
    
    public static final String sender_id            = "sender_id";
    
    public static final String time                 = "time";
    
    public static final String msgtype              = "msgtype";
    
    public static final String content              = "content";
    
    public static final String locationImg          = "locationImg";
    
    public static final String readState            = "readState";
    
    public static final String name                 = "name";
    
    public static final String icon                 = "icon";
    
    public static final String rid                  = "rid";
    
    public static final String image                = "image";
    
    public static final String CREATE_TABLE_SQL     = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                                                        + ChatMessageTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                        + ChatMessageTable.OPENID + " TEXT," + ChatMessageTable.cid
                                                        + " TEXT," + ChatMessageTable.mid + " TEXT,"
                                                        + ChatMessageTable.sender_id + " TEXT," + ChatMessageTable.time
                                                        + " TEXT," + ChatMessageTable.msgtype + " TEXT,"
                                                        + ChatMessageTable.content + " TEXT,"
                                                        + ChatMessageTable.locationImg + " TEXT,"
                                                        + ChatMessageTable.readState + " TEXT," + ChatMessageTable.name
                                                        + " TEXT," + ChatMessageTable.icon + " TEXT,"
                                                        + ChatMessageTable.rid + " TEXT," + ChatMessageTable.image
                                                        + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL       = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, CHATMESSAGEINFO_INFO);
    }
    
}
