/*
 * File name:  Projects.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-23
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqpt.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-23]
 */
public class Projects implements Serializable
{
    
    /**
     * Projects.java
     */
    private static final long serialVersionUID = 1L;
    
    // "pid": "项目ID",
    // "pname": "项目名称",
    // "purl": "项目图标",
    // "newreportsnum":"最新报告数量"
    
    private String            pid;
    
    private String            pname;
    
    private String            purl;
    
    private String            newreportsnum;
    
    public String getPid()
    {
        return pid;
    }
    
    public void setPid(String pid)
    {
        this.pid = pid;
    }
    
    public String getPname()
    {
        return pname;
    }
    
    public void setPname(String pname)
    {
        this.pname = pname;
    }
    
    public String getPurl()
    {
        return purl;
    }
    
    public void setPurl(String purl)
    {
        this.purl = purl;
    }
    
    public String getNewreportsnum()
    {
        return newreportsnum;
    }
    
    public void setNewreportsnum(String newreportsnum)
    {
        this.newreportsnum = newreportsnum;
    }
    
}
