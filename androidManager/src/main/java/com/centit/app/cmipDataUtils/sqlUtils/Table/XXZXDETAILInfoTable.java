/**
 * Author : Agero
 * Copyright (c) 2011 Agero.
 * All rights reserved
 */

package com.centit.app.cmipDataUtils.sqlUtils.Table;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;

/**
 * 
 * 
 * @author shen_feng
 * @version 1.0
 * @createDate 2013-3-13
 */
public class XXZXDETAILInfoTable implements BaseColumns
{
    
    public static final int    XXZXDETAIL_INFO  = Constant_DB.XXZXDETAIL_FLAG;
    
    public static final String TABLE_NAME       = "xxzxdetailInfoTable";
    
    public static final Uri    CONTENT_URI      = Uri.parse("content://" + Constant_DB.AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID           = "openId";
    
    public static final String SORTCODE         = "sortCode";                                                        // 分类编号
                                                                                                                      
    // private String ; // 消息编号
    //
    // private String ; // 消息标题
    //
    // private String ; // 消息内容
    //
    // private String ; // 接收时间
    //
    // private String ; // 未读标示
    //
    // private String ; // 功能实例Id
    //
    // private String ;
    
    public static final String MSGID            = "msgId";                                                           // 消息编号
                                                                                                                      
    public static final String MSGTITLE         = "msgTitle";                                                        // 消息标题
                                                                                                                      
    public static final String MSGCONTENT       = "msgContent";                                                      // 消息内容
                                                                                                                      
    public static final String RECEIVETIME      = "receiveTime";                                                     // 接收时间
                                                                                                                      
    public static final String READSTATUS       = "readStatus";                                                      // 未读标示
                                                                                                                      
    public static final String INSID            = "insid";                                                           // 功能实例Id
                                                                                                                      
    public static final String ACCEURL          = "acceurl";                                                         // 对应附件url
                                                                                                                      
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                                                    + XXZXDETAILInfoTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + XXZXDETAILInfoTable.OPENID + " TEXT,"
                                                    + XXZXDETAILInfoTable.SORTCODE + " TEXT,"
                                                    + XXZXDETAILInfoTable.MSGID + " TEXT,"
                                                    + XXZXDETAILInfoTable.MSGTITLE + " TEXT,"
                                                    + XXZXDETAILInfoTable.MSGCONTENT + " TEXT,"
                                                    + XXZXDETAILInfoTable.RECEIVETIME + " TEXT,"
                                                    + XXZXDETAILInfoTable.READSTATUS + " TEXT,"
                                                    + XXZXDETAILInfoTable.INSID + " TEXT,"
                                                    + XXZXDETAILInfoTable.ACCEURL + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL   = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, XXZXDETAIL_INFO);
    }
}
