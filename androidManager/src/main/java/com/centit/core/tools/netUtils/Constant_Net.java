/*
 * File name:  MIPConstState.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-10-17
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils;


/**
 * 工程核心包中定义的常量
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class Constant_Net
{
    // ===============网络处理时定义的常量==============================
    /**
     * WebService连接超时时间
     */
    public static final int    WS_CONNECTION_TIMEOUT     = 30000;
    
    /**
     * SOCKET连接超时时间
     */
    public static final int    SOCKET_CONNECTION_TIMEOUT = 30000;
    
    /**
     * HTTP连接超时时间
     */
    public static final int    HTTP_CONNECTION_TIMEOUT   = 30000;
    
    /**
     * HTTP读取超时时间
     */
    public static final int    HTTP_SO_TIMEOUT           = 30000;
    
    /**
     * HTTP获取连接的最大等待时间
     */
    public static final int    HTTP_TIMEOUT              = 60000;
    
    /**
     * HTTPs
     */
    public static final String HTTP_SCHEME_HTTPS_NAME    = "https";
    
    /**
     * HTTP
     */
    public static final String HTTP_SCHEME_HTTP_NAME     = "http";
    
    /**
     * HTTPS端口
     */
    public static final int    HTTP_SCHEME_HTTPS_PORT    = 443;
    
    /**
     * HTTP端口
     */
    public static final int    HTTP_SCHEME_HTTP_PORT     = 80;
    
    /** 网络连接失败后，重连次数 */
    public static final int    TRY_AGAIN_COUNT           = 1;
    
    /** 网络连接失败后，重连间隔 */
    public static final int    TRY_AGAIN_TIME            = 1000;
    
    // ===============网络返回状态==============================
    /** 网络成功返回 */
    public static final int    SUCCESS                   = 1001;
    
    /** 没有网络 */
    public static final int    NO_NET                    = 1002;
    
    /** 网络超时异常 */
    public static final int    TIME_OUT_ERROR            = 1003;
    
    /**
     * 取消请求
     */
    public static final int    CANCEL_REQUEST            = 1004;
    
    /**
     * 连接时返回code错误
     */
    public static final int    RETCODEERROR              = 1005;
    
    // ===============网络请求时需要封装的参数==============================
    
    /**
     * 请求参数URL 标识
     */
    public static String       URL                       = "URL";
    
    /**
     * 请求参数String类型 标识
     */
    public static String       BODYPARAM                 = "BODYPARAM";
    
    /**
     * 参数是map类型型
     */
    public static String       BODYMAPPARM               = "MAPPARAM";
    
    /**
     * 发送的文件 标识
     */
    public static String       FILES                     = "FILES";
}
