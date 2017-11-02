/*
\ * File name:  ConstState.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  框架中使用到的常量定义
 * Author:  Midnight
 * Last modified date:  2013-8-22
 * Version:  1.0
 * Edit history:  1.新建  -Midnight 2013-8-22
 */
package com.centit.app.cmipConstant;

import com.centit.GlobalState;
import com.centit.core.tools.utils.MIP_DeviceInfoUtils;
import com.centit.core.tools.utils.OsUtils;

/**
 * 常量定义
 * 
 * @Description 框架中使用到的常量定义
 * 
 * @author Midnight
 * @Version [1.0, 2013-8-22]
 */
public class Constant_Mgr
{
    public static final String App_xfid                 = "53a149f7";
    
    public static final String AppType                  = "zhyy";
    
    // ===============URL 定义==============================
    /**
     * 使用URL的默认地址
     */
    // public static String mConIP = "192.168.137.9";
    
    // public static String mConIP = "192.168.137.205";
    
    // public static String mConIP = "222.190.119.86";
    
    // public static String mConIP = "app.centit.com";
    
    // public static String mConIP = "192.168.135.50";
    
    //
    // public static String mConPort = "8080";
    
    // public static String mConPort = "8666";
    
    // 192.168.135.50：8080
    
    // 测试环境 海尔
    // public static String mConIP = "192.168.131.104";
    //
    // public static String mConPort = "8080";
    
    // 测试环境 产品
    // public static String mConIP = "192.168.131.102";
    //
    // public static String mConPort = "8080";
    
    // 测试环境 李浩
    // public static String mConIP = "192.168.135.29";
    //
    // public static String mConPort = "8888";
    
    // 测试环境 贾鹏
    // public static String mConIP = "192.168.135.50";
    //
    // public static String mConPort = "8080";
    
    // public static String mConIP = "demo.centit.com";
    //
    // public static String mConPort = "";
    
    // 本机环境 luoxing 192.168.135.57:8030
    // public static String mConIP = "192.168.135.57";
    
    // public static String mConPort = "8030";
    
    // 测试环境 104
    public static String       mConIP                   = "lihao.tunnel.qydev.com";
    
    public static String       mConPort                 = "";
    
    // 公网地址/
    
    // public static String mConIP = "app.centit.com";
    //
    // public static String mConPort = "443";
    
    //
    //
    //
    // 正式环境
    // public static String mConIP = "vip.mobile.haier.net";
    //
    // public static String mConPort = "8080";
    
    /**
     * 拼接的url
     */
    public static final String MIP_BASE_SERVERNAME      = "/wzInternetConference";                       //
                                                                                           // //zwyms
                                                                                           
    /**
     * 拼接的url
     */
    public static final String MIP_BAES_URL_BASEServlet = MIP_BASE_SERVERNAME + "/service/docking"; // server
                                                                                           
    // 通过前置机下载文件时拼接的字段
    public static final String MIP_DOWNLOADFILE_Serclet = "/cmipserv/fileDownload";       // cmipserv
                                                                                           
    public static String getMIP_BASEURL()
    {
        String mIPAddr = GlobalState.getInstance().getmIPAddr();
        if (mIPAddr != null && !mIPAddr.equals("") && !mIPAddr.startsWith("http://"))
        {
            mIPAddr = "http://" + mIPAddr;
        }
        
        String mPortNum = GlobalState.getInstance().getmPortNum();
        if (mPortNum != null && !mPortNum.equals(""))
        {
            mPortNum = ":" + mPortNum;
        }
        return mIPAddr + mPortNum;
    }







    /**
     * 请求的url
     * 
     * @return
     */
    public static String getMIP_BAES_URL()
    {
        String mIPAddr = GlobalState.getInstance().getmIPAddr();
        if (mIPAddr != null && !mIPAddr.equals("") && !mIPAddr.startsWith("http://"))
        {
            mIPAddr = "http://" + mIPAddr;
        }
        
        String mPortNum = GlobalState.getInstance().getmPortNum();
        if (mPortNum != null && !mPortNum.equals(""))
        {
            mPortNum = ":" + mPortNum;
        }

       String  mMethodName=GlobalState.getInstance().getmMethodName();
        return mIPAddr + mPortNum + Constant_Mgr.MIP_BAES_URL_BASEServlet+mMethodName;
    }


//    /**
//     * 请求的url
//     *
//     * @return
//     */
//    public static String getMIP_BAES_URL()
//    {
//        String mIPAddr = GlobalState.getInstance().getmIPAddr();
//        if (mIPAddr != null && !mIPAddr.equals("") && !mIPAddr.startsWith("http://"))
//        {
//            mIPAddr = "http://" + mIPAddr;
//        }
//
//        String mPortNum = GlobalState.getInstance().getmPortNum();
//        if (mPortNum != null && !mPortNum.equals(""))
//        {
//            mPortNum = ":" + mPortNum;
//        }
//
//
//        return mIPAddr + mPortNum + Constant_Mgr.MIP_BAES_URL_BASEServlet;
//    }









