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
public class XXZXTYPEInfoTable implements BaseColumns
{
    
    public static final int    XXZXTYPE_INFO    = Constant_DB.XXZXTYPE_FLAG;
    
    public static final String TABLE_NAME       = "xxzxtypeInfoTable";
    
    public static final Uri    CONTENT_URI      = Uri.parse("content://" + Constant_DB.AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID           = "openId";
    
    public static final String SORTCODE         = "sortCode";                                                        // 分类编号
                                                                                                                      
    public static final String SORTNAME         = "sortName";                                                        // 分类名称
                                                                                                                      
    public static final String SORTICON         = "sortIcon";                                                        // 功能icon图标
                                                                                                                      
    public static final String TITLE            = "title";                                                           // 消息标题
                                                                                                                      
    public static final String RECEIVETIME      = "receiveTime";                                                     // 最新接收时间
                                                                                                                      
    public static final String COUNT            = "count";                                                            // 未读数
                                                                                                                      
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                                                    + XXZXTYPEInfoTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + XXZXTYPEInfoTable.OPENID + " TEXT," + XXZXTYPEInfoTable.SORTCODE
                                                    + " TEXT," + XXZXTYPEInfoTable.SORTNAME + " TEXT,"
                                                    + XXZXTYPEInfoTable.SORTICON + " TEXT," + XXZXTYPEInfoTable.TITLE
                                                    + " TEXT," + XXZXTYPEInfoTable.RECEIVETIME + " TEXT,"
                                                    + XXZXTYPEInfoTable.COUNT + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL   = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, XXZXTYPE_INFO);
    }
}
