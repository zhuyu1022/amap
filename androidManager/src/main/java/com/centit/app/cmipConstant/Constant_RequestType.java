/*
 * File name:  RequestTypeConstants.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ma_zhicheng
 * Last modified date:  18 Sep,2013
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipConstant;

/**
 * 用户登陆请求报文封装的请求ID
 *
 * @Description 用户登陆
 *
 * @author ma_zhicheng
 * @Version [版本号, 18 Sep,2013]
 */
public class Constant_RequestType
{
    /**
     * 下载标识
     */
    public static final int REQUEST_DOWNLOADPROCESSBAR    = 2001;

    /**
     * 上传标识
     */
    public static final int REQUEST_UPLOADPROCESSBAR      = 2002;

    /** 登录接口 **/
    public static final int LOGIN_REQUEST                 = 1;

    /**
     * 获取最新版本
     */
    public static final int DOWNLOADNEWVERSION            = 2;

    /**
     * 设备绑定接口
     */
    public static final int BINDDEVICE_REQUEST            = 3;

    /**
     * 心跳
     */
    public static final int HEARTBEAT_REQUEST             = 4;

    /**
     * 下载附件
     */
    public static final int DOWNLOADATTACH                = 5;

    /**
     * 修改密码
     */
    public static final int CHANGE_PASSWORD               = 6;

    /**
     * 百度推送消息
     */
    public static final int SAVEBAIDUINFO                 = 7;

    /**
     * 获取请求URL
     */
    public static final int GETBASEURL                    = 8;

    /**
     * 获取天气URL
     */
    public static final int GETWEATHER                    = 9;

    /**
     * 获取新闻频道
     */
    public static final int GETNEWSCHANNEL                = 10;

    /**
     * 获取详细列表
     */
    public static final int GETNEWSLIST                   = 11;

    /**
     * 添加记事
     */
    public static final int ADDCLOUD                      = 12;

    /**
     * 获取记事
     */
    public static final int GETCLOUD                      = 13;

    /**
     * 删除记事
     */
    public static final int DELCLOUD                      = 14;

    /**
     * 获取通讯录
     */
    public static final int GETADDRESSBOOK                = 15;

    /**
     * 搜索通讯录
     */
    public static final int SEARCHADDRESSBOOK             = 16;

    // 获取未读数/待办数
    public static final int GETCOUNT                      = 17;

    /**
     * 意见反馈
     */
    public static final int OPINIONREFLECT_REQUEST        = 18;

    /**
     * 获取资讯的类别
     */
    public static final int GETINFOTYPE_REQUEST           = 19;

    /**
     * 获取资讯的类别
     */
    public static final int GETINFOLIST_REQUEST           = 20;

    /**
     * 获取资讯的详情
     */
    public static final int GETINFODETAIL_REQUEST         = 21;

    /**
     * 获取公文库类型
     */
    public static final int GETGWKTYPE_REQUEST            = 22;

    /**
     * 获取公文库列表
     */
    public static final int GETGWKLIST_REQUEST            = 23;

    /**
     * 获取公文库详情
     */
    public static final int GETGWKDETAIL_REQUEST          = 24;

    /**
     * 获取日程列表
     */
    public static final int GETSCHEDUELIST                = 25;

    /**
     * 删除日程
     */
    public static final int DELETESCHEDUE                 = 26;

    /**
     * 添加日程
     */
    public static final int ADDSCHEDUE                    = 27;

    /**
     * 编辑日程
     */
    public static final int UPDATESCHEDUE                 = 28;

    /**
     * 获取日程详情
     */
    public static final int GETSCHEDUEDETAIL              = 29;

    /**
     * 获取邮件列表
     */
    public static final int GETINTERNALMAILLIST           = 30;

    /**
     * 获取邮件详情
     */
    public static final int GETINTERNALMAILDETAIL         = 31;

    /**
     * 更新阅读状态
     */
    public static final int UPDATEREADSTATUS              = 32;

    /**
     * 删除邮件
     */
    public static final int DETAILINTERNALMAIL            = 33;

    /**
     * 获取领导日程列表
     */
    public static final int GETLDSCHEDULELIST_REQUEST     = 34;

    /**
     * 获取领导日程详情
     */
    public static final int GETLDSCHEDULEDETAIL_REQUEST   = 35;

