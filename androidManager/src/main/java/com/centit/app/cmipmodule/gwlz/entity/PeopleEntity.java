/*
 * File name:  PeopleEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  Administrator
 * Last modified date:  2015-7-11
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.gwlz.entity;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author Administrator
 * @Version [版本号, 2015-7-11]
 */
public class PeopleEntity
{
    private String  id;
    
    private String  name;
    
    private boolean selectedState;
    
    private String  roleId;
    
    private String  roleName;
    
    private boolean isUser;
    
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
    
    public boolean isSelectedState()
    {
        return selectedState;
    }
    
    public void setSelectedState(boolean selectedState)
    {
        this.selectedState = selectedState;
    }
    
    /**
     * 获取 roleId
     * 
     * @return 返回 roleId
     * @author rqj
     */
    public String getRoleId()
    {
        return roleId;
    }
    
    /**
     * 设置 roleId
     * 
     * @param roleId 对roleId进行赋值
     * @author rqj
     */
    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
    
    /**
     * 获取 roleName
     * 
     * @return 返回 roleName
     * @author rqj
     */
    public String getRoleName()
    {
        return roleName;
    }
    
    /**
     * 设置 roleName
     * 
     * @param roleName 对roleName进行赋值
     * @author rqj
     */
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    
    /**
     * 获取 isUser
     * 
     * @return 返回 isUser
     * @author rqj
     */
    public boolean isUser()
    {
        return isUser;
    }
    
    /**
     * 设置 isUser
     * 
     * @param isUser 对isUser进行赋值
     * @author rqj
     */
    public void setUser(boolean isUser)
    {
        this.isUser = isUser;
    }
    
}
