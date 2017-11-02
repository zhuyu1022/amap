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
public class UserInfoTable implements BaseColumns
{
    
    public static final int    USERINFO_INFO    = Constant_DB.USERINFO_FLAG;
    
    public static final String TABLE_NAME       = "userInfoTable";
    
    public static final Uri    CONTENT_URI      = Uri.parse("content://" + Constant_DB.AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID           = "openId";
    
    /**
     * 部门
     */
    public static final String DEPTNAME         = "deptName";
    
    /**
     * 更新标识
     */
    public static final String UPDATELOG        = "updatalog";
    
    /**
     * 是否绑定
     */
    public static final String ISBINDREMIND     = "isBindRemind";
    
    /**
     * 最新apkurl路径
     */
    public static final String NEWSAPPATH       = "newapppath";
    
    /**
     * 最新版本号
     */
    public static final String NEWVERSION       = "newversion";
    
    /**
     * 姓名
     */
    public static final String USERNAME         = "userName";
    
    /**
     * 部门ID
     */
    public static final String DEPID            = "deptId";
    
    /**
     * 登录密码(已加密)
     */
    public static final String PASSWORD         = "password";
    
    // 职务
    public static final String POSITION         = "position";
    
    // 头像地址
    public static final String LEADERIMAGE      = "leaderimage";
    
    // 层级
    public static final String PFLAG            = "positionflag";
    
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + UserInfoTable._ID
                                                    + " INTEGER PRIMARY KEY AUTOINCREMENT," + UserInfoTable.OPENID
                                                    + " TEXT," + UserInfoTable.DEPTNAME + " TEXT,"
                                                    + UserInfoTable.UPDATELOG + " TEXT," + UserInfoTable.ISBINDREMIND
                                                    + " TEXT," + UserInfoTable.NEWSAPPATH + " TEXT,"
                                                    + UserInfoTable.NEWVERSION + " TEXT," + UserInfoTable.USERNAME
                                                    + " TEXT," + UserInfoTable.DEPID + " TEXT,"
                                                    + UserInfoTable.POSITION + " TEXT," + UserInfoTable.LEADERIMAGE
                                                    + " TEXT," + UserInfoTable.PFLAG + " TEXT,"
                                                    + UserInfoTable.PASSWORD + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL   = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, USERINFO_INFO);
    }
}
