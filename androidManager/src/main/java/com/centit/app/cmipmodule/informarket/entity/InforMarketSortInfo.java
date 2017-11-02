/*
 * File name:  InforMarketSortInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-21
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.informarket.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-21]
 */
public class InforMarketSortInfo implements Serializable
{
    
    /**
     * InforMarketSortInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    // "pid": "分类ID",
    // "pname": "分类名称",
    // "purl": "分类图标",
    // "newnum":"最新文件数量"
    private String            pid;
    
    private String            pname;
    
    private String            purl;
    
    private String            newnum;
    
    /** 已读未读表示 **/
    private String            unreadflag;
    
    /**
     * 获取 unreadflag
     * 
     * @return 返回 unreadflag
     * @author wl
     */
    public String getUnreadflag()
    {
        return unreadflag;
    }
    
    /**
     * 设置 unreadflag
     * 
     * @param unreadflag 对unreadflag进行赋值
     * @author wl
     */
    public void setUnreadflag(String unreadflag)
    {
        this.unreadflag = unreadflag;
    }
    
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
    
    public String getNewnum()
    {
        return newnum;
    }
    
    public void setNewnum(String newnum)
    {
        this.newnum = newnum;
    }
}
