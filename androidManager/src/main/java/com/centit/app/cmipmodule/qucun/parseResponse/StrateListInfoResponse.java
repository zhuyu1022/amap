/*
 * File name:  StrateListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月27日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.qucun.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年10月27日]
 */
public class StrateListInfoResponse implements Serializable
{
    // {"name":"库存","url":"http://zlxs.haier.net:3000/public/pad/"}
    
    // "icon":"图标地址",
    // "name":"名称",
    // "url":"链接地址"，
    // "sn":"排序号"
    
    /**
     * StrateListInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            name;
    
    private String            url;
    
    private String            icon;
    
    private String            sn;
    
    public String getIcon()
    {
        return icon;
    }
    
    public void setIcon(String icon)
    {
        this.icon = icon;
    }
    
    public String getSn()
    {
        return sn;
    }
    
    public void setSn(String sn)
    {
        this.sn = sn;
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
     * 获取 url
     * 
     * @return 返回 url
     * @author wl
     */
    public String getUrl()
    {
        return url;
    }
    
    /**
     * 设置 url
     * 
     * @param url 对url进行赋值
     * @author wl
     */
    public void setUrl(String url)
    {
        this.url = url;
    }
    
}