    public static String getMipRequstURL()
    {
        String requestUrl = GlobalState.getInstance().getmRequestURL();
        return requestUrl + Constant_Mgr.MIP_BAES_URL_BASEServlet;
    }
    
    public static String getDownloadFileRequstURL()
    {
        String requestUrl = GlobalState.getInstance().getmRequestURL();
        return requestUrl + Constant_Mgr.MIP_DOWNLOADFILE_Serclet;
    }
    
    /************** header里面的静态常量 ***************************************************/
    /**
     * 应用编号
     */
    public final static String ANDROID_APPID = "YDBG"; // NJXW com.haier.haiervipapp
                                                       
    /**
     * 是否加密 1：加密 0：不加密
     */
    public final static String isEncrypt     = "0";
    
    // 请求时的分页
    public final static int    pageSize      = 20;
    
    // public final static int pageSize = 20;
    
    // 初始化时默认最大功能数
    public final static int    maxFunSize    = 9;
    
    // ===============文件目录==============================
    
    /**
     * 最新apk包存放的地址
     */
    public static final String NewAPKPath(String newVersion)
    {
        return GETMIP_ROOT_DIR() + OsUtils.getAppName(GlobalState.getInstance(), "/MIP/") + "_" + newVersion + ".apk";
    }
    
    /**
     * 存储文件的根路径
     */
    public static final String GETMIP_ROOT_DIR()
    {
        return MIP_DeviceInfoUtils.getSDPath() + OsUtils.getApplicationName(GlobalState.getInstance(), "/CMIP/");
    }
    
    // 存储异常日志的目录
    public static final String GETMIP_CRASH_DIR()
    {
        return MIP_DeviceInfoUtils.getSDPath() + OsUtils.getApplicationName(GlobalState.getInstance(), "/CMIP/")
            + "/crash/";
    }
    
    public static final String GET_FILE_DIR(String dir)
    {
        return GETMIP_ROOT_DIR() + GlobalState.getInstance().getmUserName() + dir;
    }
    
    public final static String mGWLZDir             = "/公文流转/";
    
    public final static String mGloabNews           = "/全球资讯/";
    
    public final static String mHBAttach            = "/汇报/";
    
    public final static String mGWHistoryDir        = "/公文流转/历史记录/";
    
    public final static String mGWAttachDir         = "/公文流转/附件/";
    
    public final static String mGWKDir              = "/文档库/";
    
    public final static String mGRWDDir             = "/个人文档/";
    
    public final static String mNBYJDDir            = "/内部邮件/";
    
    public final static String mZXGLDDir            = "/资讯管理/";
    
    public final static String mHERBDir             = "/海尔人报/";
    
    public final static String mHEADDir             = "/头像/";
    
    public final static String mXXZXDir             = "/消息中心/";
    
    public final static String mStartPageDir        = "/广告页/";
    
    public final static String mTZGGDir             = "/通知公告/";
    
    public final static String mHYAttachDir         = "/会议管理/附件/";
    
    public final static String MIP_PHOTO_TEMP       = GETMIP_ROOT_DIR() + "PHOTOTEMP/";
    
    // 签批时临时文件
    public final static String MIP_PNG_TEMP         = GETMIP_ROOT_DIR() + "SIGNPNGTEMP/";
    
    public final static String MIP_PNG_TEMP_ZIP     = GETMIP_ROOT_DIR() + "TEMPNGTEMP/";
    
    public final static String VEDIOCENTER_TEMP_ZIP = GETMIP_ROOT_DIR() + "VIDEO/";
    
    /** 在线聊天 **/
    public final static String ZXLT_TEMP_ZIP        = GETMIP_ROOT_DIR() + "TEMPCHATPIC/";
    
    // JS调用后所有的被选择的文件目录
    public final static String SLECTEDIR            = "/选择文件夹/";
    
    public final static int    startPollingTime     = 15 * 60;
    
    // ===============模板==============================
    /**
     * 第一张模板
     */
    public final static String Page_0               = "0";
    
    /**
     * 第二张模板
     */
    public final static String Page_1               = "1";
    
    /**
     * 第三张模板
     */
    public final static String Page_2               = "2";
    
    // 不可以被编辑
    public final static String EditAbale_0          = "0";
    
    // 可以被编辑
    public final static String No_EditAble_1        = "1";
    
    // 有该功能的权限
    public final static String Able_0               = "0";
    
    // 没有该功能的权限
    public final static String No_Able_1            = "1";
    
    // 已经被添加
    public final static String Add_0                = "0";
    
    /**
     * 没有被添加
     */
    public final static String No_Add_1             = "1";
    
    // 有未读数/待办数的权限
    public final static String Count_0              = "0";
    
    // 没有未读数/待办数的权限
    public final static String No_Count_1           = "1";
    
    // ===============保存头像==============================
    /**
     * 保存头像的文件夹名称
     */
    public final static String heagerPicPath        = "/header/header.png";
    
    /**
     * 首页上头部背景
     */
    public final static String heagerBgPicPath      = "/header/hbg.png";
    
