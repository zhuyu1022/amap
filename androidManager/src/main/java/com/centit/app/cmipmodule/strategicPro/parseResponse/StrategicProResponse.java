/*
 * File name:  ResultResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.strategicPro.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月21日]
 */
public class StrategicProResponse implements Serializable
{
    
    /**
     * ResultResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"战略项目id",
    // "title":"项目标题",
    // "info":"项目内容",
    // "sender":"创建人姓名",
    // "handlestatus":"项目进度情况",
    // "fiskstatus":"风险程度：0：正常，1：有风险，2：高风险；“
    // "updatetime":"最近更新时间"
    
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
    
    /** 项目进度情况 **/
    private String            handlestatus;
    
    /** 风险程度：0：正常，1：有风险，2：高风险； **/
    private String            fiskstatus;
    
    /** 完成时间 **/
    private String            createtime;
    
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
     * 获取 createtime
     * 
     * @return 返回 createtime
     * @author wl
     */
    public String getCreatetime()
    {
        return createtime;
    }
    
    /**
     * 设置 createtime
     * 
     * @param createtime 对createtime进行赋值
     * @author wl
     */
    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }
    
}
