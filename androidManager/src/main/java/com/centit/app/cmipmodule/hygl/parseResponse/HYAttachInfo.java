/*
 * File name:  HYAttachInfo.java
 * Copyright:  Copyright (c) 2006-2017 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2017年2月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.hygl.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2017年2月21日]
 */
public class HYAttachInfo implements Serializable
{
    
    /**
     * HYAttachInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            path;
    
    private String            name;
    
    private String            id;
    
    /**
     * 获取 path
     * 
     * @return 返回 path
     * @author wl
     */
    public String getPath()
    {
        return path;
    }
    
    /**
     * 设置 path
     * 
     * @param path 对path进行赋值
     * @author wl
     */
    public void setPath(String path)
    {
        this.path = path;
    }
    
    /**
     * 获取 name
     * 
     * @return 返回 name
     * @author wl
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 设置 name
     * 
     * @param name 对name进行赋值
     * @author wl
     */
    public void setName(String name)
    {
        this.name = name;
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
    
}