    /**
     * 获取公文流转类型
     */
    public static final int GETGWLZTYPE_REQUEST           = 36;

    /**
     * 获取公文流转列表
     */
    public static final int GETGWLZLIST_REQUEST           = 37;

    /**
     * 获取公文流转详情
     */
    public static final int GETGWLZDETAIL_REQUEST         = 38;

    /**
     * 发送签批意见
     */
    public static final int SENDOFFICALOPINION            = 39;

    /**
     * 获取历史签批信息
     */
    public static final int GETOFFICALAPPROVAL            = 40;

    /**
     * 获取附件列表
     */
    public static final int GETATTACHMENTLIST             = 41;

    /**
     * 发送邮件
     */
    public static final int SENDMAIL_REQUEST              = 42;

    /**
     * 获取个人文档列表
     */
    public static final int GETPERSONALDOCLIST            = 43;

    /**
     * 个人文档目录新增
     */
    public static final int CREATEPERSONALDOCFOLDER       = 44;

    /**
     * 个人文档目录删除或修改
     */
    public static final int SAVEORUPDATEPERSONALDOCFOLDER = 45;

    /** 上传文件 **/
    public static final int SENDUPLOADPERSONFILE          = 46;

    /**
     * 获取下一步步骤
     */
    public static final int GETNEXTSTEP                   = 47;

    /**
     * 发送文件
     */
    public static final int SENDFILECONTENT               = 48;

    /**
     * 签批时锁定
     */
    public static final int SENDLOCKDOC                   = 49;

    /** 获取会议室列表 **/
    public static final int SENDGETBOARDROOMLIST          = 50;

    /** 获取会议预定详情 **/
    public static final int SENDGETBOARDROOMDETAIL        = 51;

    /** 会议室预定 **/
    public static final int SENDBOOKBOARDROOM             = 52;

    /** 会议室预定取消 **/
    public static final int SENDCANCELBOOKING             = 53;

    /**
     * 获取当前处理人员
     */
    public static final int GETOFFICALACTIVELIST          = 54;

    /**
     * 获取未读数
     */
    public static final int GETOFFICAL_UNCOUNT            = 55;

    /** 获取信息超市分类 **/
    public static final int GETINFORMARKETSORT            = 56;

    /** 获取信息超市列表 **/
    public static final int GETINFORMARKETLIST            = 57;

    /* 获取最新版本 */
    public static final int GETNEWVERSION                 = 58;

    public static final int DOWNLOADFILEREQUEST           = 59;

    /** 获取决议列表 **/
    public static final int GETRESULTLIST                 = 60;

    /** 获取决议详情 **/
    public static final int GETRESULTDETAIL               = 61;

    /** 获取所属日程 **/
    public static final int GETDAILYWORKLIST              = 62;

    /** 获取人员列表 **/
    public static final int GETSELECTPEOPLE               = 63;

    /** 新增 **/
    public static final int SENDEDITRESULT                = 64;

    /** 刪除 **/
    public static final int SENDDELETERESULT              = 65;

    /** 提交 **/
    public static final int SENDDCOMMITRESULT             = 66;

    /** 获取参与人和所属人 **/
    public static final int SENDGETJOINERLIST             = 67;

    /** 获取日程类型 **/
    public static final int SENDGETTYPELIST               = 68;

    /** 获取所属决议 **/
    public static final int SENDGETSCHEDULERESULTLIST     = 69;

    /** 获取人员 **/
    public static final int SENDGETSCHEDULEMEMBER         = 70;

    /** 获取书籍列表 **/
    public static final int SENDGETBOOKLIST               = 71;

    /** 获取购物车列表 **/
    public static final int SENDGETCARBOOKLIST            = 72;

    /** 获取删除购物车 **/
    public static final int SENDDELETEBOOKLIST            = 73;

    /** 获取详情 **/
    public static final int SENDBOOKDETAIL                = 74;

    /** 添加到购物车 **/
    public static final int SENDADDTOCAR                  = 75;

    /** 获取视频系列列表 **/
    public static final int SENDGETSERISELIST             = 76;

    /** 更新阅读状态 **/
    public static final int SENDUPREADSTATUS              = 77;

    /** 获取视频列表 **/
    public static final int SENDGETVEDIOLIST              = 78;

    /** 请示报告列表 **/
    public static final int SENDGETQSBGLIST               = 79;

