/*
 * File name:  YunTuNavlistBizResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-23
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.news.parseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-23]
 */
public class YunTuNavlistDataResponse implements Serializable
{
    
    // "id":"一级菜单ID",
    // "name":"一级菜单名称",
    // "navs":[{
    // "id": "二级菜单ID ",
    // "name": "二级菜单名称"
    // },{…},{…}]
    
    /**
     * YunTuNavlistDataResponse.java
     */
    private static final long                    serialVersionUID = 1L;
    
    private String                               id;
    
    private String                               name;
    
    private List<NewsSiteChannelBizDataResponse> navs;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public List<NewsSiteChannelBizDataResponse> getNavs()
    {
        return navs;
    }
    
    public void setNavs(List<NewsSiteChannelBizDataResponse> navs)
    {
        this.navs = navs;
    }
    
}
