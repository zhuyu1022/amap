/*
 * File name:  MessageIdConstants.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-10-17
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipDataUtils.sqlUtils;

/**
 * 业务中返回的报文
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class Constant_DB
{
    /**
     * 未识别的URL
     */
    public static final String CONTENTPROVIDER_UNRECOGNIZED_URI = "Unrecognized URI:";
    
    /**
     * 错误URL
     */
    public static final String CONTENTPROVIDER_UNKNOW_URI       = "Unknow URI:";
    
    /**
     * 插入错误
     */
    public static final String CONTENTPROVIDER_FAILED_INSERT    = "Failed to insert row into ";
    
    /**
     * 数据库名称
     */
    public static final String DATABASE_NAME                    = "mip.db";
    
    /**
     * 数据库版本
     */
    public static final int    DATABASE_VERSION                 = 4;
    
    /**
     * 数据操作时对应的authority
     */
    public static final String AUTHORITY                        = "centit.JTTDMIPDBProvider";
    
    // multiple records
    public static final String CONTENT_TYPE                     = "vnd.android.cursor.dir/vnd.hoperun.vpnconfiguration";
    
    // 各个数据库标识
    /**
     * userInfo 表的标识
     */
    public static final int    USERINFO_FLAG                    = 1;
    
    /**
     * 用户权限表的标识
     */
    public static final int    MODULE_FLAG                      = 2;
    
    /**
     * 快捷方式
     */
    public static final int    SHORTCUT_FLAG                    = 3;
    
    /**
     * 文件
     */
    public static final int    FILEINFO_FLAG                    = 4;
    
    /**
     * 存储通讯录数据库
     */
    public static final int    ADDRESSINFO_FLAG                 = 5;
    
    /**
     * 首页cardview的表单
     */
    public static final int    CARDVIEW_FLAG                    = 6;
    
    /**
     * 应用商店的应用
     */
    public static final int    APPINFO_FLAG                     = 7;
    
    /**
     * 视频分类
     */
    public static final int    VEDIOSERISEINFO_FLAG             = 8;
    
    /**
     * 在线聊天room
     */
    public static final int    CHATROOMINFO_FLAG                = 9;
    
    /**
     * 在线聊天message
     */
    public static final int    CHATMESSAGEINFO_FLAG             = 10;
    
    // 消息中心TYPE分类
    public static final int    XXZXTYPE_FLAG                    = 11;
    
    // 消息中心详细列表
    public static final int    XXZXDETAIL_FLAG                  = 12;
}
