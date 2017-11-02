/*
 * File name:  PSchedueEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2015-10-10
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.personschedue.entity;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2015-10-10]
 */
public class PSchedueEntity
{
    public PSchedueEntity(String mtitle, String mcontent, String mstart, String mEnd)
    {
        super();
        this.title = mtitle;
        this.content = mcontent;
        this.startTime = mstart;
        this.endTime = mEnd;
    }
    
    private String title;
    
    private String content;
    
    private String startTime;
    
    private String endTime;
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    
    public String getEndTime()
    {
        return endTime;
    }
    
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    
}
