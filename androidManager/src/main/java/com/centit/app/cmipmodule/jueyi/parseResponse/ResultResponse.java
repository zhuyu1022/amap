/*
 * File name:  ResultResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.jueyi.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月21日]
 */
public class ResultResponse implements Serializable
{
    
    /**
     * ResultResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    /** 决议/汇报id **/
    private long              id;
    
    /** 决议/汇报标题 **/
    private String            title;
    
    /** 决议/汇报内容 **/
    private String            info;
    
    /** 发起人姓名 **/
    private String            sender;
    
    /** 读状态：0 未读 1 已读 **/
    private String            readstatus;
    
    /** 决议/汇报处理/已阅、未阅状态 N 未完成/未阅 Y 已完成/已阅 **/
    private String            handlestatus;
    
    /** 完成时间 **/
    private String            finishtime;
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author wl
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author wl
     */
    public void setId(long id)
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
