/*
 * File name:  VedioSeriseInfoTable.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月25日
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
 * @Version [版本号, 2016年10月25日]
 */
public class VedioSeriseInfoTable implements BaseColumns
{
    
    public static final int    VEDIOSERISEINFO_INFO = Constant_DB.VEDIOSERISEINFO_FLAG;
    
    public static final String TABLE_NAME           = "vedioSeriseInfoTable";
    
    public static final Uri    CONTENT_URI          =
                                                        Uri.parse("content://" + Constant_DB.AUTHORITY + "/"
                                                            + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID               = "openId";
    
    /**
     * 视频系列id
     */
    public static final String ID_ID                = "id_id";
    
    /**
     * 视频名称
     */
    public static final String NAME                 = "name";
    
    /**
     * 视频系列缩略图
     */
    public static final String IMG                  = "img";
    
    /**
     * 视频系列类型
     */
    public static final String TYPE                 = "type";
    
    /**
     * 视频数量
     */
    public static final String COUNT                = "count";
    
    /**
     * 排序号
     */
    public static final String ORDER_ORDER          = "order_order";
    
    /** 0-未读，1-已读 **/
    public static final String UNREAD               = "unread";
    
    /** 0-未收藏，1-已收藏 **/
    public static final String UNSTORE              = "unstore";
    
    /** 0-未观看，1-观看历史 **/
    public static final String UNHISTORY            = "unhistory";
    
    /** 观看时间 **/
    public static final String WHATCHTIME           = "whatchtime";
    
    public static final String CREATE_TABLE_SQL     = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                                                        + VedioSeriseInfoTable._ID
                                                        + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                        + VedioSeriseInfoTable.OPENID + " TEXT,"
                                                        + VedioSeriseInfoTable.ID_ID + " TEXT,"
                                                        + VedioSeriseInfoTable.NAME + " TEXT,"
                                                        + VedioSeriseInfoTable.IMG + " TEXT,"
                                                        + VedioSeriseInfoTable.TYPE + " TEXT,"
                                                        + VedioSeriseInfoTable.COUNT + " TEXT,"
                                                        + VedioSeriseInfoTable.ORDER_ORDER + " TEXT,"
                                                        + VedioSeriseInfoTable.UNREAD + " TEXT,"
                                                        + VedioSeriseInfoTable.UNSTORE + " TEXT,"
                                                        + VedioSeriseInfoTable.UNHISTORY + " TEXT,"
                                                        + VedioSeriseInfoTable.WHATCHTIME + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL       = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, VEDIOSERISEINFO_INFO);
    }
}
