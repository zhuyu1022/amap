/*
 * File name:  ResolutionDeailIssueResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年12月9日
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
 * @Version [版本号, 2016年12月9日]
 */
public class ResolutionDeailIssueResponse implements Serializable
{
    
    /**
     * ResolutionDeailIssueResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "handler":"处理人姓名",
    // "handlecontent":"处理内容"
    // "handlestatus":"处理情况1：处理中，2：完成；",
    // "handletime":"处理时间"
    
    private String            id;
    
    private String            fiskstatus;
    
    private String            handlertype;
    
    private String            handler;
    
    private String            handlecontent;
    
    private String            handlestatus;
    
    private String            handletime;
    
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
     * 获取 handlertype
     * 
     * @return 返回 handlertype
     * @author wl
     */
    public String getHandlertype()
    {
        return handlertype;
    }
    
    /**
     * 设置 handlertype
     * 
     * @param handlertype 对handlertype进行赋值
     * @author wl
     */
    public void setHandlertype(String handlertype)
    {
        this.handlertype = handlertype;
    }
    
    /**
     * 获取 handler
     * 
     * @return 返回 handler
     * @author wl
     */
    public String getHandler()
    {
        return handler;
    }
    
    /**
     * 设置 handler
     * 
     * @param handler 对handler进行赋值
     * @author wl
     */
    public void setHandler(String handler)
    {
        this.handler = handler;
    }
    
    /**
     * 获取 handlecontent
     * 
     * @return 返回 handlecontent
     * @author wl
     */
    public String getHandlecontent()
    {
        return handlecontent;
    }
    
    /**
     * 设置 handlecontent
     * 
     * @param handlecontent 对handlecontent进行赋值
     * @author wl
     */
    public void setHandlecontent(String handlecontent)
    {
        this.handlecontent = handlecontent;
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
     * 获取 handletime
     * 
     * @return 返回 handletime
     * @author wl
     */
    public String getHandletime()
    {
        return handletime;
    }
    
    /**
     * 设置 handletime
     * 
     * @param handletime 对handletime进行赋值
     * @author wl
     */
    public void setHandletime(String handletime)
    {
        this.handletime = handletime;
    }
    
}