    /** 审核 **/
    public static final int SENDAUDITCONTET               = 81;

    /** 提交请示报告 **/
    public static final int SENDCOMMITQSBG                = 82;

    public static final int SENDGETSTRATELIST             = 83;

    /** 获取聊天列表 **/
    public static final int SENDGETCHARTLIST              = 84;

    /** 创建讨论组 **/
    public static final int SENDCREATECHART               = 85;

    /**
     * 获取聊天记录
     */
    public static final int SENDGETCHATLIST               = 85;

    /**
     * 发送聊天消息
     */
    public static final int SENDCHATMSG                   = 86;

    /**
     * 删除讨论组
     */
    public static final int DELETECHATGROUP               = 87;

    /**
     * 分享
     */
    public static final int CHATSHAREREQUEST              = 88;

    // 获取广告页/引导页
    public static final int GETSTARTPAGE                  = 89;

    // 模块未读数
    public static final int GETMODULEUNREADCOUNT          = 90;

    // 更新模块点击
    public static final int UPDATEMCLICKCOUNT             = 91;

    /**
     * 获取预约日程列表
     */
    public static final int GETSCHEDUEBOOKLIST            = 92;

    /**
     * 获取年数据
     */
    public static final int GETSCHEDUEYEARDATA            = 93;

    /**
     * 确定预约数据
     */
    public static final int SENDCONFIRMSCHEDUE            = 94;

    /** 获取战略项目列表 **/
    public static final int GETSTRATEGICPROLIST           = 95;

    /** 获取战略项目详情 **/
    public static final int GETSTRATEGICPRODETAIL         = 96;

    /** 新增战略 **/
    public static final int SENDEDITSTRATEGICPRO          = 97;

    /** 刪除战略项目 **/
    public static final int SENDDELETESTRATEGICPRO        = 98;

    /** 汇报战略项目 **/
    public static final int SENDHUIBAOSTRATEGICPRO        = 99;

    // 上传步数
    public static final int SENDSTEPREQUST                = 100;

    // 获取消息中心未读数
    public static final int GETMSGCOUNT                   = 101;

    // 更新消息状态
    public static final int UPDATEMSGSTATUS               = 102;

    // 获取消息分类下所有列表
    public static final int GETMSGTYPELIST                = 103;

    // 获取分类下所有的消息列表
    public static final int GETMSGLIST                    = 104;

    /**
     * 删除预约数据
     */
    public static final int SENDDELETEBOOKSCHEDUE         = 105;

    /**
     * 删除消息
     */
    public static final int DELETEMSG                     = 106;

    // 设置提醒时间
    public static final int SETSCHDUELTIME                = 108;

    /** 二维码扫描 **/
    public static final int SIGNMEETING                   = 109;

    // 设置手势密码
    public static final int SETGESTRUESTATUS              = 110;

    /**
     * 获取会议列表
     */
    public static final int GETHYLIST                     = 111;

    /**
     * 获取会议详情
     */
    public static final int GETHYDETAIL                   = 112;

    // 公文收藏
    public static final int SETCOLLET                     = 113;

    // 获取通知公告列表
    public static final int GETTZGGLIST                   = 114;

    // 获取手机验证码
    public static final int GETVERCODE                    = 115;

    // 用户注册
    public static final int USERREGISTER                  = 116;

    // 用户信息完善
    public static final int USERINFOSUBMIT                = 117;

    // 重置密码
    public static final int MODIFYPWD                     = 118;

    // 开始打卡
    public static final int STARTSIGN                     = 119;

    // 获取当天打卡记录
    public static final int GETCLOCKLIST                  = 120;

    // 获取月考勤记录
    public static final int GETATTENDANCELIST             = 121;

    // 获取月考勤详细记录
    public static final int GETATTENDANCEDETAILLIST       = 122;

    // 保存补卡申请
    public static final int SAVEBKAPPLY                   = 123;

    // 获取审核列表
    public static final int GETAUDITLIST                  = 124;

    // 获取审核列表详情
    public static final int GETAUDITLISTDETAIL            = 125;

    // 发送审核
    public static final int AUDITAPPLY                    = 126;

    // 获取系统时间
    public static final int GETSYSTEMTIME                 = 127;

    // 保存用户签名
    public static final int SAVESIGNATURE                 = 128;

    // 保存用户签名
    public static final int UPLOADPHOTO                   = 129;
}