    // ===============发送广播的action==============================
    
    public static String sendGetCount()
    {
        return GlobalState.getInstance().getPackageName() + "_" + "com.ceniit.getcount";
    }
    
    public static String sendChangeHeadpic()
    {
        return GlobalState.getInstance().getPackageName() + "_" + "com.ceniit.changeheadpic";
    }
    
    public static String sendSwichSchedule()
    {
        return GlobalState.getInstance().getPackageName() + "_" + "com.ceniit.swichschedule";
    }
    
    public static String sendPerformSchedule()
    {
        return GlobalState.getInstance().getPackageName() + "_" + "com.ceniit.performschedule";
        
    }
    
    public static String sendXXUnCount()
    {
        return GlobalState.getInstance().getPackageName() + "_" + "com.ceniit.xxuncount";
    }
    
    // ===============公文流转待办、已办==============================
    // 待办
    public static final String UnHandleType         = "W";
    
    // 已办
    public static final String HandleType           = "C";
    
    // ===============公文审批待办、已办==============================
    // 待办
    public static final String SPUnHandleType       = "1";
    
    // 已办
    public static final String SPHandleType         = "0";
    
    // 收藏
    public static final String SPShouCanType        = "2";
    
    // =====================已公文收藏/未收藏公文========================
    
    // 已收藏
    public static final String SHOUCANFLAG          = "0";
    
    // 未收藏
    public static final String UNSHOUCANFLAG        = "1";
    
    // ===============决议/汇报 待处理和我发起的==============================
    // 待处理
    public static final String PENDHANDLETYPE       = "0";
    
    // 我发起的
    public static final String MYSTARTTYPE          = "1";
    
    // 决议
    public static final String TYPE_JUEYI           = "0";
    
    // 汇报
    public static final String TYPE_HUIBAO          = "1";
    
    // 未审批
    public static final String TYPE_UNSP            = "0";
    
    // 审批
    public static final String TYPE_SP              = "1";
    
    // 私聊
    public static final String TYPE_SILIAO          = "1";
    
    // 群聊
    public static final String TYPE_QUNLIAO         = "2";
    
    // ===============PDF==============================
    
    /**
     * ConstState.java 签批画笔红色
     */
    public static final int    COLOR_PEN_RED        = 0xFFFF0000;
    
    /**
     * ConstState.java 签批画笔绿色
     */
    public static final int    COLOR_PEN_GREED      = 0xFF00FF24;
    
    /**
     * ConstState.java 签批画笔黑色
     */
    public static final int    COLOR_PEN_BLACK      = 0xFF505050;
    
    /**
     * ConstState.java 签批画笔蓝色
     */
    public static final int    COLOR_PEN_BLUE       = 0xFF0078FF;
    
    /**
     * ConstState.java 自定义button中图片按下去颜色值，深蓝色
     */
    public static final int    COLOR_BUTTON_COLOR   = 0xFFFFFFFF;
    
    /**
     * ConstState.java 自定义button中图片按下去颜色值，深蓝色
     */
    public static final int    COLOR_BUTTON_PRESSED = 0xFF3B6F92;
    
    /**
     * ConstState.java 画笔细
     */
    public static final int    SIGN_STRESS_CRUDE    = 2;
    
    /**
     * ConstState.java 画笔正常
     */
    public static final int    SIGN_STRESS_NORMAL   = 4;
    
    /**
     * ConstState.java 画笔粗
     */
    public static final int    SIGN_STRESS_FINDE    = 6;
    
    // pdf解密的公钥
    public final static String PDF_CPWD             = "5186e9a727d7443dea37762030c17cfd";
    
    // 发送公文成功
    public final static String SENDDOCSUCCESS       = "com.centit.senddocsuccess";
    
    // 确认预约日程成功
    public final static String CONFIRMBOOKSCHEDUE   = "com.centit.confirmscheduesuccess";
    
    /**
     * 历史签批记录
     */
    public static final int    HISTORY_SING_BACK    = 1;
    
    /**
     * 待办（请求列表时标识）
     */
    public static final String UNHADLEDOCLIST       = "1";
    
    /**
     * 已办（请求列表时标识）
     */
    public static final String HASHANDLEDOCLIST     = "2";
    
    /**
     * 该pdf文件签批标识，不能签批
     */
    public final static int    NoSign               = 0;
    
    /**
     * 该pdf文件签批标识，签批
     */
    public final static int    Sign                 = 1;
    
    /**
     * 该pdf文件发送 标识，不可以发送
     */
    public final static int    NoSend               = 0;
    
    /**
     * 该pdf文件发送 标识，可以发送
     */
    public final static int    Send                 = 1;
    
    /**
     * 是否被锁定 ,没有被锁定
     */
    public final static String NoLocked             = "F";
    
    /**
     * 是否被锁定 ,被锁定
     */
    public final static String Locked               = "T";
    
    // 加载URL时，超时的时间
    public final static int    LoadUrlErrorTime     = 20000;
    
}
