/*
 * File name:  TypeEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  rqj
 * Last modified date:  2015-7-6
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.gwlz.entity;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-7-6]
 */
public class TypeEntity
{
    private String id;
    
    private String name;
    
    private String unReadCount;
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author rqj
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author rqj
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 name
     * 
     * @return 返回 name
     * @author rqj
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 设置 name
     * 
     * @param name 对name进行赋值
     * @author rqj
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 获取 unReadCount
     * 
     * @return 返回 unReadCount
     * @author rqj
     */
    public String getUnReadCount()
    {
        return unReadCount;
    }
    
    /**
     * 设置 unReadCount
     * 
     * @param unReadCount 对unReadCount进行赋值
     * @author rqj
     */
    public void setUnReadCount(String unReadCount)
    {
        this.unReadCount = unReadCount;
    }
    
}
