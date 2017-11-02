/*
 * File name:  PeopleInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月23日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.jueyi.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月23日]
 */
public class PeopleInfoResponse implements Serializable
{
    
    /**
     * PeopleInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "usernumber":"工号",
    // "username":"姓名",
    
    private String            usernumber;
    
    private String            username;
    
    private String            icon;
    
    private boolean           isSelect;
    
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
    
    /**
     * 获取 usernumber
     * 
     * @return 返回 usernumber
     * @author wl
     */
    public String getUsernumber()
    {
        return usernumber;
    }
    
    /**
     * 设置 usernumber
     * 
     * @param usernumber 对usernumber进行赋值
     * @author wl
     */
    public void setUsernumber(String usernumber)
    {
        this.usernumber = usernumber;
    }
    
    /**
     * 获取 username
     * 
     * @return 返回 username
     * @author wl
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * 设置 username
     * 
     * @param username 对username进行赋值
     * @author wl
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * 获取 isSelect
     * 
     * @return 返回 isSelect
     * @author wl
     */
    public boolean isSelect()
    {
        return isSelect;
    }
    
    /**
     * 设置 isSelect
     * 
     * @param isSelect 对isSelect进行赋值
     * @author wl
     */
    public void setSelect(boolean isSelect)
    {
        this.isSelect = isSelect;
    }
    
}
