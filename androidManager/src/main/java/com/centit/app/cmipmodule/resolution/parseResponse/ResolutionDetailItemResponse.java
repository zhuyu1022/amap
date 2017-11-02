/*
 * File name:  ResultDetailItemResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.resolution.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月21日]
 */
public class ResolutionDetailItemResponse implements Serializable
{
    
    /**
     * ResultDetailItemResponse.java
     */
    private static final long                  serialVersionUID = 1L;
    
    // "handlertype":"处理人类型: 0 主责任人 1 抄送人",
    // "handler":"处理人姓名",
    // "handlecontent":"处理内容",
    // "handlestatus":"决议处理情况0：发起 ，1：处理中，2：完成；",
    // " fiskstatus":"风险程度：0：正常，1：有风险，2：高风险；“
    // "handletime":"处理时间"
    
    private String                             handlertype;
    
    private String                             handler;
    
    private String                             handlecontent;
    
    private String                             handlestatus;
    
    private String                             handletime;
    
    private String                             fiskstatus;
    
    private List<ResolutionDeailIssueResponse> issue            = new ArrayList<ResolutionDeailIssueResponse>();
    
    private boolean                            isOpen           = false;
    
    /**
     * 获取 isOpen
     * 
     * @return 返回 isOpen
     * @author wl
     */
    public boolean isOpen()
    {
        return isOpen;
    }
    
    /**
     * 设置 isOpen
     * 
     * @param isOpen 对isOpen进行赋值
     * @author wl
     */
    public void setOpen(boolean isOpen)
    {
        this.isOpen = isOpen;
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
    
    /**
     * 获取 issue
     * 
     * @return 返回 issue
     * @author wl
     */
    public List<ResolutionDeailIssueResponse> getIssue()
    {
        return issue;
    }
    
    /**
     * 设置 issue
     * 
     * @param issue 对issue进行赋值
     * @author wl
     */
    public void setIssue(List<ResolutionDeailIssueResponse> issue)
    {
        this.issue = issue;
    }
    
}
