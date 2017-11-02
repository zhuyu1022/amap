/*
 * File name:  ResultDetailResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.strategicPro.parseResponse;

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
public class StrategicDetailResponse implements Serializable
{
    
    /**
     * ResultDetailResponse.java
     */
    private static final long                 serialVersionUID = 1L;
    
    // "sender": "马坚",
    // "id": 100000000015,
    // "title": "测试一下项目新增",
    // "HANDLERID": "10000014",
    // "results": [],
    // "sendtime": "20161214140902",
    // "handler": "马坚",
    // "info": "测试一下项目新增"
    private String                            sender;
    
    private String                            id;
    
    private String                            title;
    
    private String                            HANDLERID;
    
    private String                            sendtime;
    
    private String                            handler;
    
    private String                            handlerid;
    
    private String                            info;
    
    private String                            starttime;
    
    private String                            finishtime;
    
    private String                            handlemode;
    
    /****/
    private List<StrategicDetailItemResponse> results          = new ArrayList<StrategicDetailItemResponse>();
    
    /**
     * 获取 handlerid
     * 
     * @return 返回 handlerid
     * @author wl
     */
    public String getHandlerid()
    {
        return handlerid;
    }
    
    /**
     * 设置 handlerid
     * 
     * @param handlerid 对handlerid进行赋值
     * @author wl
     */
    public void setHandlerid(String handlerid)
    {
        this.handlerid = handlerid;
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
     * 获取 hANDLERID
     * 
     * @return 返回 hANDLERID
     * @author wl
     */
    public String getHANDLERID()
    {
        return HANDLERID;
    }
    
    /**
     * 设置 hANDLERID
     * 
     * @param hANDLERID 对hANDLERID进行赋值
     * @author wl
     */
    public void setHANDLERID(String hANDLERID)
    {
        HANDLERID = hANDLERID;
    }
    
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
     * 获取 results
     * 
     * @return 返回 results
     * @author wl
     */
    public List<StrategicDetailItemResponse> getResults()
    {
        return results;
    }
    
    /**
     * 设置 results
     * 
     * @param results 对results进行赋值
     * @author wl
     */
    public void setResults(List<StrategicDetailItemResponse> results)
    {
        this.results = results;
    }
    
    /**
     * 获取 starttime
     * 
     * @return 返回 starttime
     * @author wl
     */
    public String getStarttime()
    {
        return starttime;
    }
    
    /**
     * 设置 starttime
     * 
     * @param starttime 对starttime进行赋值
     * @author wl
     */
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
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
    
    /**
     * 获取 handlemode
     * 
     * @return 返回 handlemode
     * @author wl
     */
    public String getHandlemode()
    {
        return handlemode;
    }
    
    /**
     * 设置 handlemode
     * 
     * @param handlemode 对handlemode进行赋值
     * @author wl
     */
    public void setHandlemode(String handlemode)
    {
        this.handlemode = handlemode;
    }
    
}
