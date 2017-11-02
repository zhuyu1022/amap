/*
 * File name:  ZXLTChartUserListInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月2日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt.response;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月2日]
 */
public class ZXLTChartUserListInfo implements Serializable
{
    // "uid":"用户id",
    // "name":"用户姓名",
    // "icon":"用户头像图片下载地址"
    private String uid;
    
    private String name;
    
    private String icon;
    
    /**
     * 获取 uid
     * 
     * @return 返回 uid
     * @author wl
     */
    public String getUid()
    {
        return uid;
    }
    
    /**
     * 设置 uid
     * 
     * @param uid 对uid进行赋值
     * @author wl
     */
    public void setUid(String uid)
    {
        this.uid = uid;
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
     * 获取 icon
     * 
     * @return 返回 icon
     * @author wl
     */
    public String getIcon()
    {
        return icon;
    }
    
    /**
     * 设置 icon
     * 
     * @param icon 对icon进行赋值
     * @author wl
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }
    
}
