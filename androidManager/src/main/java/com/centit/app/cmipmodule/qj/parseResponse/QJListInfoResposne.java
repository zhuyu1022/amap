/*
 * File name:  QJListInfoResposne.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月26日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.qj.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年10月26日]
 */
public class QJListInfoResposne implements Serializable
{
    
    /**
     * QJListInfoResposne.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"id",
    // "username":"请示人姓名",
    // "type": "申请类型",
    // "reason": "申请事由",
    // "starttime": "开始时间",
    // "endtime": "结束时间",
    // "auditstatus": "审核状态",
    // "auditcontent": "审核内容"
    /** id **/
    private String            id;
    
    /** 请示人姓名 **/
    private String            userName;
    
    private String            receiverName;
    
    private String            createUserName;
    
    private String            createTime;
    
    /** 申请类型 **/
    private String            TYPE;
    
    /** 申请事由 **/
    private String            reason;
    
    /** 开始时间 **/
    private String            beginTime;
    
    /** 结束时间 **/
    private String            endTime;
    
    /** 审核状态 **/
    private String            status;
    
    /** 审核内容 **/
    private String            content;
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author wl
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author wl
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 username
     * 
     * @return 返回 username
     * @author wl
     */
    public String getUsername()
    {
        return userName;
    }
    
    /**
     * 设置 username
     * 
     * @param username 对username进行赋值
     * @author wl
     */
    public void setUsername(String username)
    {
        this.userName = username;
    }
    
    /**
     * 获取 receiverName
     * 
     * @return 返回 receiverName
     * @author wl
     */
    public String getReceiverName()
    {
        return receiverName;
    }
    
    /**
     * 设置 receiverName
     * 
     * @param receiverName 对receiverName进行赋值
     * @author wl
     */
    public void setReceiverName(String receiverName)
    {
        this.receiverName = receiverName;
    }
    
    /**
     * 获取 createUserName
     * 
     * @return 返回 createUserName
     * @author wl
     */
    public String getCreateUserName()
    {
        return createUserName;
    }
    
    /**
     * 设置 createUserName
     * 
     * @param createUserName 对createUserName进行赋值
     * @author wl
     */
    public void setCreateUserName(String createUserName)
    {
        this.createUserName = createUserName;
    }
    
    /**
     * 获取 createTime
     * 
     * @return 返回 createTime
     * @author wl
     */
    public String getCreateTime()
    {
        return createTime;
    }
    
    /**
     * 设置 createTime
     * 
     * @param createTime 对createTime进行赋值
     * @author wl
     */
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    /**
     * 获取 tYPE
     * 
     * @return 返回 tYPE
     * @author wl
     */
    public String getTYPE()
    {
        return TYPE;
    }
    
    /**
     * 设置 tYPE
     * 
     * @param tYPE 对tYPE进行赋值
     * @author wl
     */
    public void setTYPE(String tYPE)
    {
        TYPE = tYPE;
    }
    
    /**
     * 获取 reason
     * 
     * @return 返回 reason
     * @author wl
     */
    public String getReason()
    {
        return reason;
    }
    
    /**
     * 设置 reason
     * 
     * @param reason 对reason进行赋值
     * @author wl
     */
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    
    /**
     * 获取 beginTime
     * 
     * @return 返回 beginTime
     * @author wl
     */
    public String getBeginTime()
    {
        return beginTime;
    }
    
    /**
     * 设置 beginTime
     * 
     * @param beginTime 对beginTime进行赋值
     * @author wl
     */
    public void setBeginTime(String beginTime)
    {
        this.beginTime = beginTime;
    }
    
    /**
     * 获取 endTime
     * 
     * @return 返回 endTime
     * @author wl
     */
    public String getEndTime()
    {
        return endTime;
    }
    
    /**
     * 设置 endTime
     * 
     * @param endTime 对endTime进行赋值
     * @author wl
     */
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    
    /**
     * 获取 status
     * 
     * @return 返回 status
     * @author wl
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * 设置 status
     * 
     * @param status 对status进行赋值
     * @author wl
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * 获取 content
     * 
     * @return 返回 content
     * @author wl
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author wl
     */
    public void setContent(String content)
    {
        this.content = content;
    }
    
}
