/*
 * File name:  ChrtRoomTable.java
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
public class ChatRoomTable implements BaseColumns
{
    
    public static final int    CHATROOMINFO_INFO = Constant_DB.CHATROOMINFO_FLAG;
    
    public static final String TABLE_NAME        = "ChatRoomTable";
    
    public static final Uri    CONTENT_URI       = Uri.parse("content://" + Constant_DB.AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID            = "openId";
    
    /**
     * 
     */
    public static final String cid               = "cid";
    
    /**
     * 会话更新时间（发回比较是否更新）
     */
    public static final String time              = "time";
    
    /**
     * 人员更新时间
     */
    public static final String mtime             = "mtime";
    
    /**
     * 会话名称
     */
    public static final String cname             = "cname";
    
    /**
     * 消息数目
     */
    public static final String cnt               = "cnt";
    
    /**
     *
     */
    public static final String user_list         = "user_list";
    
    /** 最近消息时间 **/
    public static final String latest_time       = "latest_time";
    
    /** 消息内容 **/
    public static final String msg               = "msg";
    
    /** 1单聊，2群聊 **/
    public static final String type              = "type";
    
    /** 回话消息最大id **/
    public static final String maxid             = "maxid";
    
    /** 用于保存上一次消息数 **/
    public static final String cnt_old           = "cnt_old";
    
    public static final String CREATE_TABLE_SQL  = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ChatRoomTable._ID
                                                     + " INTEGER PRIMARY KEY AUTOINCREMENT," + ChatRoomTable.OPENID
                                                     + " TEXT," + ChatRoomTable.cid + " TEXT," + ChatRoomTable.time
                                                     + " TEXT," + ChatRoomTable.mtime + " TEXT," + ChatRoomTable.cname
                                                     + " TEXT," + ChatRoomTable.cnt + " TEXT,"
                                                     + ChatRoomTable.user_list + " TEXT," + ChatRoomTable.latest_time
                                                     + " TEXT," + ChatRoomTable.msg + " TEXT," + ChatRoomTable.type
                                                     + " TEXT," + ChatRoomTable.maxid + " TEXT,"
                                                     + ChatRoomTable.cnt_old + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL    = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, CHATROOMINFO_INFO);
    }
    
}
