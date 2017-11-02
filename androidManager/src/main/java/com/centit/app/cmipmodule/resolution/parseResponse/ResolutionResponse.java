/*
 * File name:  ResultResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.resolution.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月21日]
 */
public class ResolutionResponse implements Serializable
{
    
    /**
     * ResultResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"决议id",
    // "title":"决议标题",
    // "info":"决议内容",
    // "sender":"发起人姓名",
    // "readstatus":"读状态：0 未读 1 已读",
    // "handlestatus":"决议处理情况0：发起 ，1：处理中，2：完成；",
    // “status”:”处理人处理状态0：未处理，1：已处理，处理状态为空，只需要判断handlestatus”
    //
    // " fiskstatus":"风险程度：0：正常，1：有风险，2：高风险；“
    // "finishtime":"完成时间"
    /** 决议id **/
    private String            id;
    
    /** 决议标题 **/
    private String            title;
    
    /** 决议内容 **/
    private String            info;
    
    /** 发起人姓名 **/
    private String            sender;
    
    /** 读状态：0 未读 1 已读 **/
    private String            readstatus;
    
    /** 决议处理情况0：发起 ，1：处理中，2：完成； **/
    private String            handlestatus;
    
    /** 处理人处理状态0：未处理，1：已处理，处理状态为空，只需要判断handlestatus **/
    private String            status;
    
    /** 风险程度：0：正常，1：有风险，2：高风险； **/
    private String            fiskstatus;
    
    /** 完成时间 **/
    private String            finishtime;
    
    /** 发起时间 **/
    private String            sendtime;
    
    /**
     * 获取 sendtime
     * 
     * @return 返回 sendtime
     * @author wl
     */
    public String getSendtime()
    {
        return sendtime;
    }
    
    /**
     * 设置 sendtime
     * 
     * @param sendtime 对sendtime进行赋值
     * @author wl
     */
    public void setSendtime(String sendtime)
    {
        this.sendtime = sendtime;
    }
    
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
     * 获取 title
     * 
     * @return 返回 title
     * @author wl
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 设置 title
     * 
     * @param title 对title进行赋值
     * @author wl
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * 获取 info
     * 
     * @return 返回 info
     * @author wl
     */
    public String getInfo()
    {
        return info;
    }
    
    /**
     * 设置 info
     * 
     * @param info 对info进行赋值
     * @author wl
     */
    public void setInfo(String info)
    {
        this.info = info;
    }
    
    /**
     * 获取 sender
     * 
     * @return 返回 sender
     * @author wl
     */
    public String getSender()
    {
        return sender;
    }
    
    /**
     * 设置 sender
     * 
     * @param sender 对sender进行赋值
     * @author wl
     */
    public void setSender(String sender)
    {
        this.sender = sender;
    }
    
    /**
     * 获取 readstatus
     * 
     * @return 返回 readstatus
     * @author wl
     */
    public String getReadstatus()
    {
        return readstatus;
    }
    
    /**
     * 设置 readstatus
     * 
     * @param readstatus 对readstatus进行赋值
     * @author wl
     */
    public void setReadstatus(String readstatus)
    {
        this.readstatus = readstatus;
    }
    
    /**
     * 获取 handlestatus
     * 
     * @return 返回 handlestatus
     * @author wl
     */
    public String getHandlestatus()
    {
        return handlestatus;
    }
    
    /**
     * 设置 handlestatus
     * 
     * @param handlestatus 对handlestatus进行赋值
     * @author wl
     */
    public void setHandlestatus(String handlestatus)
    {
        this.handlestatus = handlestatus;
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
     * 获取 fiskstatus
     * 
     * @return 返回 fiskstatus
     * @author wl
     */
    public String getFiskstatus()
    {
        return fiskstatus;
    }
    
    /**
     * 设置 fiskstatus
     * 
     * @param fiskstatus 对fiskstatus进行赋值
     * @author wl
     */
    public void setFiskstatus(String fiskstatus)
    {
        this.fiskstatus = fiskstatus;
    }
    
    /**
     * 获取 finishtime
     * 
     * @return 返回 finishtime
     * @author wl
     */
    public String getFinishtime()
    {
        return finishtime;
    }
    
    /**
     * 设置 finishtime
     * 
     * @param finishtime 对finishtime进行赋值
     * @author wl
     */
    public void setFinishtime(String finishtime)
    {
        this.finishtime = finishtime;
    }
    
}
